package com.kermanifar.mohsen.myfirstapp.datafake;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.datamodel.AppFeature;
import com.kermanifar.mohsen.myfirstapp.datamodel.Cloth;
import com.kermanifar.mohsen.myfirstapp.datamodel.Post;
import com.kermanifar.mohsen.myfirstapp.view.activity.BotickActivity;
import com.kermanifar.mohsen.myfirstapp.view.activity.PostsActivity;
import com.kermanifar.mohsen.myfirstapp.view.activity.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class DataFakeGenerator {

//    public static List<Post> getData(Context context) {
//
//        List<Post> posts = new ArrayList<>();
//        for (int i = 1; i <= 6 ; i++) {
//            Post post = new Post();
//
//            post.setPostId(i);
//            post.setPostTitle("لورم ایپسوم متن ساختگی");
//            post.setPostContent("لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است. چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد.");
//            post.setPostDate("2 ساعت پیش");
//
//            switch (i) {
//                case 1 :
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic1, null));
//                    break;
//
//                case 2:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic2, null));
//                    break;
//
//                case 3:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic3, null));
//                    break;
//
//                case 4:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic4, null));
//                    break;
//
//                case 5:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic5, null));
//                    break;
//
//                case 6:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic6, null));
//                    break;
//            }
//
//            posts.add(post);
//        }
//        return posts;
//    }

    public  static List<Cloth> getClothes(Context context) {
        List<Cloth> cloths = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            Cloth cloth = new Cloth();

            cloth.setId(i);
            cloth.setTxtTile("لورم ایپسن ساختکی");
            cloth.setViewCount(700);

            switch (i) {
                case 1 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic1_clothes, null));
                    break;

                case 2 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic2__clothes, null));
                    break;

                case 3 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic3_clothes, null));
                    break;

                case 4 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic4_clothes, null));
                    break;

                case 5 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic5_clothes, null));
                    break;

                case 6 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic6_clothes, null));
                    break;

                case 7 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic7_clothes, null));
                    break;

                case 8 :
                    cloth.setImageItem(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic8_clothes, null));
                    break;


            }

            cloths.add(cloth);

        }
        return cloths;

     }

    public static List<AppFeature> getAppFeature(Context context) {
        List<AppFeature> appFeatures = new ArrayList<>();

        AppFeature appFeature = new AppFeature();
        appFeature.setId(appFeature.ID_POST_ACTIVITY);
        appFeature.setCaption(context.getString(R.string.app_feature_last_post));
        appFeature.setImageFeature(R.drawable.posts);
        appFeature.setDestinationActivity(PostsActivity.class);
        appFeatures.add(appFeature);

        appFeature = new AppFeature();
        appFeature.setId(appFeature.ID_USER_POFILE);
        appFeature.setCaption(context.getString(R.string.app_feature_user_profile));
        appFeature.setImageFeature(R.drawable.user_profile);
        appFeature.setDestinationActivity(ProfileActivity.class);
        appFeatures.add(appFeature);

        appFeature = new AppFeature();
        appFeature.setId(appFeature.ID_FATION);
        appFeature.setCaption(context.getString(R.string.app_feature_fashion2));
        appFeature.setImageFeature(R.drawable.fashion);
        appFeature.setDestinationActivity(BotickActivity.class);
        appFeatures.add(appFeature);

        appFeature = new AppFeature();
        appFeature.setId(appFeature.ID_MUSIC);
        appFeature.setCaption(context.getString(R.string.app_feature_music));
        appFeature.setImageFeature(R.drawable.music_player);
        appFeature.setDestinationActivity(null);
        appFeatures.add(appFeature);

        appFeature = new AppFeature();
        appFeature.setId(appFeature.ID_VIDEO);
        appFeature.setCaption(context.getString(R.string.app_feature_video));
        appFeature.setImageFeature(R.drawable.video_player);
        appFeature.setDestinationActivity(null);
        appFeatures.add(appFeature);

        appFeature = new AppFeature();
        appFeature.setId(appFeature.ID_LOG_IN);
        appFeature.setCaption(context.getString(R.string.app_feature_log_in));
        appFeature.setImageFeature(R.drawable.login);
        appFeature.setDestinationActivity(null);
        appFeatures.add(appFeature);


        return appFeatures;
    }
}

