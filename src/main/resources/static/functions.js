$(document).ready(function(){
	$("#ngo").click(function(){
		$.ajax({
			url : "http://localhost:8080/place/list",
			success : function(data){
				$("#ngoform").attr('style',"");
				$("#places").html("");
				for(i = 0;i < data.length;i++){
					$("#places").append("<option value='"+ data[i].id+"'>" + data[i].address + "</option>");
				}
			}
		});
	});

	$("#submitNGO").click(function(){
	    var json = {};
	    json.placeId = $("#places").val();
	    json.ngoName = $("#ngoName").val();

	    $.ajax({
	        type : 'POST',
	        data :  JSON.stringify(json),
	        contentType: "application/json",
            url : "http://localhost:8080/hub/add",
            success : function(data){
                console.log("Added");
            }
        });
	});
});
});

function togglePlaceForm(){
    $("#placeform").toggle();
}

function addPlace(){
    var address =  $("#place_address").val();
    var name =  $("#owner_name").val();
    var phone_num = $("#owner_phone_num").val();
    var d = {};
    d.ownername = name;
    d.ownercontact = phone_num;
    d.address = address;
    $.ajax({
        type : "POST",
        url : "/place/add",
        data : JSON.stringify(d),
        contentType : "application/json",
        success : function(r,d){
            console.log(r);
            console.log(d);
        }
    });
}
