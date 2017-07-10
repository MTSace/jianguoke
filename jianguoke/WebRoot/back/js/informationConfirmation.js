var a=document.getElementById("confirmationList").value;
alert(a);
a.style.color="red";
a.onClick=function(){
	window.location.href='#panel';
}