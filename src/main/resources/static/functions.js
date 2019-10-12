$(document).ready(function(){
	$("#ngo").click(function(){
		$.ajax({
			url : "http://localhost:8080/place/list",
			success : function(data){
				console.log(data);
			}
		});
	});
});