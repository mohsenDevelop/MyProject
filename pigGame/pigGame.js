var scores = [0, 0];
var holdScores = [0, 0];

var activeUser = false;

var maxValue = 0;
var status = 1;


var firstUserScore = document.getElementById('first-user-score-current');
var firstHoldUserScore = document.getElementById('first-user-score');
var secondUserScore = document.getElementById('second-user-score-current');
var secondHoldUserScore = document.getElementById('second-user-score');
var rollDice = document.getElementById('btn-roll-dice');
var holdOn = document.getElementById('btn-hold-on');
var roll = document.getElementById('dice-result1');  
var roll2 = document.getElementById('dice-result2');  
var winner = document.getElementById('winner');
var winnerResult = document.getElementById('result-show');
var btnReset = document.getElementById('resetBtn');
var btnHoldOn = document.getElementById('btn-hold-on');
var btnValue = document.getElementById('btnStart');
var conditionValue = document.getElementById('getScore');


roll.style.color = "rgb(57, 38, 110)";
roll.style.fontSize = "50px";

roll2.style.color = "rgb(57, 38, 110)";
roll2.style.fontSize = "50px";

document.getElementById('btn-roll-dice').addEventListener('click', () => {

    if(status == 1) {
        var number1 = Math.floor((Math.random() * 6)) + 1; 
        var number2 = Math.floor((Math.random() * 6)) + 1; 

        showDice1(number1);
        showDice2(number2);
        
        if(number1 != 1 || number2 != 1) {

            if(activeUser == false) {
                scores[0] += number1;
                holdScores[0] += number1;
                firstUserScore.innerText = scores[0];
                firstHoldUserScore.innerText =  holdScores[0]
                secondUserScore.innerText = 0;
        
            }else {
                scores[1] += number1;
                holdScores[1] += number1;
                secondUserScore.innerText = scores[1];
                secondHoldUserScore.innerText = holdScores[1]
                firstUserScore.innerText = 0;
            }
            
            isWinner();
        
            }else {
                
                if(activeUser == false) {
                    scores[0] = 0;
                    firstUserScore.innerText = 0;
                }else {
                    scores[1] = 0;
                    secondUserScore.innerText = 0;
                }
        
                changeUser(activeUser);
        
            }
    }
    


});
btnValue.addEventListener('click', () => {
    maxValue = conditionValue.value;
    conditionValue.disabled = true;
});


btnHoldOn.addEventListener('click', () => {
    changeUser(activeUser);
});

btnReset.addEventListener('click', () => {
    scores[0] = 0;
    scores[1] = 0;
    holdScores[0] = 0;
    holdScores[1] = 0;

    firstUserScore.innerText = 0;
    firstHoldUserScore.innerText = 0;

    secondUserScore.innerText = 0;
    secondHoldUserScore.innerText = 0;

    conditionValue.disabled = false;
    conditionValue.value = "";

    status = 1;
    
    winner.style.display = 'none';
    btnReset.style.display = 'none';
});


const showDice1 = n1 => {
    
    if(n1 == 1) {
        roll.className = "fa fa-dice-one";
    }else if (n1 == 2) {
        roll.className = "fa fa-dice-two";
    }else if (n1 == 3) {
        roll.className = "fa fa-dice-three";
    }else if(n1 == 4) {
        roll.className = "fa fa-dice-four";
    }else if (n1 == 5) {
        roll.className = "fa fa-dice-five";
    }else if (n1 == 6) {
        roll.className = "fa fa-dice-six";
    }

};
const showDice2 = n2 => {
    if(n2 == 1) {
        roll2.className = "fa fa-dice-one";
    }else if (n2 == 2) {
        roll2.className = "fa fa-dice-two";
    }else if (n2 == 3) {
        roll2.className = "fa fa-dice-three";
    }else if(n2 == 4) {
        roll2.className = "fa fa-dice-four";
    }else if (n2 == 5) {
        roll2.className = "fa fa-dice-five";
    }else if (n2 == 6) {
        roll2.className = "fa fa-dice-six";
    }
};


const changeUser = () => {

    activeUser == false ? activeUser = true : activeUser = false;
};

const isWinner = () => {
    if(holdScores[0] >= maxValue || holdScores[1] >= maxValue) {
        let won = (activeUser == false) ? 1 : 2;
        status = 0;
        showWinner(won);
    }
};

const showWinner = won => {
    winner.style.display = 'block';
    btnReset.style.display = 'block';
    if(won == 1) {
        winnerResult.innerText = "First User Woooonnnn...";
    }else {
        winnerResult.innerText = "Second User Woooonnnn...";
    }
};