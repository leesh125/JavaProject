document.write("<h1 id='title1'>웹 브라우저 화면에 출력!</h1>");
console.log("브라우저 콘솔에 출력!");

function changeTitle() {
    document.getElementById('title1').innerHTML = "태그의 요소를 선택 후 내용 삽입";
}

function activeInput() {
    var userInput = window.prompt("사용자 입력 프롬프트 활성화");
    console.log(userInput);
    document.getElementById("title1").innerHTML = userInput;
}

function changeValue() {
    var userInput = document.getElementById("user_input").value;
    document.getElementById("title1").innerHTML = userInput;
}