function calc(){
    document.getElementById("res").className = "res";
    var x = Number(document.getElementById("denominator").value);
    var y = Number(document.getElementById("numerator").value);
    var op = document.getElementById("op").value;

    switch(op) {
        case 'plus':
            document.getElementById("res").value = x + y;
            break;
        case 'minus':
            document.getElementById("res").value = x - y;
            break;
        case 'divide':
            document.getElementById("res").value = x / y;
            break;
        case 'multiply':
            document.getElementById("res").value = x * y;
            break;    
        case 'remainder':
            document.getElementById("res").value = x % y;
            break;
    }

    if(y == 0 && op == 'divide' || op == 'remainder'){
        document.getElementById("res").value = "연산불가";
        document.getElementById("res").className = "error";
    }
}

arr = new Array();
s1 = "";
s2 = "";

function calculator(id) {
    var x = document.getElementById(id).innerHTML;
    this.arr.push(x);
    
    document.getElementById("tdspan").innerHTML += x;

    if(x == '='){
        for(var i=0; i<arr.length-1; i++){
            s2 += arr[i];
        }
        document.getElementById("tdspan").innerHTML = eval(s2);
    }

}