function f1() {
    var x = document.getElementById("var1").value;
    var arr = new Array();

    if(x < 1 || x > 19) {
        document.getElementById("res1").innerHTML = "";
        document.getElementById("alert1").className = "error"
        return;
    }else {
        document.getElementById("alert1").className = "hidden";
    }

    for(var i=1; i<20; i++){
        arr[i-1] = i;
    }

    var col = 0;
    document.getElementById("res1").innerHTML = "";

    var s = "";
    s += "<table border='1'>";
    for(var n of arr){
        if(col % 5 ==0) {
            s += "<tr>";
        } 
        s += "<td>" + x + " X " + n + " = " + x*n;
        if(col % 5 == 4){
            s += "</tr>";
        }
        col++;
    }
    s += "</table>";
    document.getElementById("res1").innerHTML += s;
}

var lotArr = new Array();

function f2() {
    document.getElementById("res2").innerHTML = "";
    var arr = new Array(6);

    for(var i=0; i<arr.length; i++){
        var x = Math.floor(Math.random()*44) + 1;
        if(arr.indexOf(x) == -1){
            arr[i] = x;
        }else{
            i--;
        }
    }
    for(var i=0; i<arr.length; i++) {
        var col = "";
        if(arr[i] > 0 && arr[i] <=10){
            col = "orange";
        }else if(arr[i] > 10 && arr[i] <= 20){
            col = "red";
        }else if(arr[i] > 20 && arr[i] <= 30){
            col = "gray";
        }else if(arr[i] > 30 && arr[i] <= 40){
            col = "green";
        }else if(arr[i] > 40 && arr[i] <= 45){
            col = "blue";
        }
        document.getElementById("res2").innerHTML += "<span class= 'lot' style='color:" + col + ";'>" + arr[i] + "</span>";
    }

    var sum = 0;
    for(var i=0; i<arr.length; i++){
        if(lotArr.indexOf(arr[i]) != -1){
            sum += 1;
        }
    }
    document.getElementById("res3").innerHTML = "";
    switch (sum) {
        case 6:
            document.getElementById("res3").innerHTML = "1등!";
            break;    
        case 5:
            document.getElementById("res3").innerHTML = "2등!";
            break;    
        case 4:
            document.getElementById("res3").innerHTML = "3등!";
            break;
        case 3:
            document.getElementById("res3").innerHTML = "4등!";
            break;
        default:
            document.getElementById("res3").innerHTML = "꽝!";    
            
    }
    
}

function colorLotto() {}

function myLotto() {
    document.getElementById("res2").innerHTML = "";
    s2 = document.getElementById("lotInput").value;
    lotArr = s2.split(',');
    if(lotArr.length < 6){
        document.getElementById("res1").innerHTML = "";
        document.getElementById("alert2").className = "error"
        return;
    }else {
        document.getElementById("alert2").className = "hidden";
    }
    
    var s = "";
    for(var i=0; i<lotArr.length; i++){
        if(lotArr[i] > 45 || lotArr[i] < 0 || isNaN(Number(lotArr[i])) == true){
            document.getElementById("res1").innerHTML = "";
            document.getElementById("alert3").className = "error";
            return;
        }else{
            document.getElementById("alert3").className = "hidden";
        }
        lotArr[i] = Number(lotArr[i]);
        s += lotArr[i];
    }

    for(var i=0; i<lotArr.length; i++) {
        var col = "";
        if(lotArr[i] > 0 && lotArr[i] <=10){
            col = "orange";
        }else if(lotArr[i] > 10 && lotArr[i] <= 20){
            col = "red";
        }else if(lotArr[i] > 20 && lotArr[i] <= 30){
            col = "gray";
        }else if(lotArr[i] > 30 && lotArr[i] <= 40){
            col = "green";
        }else if(lotArr[i] > 40 && lotArr[i] <= 45){
            col = "blue";
        }
        document.getElementById("lotRes").innerHTML += "<span class= 'lot' style='color:" + col + ";'>" + lotArr[i] + "</span>";
    }
    
}