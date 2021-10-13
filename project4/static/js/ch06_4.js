x = 10; // 전역 변수
console.log(x);
func1();

function func1() {
    x = 20;
    console.log(x);
}

y = 30;
console.log(y);
func2();
console.log(y);

function func2(){
    var y = 40;
    z = 50;
    console.log(y);
    console.log(z);
}

function f1() {
    document.getElementById("res1").innerHTML = typeof("문자열");
}
