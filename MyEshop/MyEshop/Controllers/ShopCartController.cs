using DataLayer.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MyEshop.Controllers
{
    public class ShopCartController : Controller
    {
        DataLayer.MyEshop_DBEntities db = new DataLayer.MyEshop_DBEntities();
        // GET: ShopCart
        public ActionResult ShowCart()
        {
            List<DataLayer.ViewModels.ShopCartItemViewModel> list = new List<DataLayer.ViewModels.ShopCartItemViewModel>();

            if (Session["ShopCart"] != null)
            {
                List<DataLayer.ViewModels.ShopCartItem> listShop = (List<DataLayer.ViewModels.ShopCartItem>)Session["ShopCart"];

                foreach (var item in listShop)
                {
                    var product = db.Products.Where(p => p.ProductID == item.ProductID).Select(p => new
                    {
                        p.ImageName,
                        p.Title
                    }).Single();
                    list.Add(new DataLayer.ViewModels.ShopCartItemViewModel()
                    {
                        Count = item.Count,
                        ProductID = item.ProductID,
                        Title = product.Title,
                        ImageName = product.ImageName

                    });
                }
            }

            return PartialView(list);
        }

        public ActionResult Index()
        {
            return View();
        }

        List<ShowOrderViewModel> getListOrder()
        {
            List<DataLayer.ViewModels.ShowOrderViewModel> list = new List<DataLayer.ViewModels.ShowOrderViewModel>();

            if (Session["ShopCart"] != null)
            {
                List<DataLayer.ViewModels.ShopCartItem> listShop = Session["ShopCart"] as List<DataLayer.ViewModels.ShopCartItem>;

                foreach (var item in listShop)
                {
                    var product = db.Products.Where(p => p.ProductID == item.ProductID).Select(p => new
                    {
                        p.ImageName,
                        p.Title,
                        p.Price
                    }).Single();
                    list.Add(new DataLayer.ViewModels.ShowOrderViewModel()
                    {
                        Count = item.Count,
                        ProductID = item.ProductID,
                        Price = product.Price,
                        ImageName = product.ImageName,
                        Title = product.Title,
                        Sum = item.Count * product.Price
                    });
                }
            }
            return list;
        }

        public ActionResult Order()
        {
            return PartialView(getListOrder());
        }

        public ActionResult CommandOrder(int id, int count)
        {
            List<DataLayer.ViewModels.ShopCartItem> listShop = Session["ShopCart"] as List<DataLayer.ViewModels.ShopCartItem>;
            int index = listShop.FindIndex(p => p.ProductID == id);
            if(count==0)
            {
                listShop.RemoveAt(index);
            }
            else
            {
                listShop[index].Count = count;
            }
            Session["ShopCart"] = listShop;

            return PartialView("Order", getListOrder());
        }

        [Authorize]
        public ActionResult Payment()
        {
            int userId = db.Users.Single(u => u.UserName == User.Identity.Name).UserID;
            DataLayer.Orders order = new DataLayer.Orders()
            {
                UserID = userId,
                Date = DateTime.Now,
                IsFinaly = false,
            };
            db.Orders.Add(order);

            var listDetails = getListOrder();

            foreach(var item in listDetails)
            {
                db.OrderDetails.Add(new DataLayer.OrderDetails()
                {
                    Count=item.Count,
                    OrderID=order.OrderID,
                     Price=item.Price,
                     ProductID=item.ProductID,
                });
            }
            db.SaveChanges();

            //TODO : Online Payment

            return null;
        }
    }
}