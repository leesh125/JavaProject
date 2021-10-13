function getId(){
    console.log(document.getElementById("username"));
    console.log(document.getElementById("password"));
}

function getName(){
    console.log(document.getElementsByName("username")[0]);
    console.log(document.getElementsByName("password")[0]);
    console.log(document.getElementsByName("password")[1]);
}

function getTagName(){
    console.log(document.getElementsByTagName("input")[6]);
    console.log(document.getElementsByTagName("input")[7]);
    console.log(document.getElementsByTagName("input")[8]);
}

function getClass() {
    console.log(document.getElementsByClassName("input-form")[0]);
    console.log(document.getElementsByClassName("input-form")[1]);
    console.log(document.getElementsByClassName("input-form")[2]);
}

function getSelector() {
    console.log(document.querySelector("input"));
    console.log(document.querySelector("input").value);

    console.log(document.querySelector("#password"));
    console.log(document.querySelector("#password").value);

    console.log(document.querySelector(".input-form"));
    console.log(document.querySelector(".input-form").value);
}

function getSelectorAll() {
    console.log(document.querySelectorAll("input"));
    console.log(document.querySelectorAll("#password"));
    console.log(document.querySelectorAll(".input-form"));
}