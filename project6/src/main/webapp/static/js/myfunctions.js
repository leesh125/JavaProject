/**
 * 
 */
window.onload = function() {
	var monthElement = document.getElementsByName("month");
	for(var element of monthElement) {
		for(var i = 1; i <= 12; i++) {
			var option = document.createElement("option");
			option.value = i;
			option.innerText = i + "월";
			element.append(option);
		}
	}
} 