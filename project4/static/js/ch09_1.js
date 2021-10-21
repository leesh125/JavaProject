window.onload = function() {
    initial();
}

function initial() {
    var accordion = document.getElementsByClassName("accordion")[0];
    var accordion_items = accordion.querySelectorAll(".accordion-item");
    for(var item of accordion_items) {
        var title = item.querySelector(".accordion-title");
        title.addEventListener("click",
            function(e) {
                var src = e.target;
                var isOpend = src.getAttribute("class").indexOf("active") == -1 ? false : true;
                for(var other of accordion_items) {
                    other.querySelector(".accordion-title").classList.remove("active");
                    other.querySelector(".accordion-content").classList.remove("open");
                }

                if(isOpend) {
                    src.classList.remove("active");
                    src.nextElementSibling.classList.remove("open");
                } else {
                    src.classList.add("active");
                    src.nextElementSibling.classList.add("open");
                }
            }
        );
    }
} 