function f1() {
    var x = document.getElementById("var1").value;
    if (x % 2 == 0) { 
        document.getElementById("res1").innerHTML = "짝수입니다.";
    } else {
        document.getElementById("res1").innerHTML = "홀수입니다.";
    } 
}

function f2() {
    var x = Number(document.getElementById("var2").value);
    switch (x) {
        case 1 :
            document.getElementById("res2").innerHTML = "1 입니다.";
            break;
        case 2 :
            document.getElementById("res2").innerHTML = "2 입니다.";
            break;
        default:
            document.getElementById("res2").innerHTML = "1 또는 2가 아닙니다.";
    }
}

function f3() {
    document.getElementById("res3").innerHTML = "";
    x = document.getElementById("var3").value;

    for(var i = 0; i < x; i++) {
        document.getElementById("res3").innerHTML += (i+1 + " ");
    }
}

function f4() {
    document.getElementById("res4").innerHTML= "";
    x = document.getElementById("var4").value;
    var i = 0;
    while(i < x){
        document.getElementById("res4").innerHTML += (i+1 + " ");
        i++;
    }
}

function f5() {
    var obj = {a: 1, b: 2, c: 3, d: 4}
    for(var name in obj) {
        document.getElementById("res5").innerHTML += name + ": " + obj[name] + "<br>";
    }
}

function f6() {
    var obj = [1, 2, 3, 4];
    for(var v of obj) {
        document.getElementById("res6").innerHTML += v + "<br>";
    }
}