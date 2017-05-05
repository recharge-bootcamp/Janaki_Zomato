/**
 * 
 */
function checkSearchType() 
	{ 
	alert("hello");
	alert(document.getElementsByName("welcome:restaurants").length);
	for(var i=0;i<=document.getElementsByName("welcome:resId").length;i++){
		
		alert(document.getElementById("welcome:resId")[i].checked);
	if(document.getElementById("welcome:resId")[i].checked){ 
	resId= document.getElementById("welcome:resId")[i].value 
	alert(resId);
	} 
	} 
	alert(resId);
	}