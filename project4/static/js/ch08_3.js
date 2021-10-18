function hiddenPass(element) {
    var c = element.checked;
    if(c == true) {
        document.getElementById("id_pass").type = "text";
    } else {
        document.getElementById("id_pass").type = "password";
    }
}