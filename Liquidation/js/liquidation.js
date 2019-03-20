
var selector = document.getElementById('mySelect');
var moneyValue = document.getElementById('moneyValue');
var showDrop = document.getElementById('showDrop');

var netMoney = document.getElementById('net');
var incomeMoney = document.getElementById('income');
var expensesMoney = document.getElementById('expenses');

var resultIncome = document.getElementById('resultIncome');
var resultEspenses = document.getElementById('resultEspenses');


document.getElementById('btnSub').addEventListener('click', () => {


    if(selector.value == "1"){
    
        incomeMoney.innerText = "+" + moneyValue.value;
        netMoney.innerText = (parseInt(netMoney.innerHTML)  + parseInt(moneyValue.value)).toString();

        resultIncome.innerHTML += " <p class='w3-container w3-panel w3-border w3-hover-border-green w3-padding-16 w3-animate-left ' style='width : 200px; margin-left: 80px;'><span class='w3-margin-right'>"+ showDrop.value+"</span> "+incomeMoney.innerText+" </p>";

    }
    
    
    if (selector.value == "2"){

        expensesMoney.innerText = "-" + moneyValue.value;
        netMoney.innerText -= moneyValue.value;

        resultEspenses.innerHTML +=  " <p class='w3-container w3-panel w3-border w3-hover-border-red w3-padding-16 w3-animate-right ' style='width : 200px; margin-left: 80px;'><span class='w3-margin-right'>"+ showDrop.value+"</span> "+expensesMoney.innerText+" </p>";
    }



    


});