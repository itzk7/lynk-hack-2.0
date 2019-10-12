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

	$("#supply").click(function(){
	    $("#supplyForm").attr('style',"");
	});

	$("#Item").click(function(){
	    var index = $("#items").children().length + 1;
	    $("#items").append("<input type='text' id='item_"+ index +"' placeholder='Food/Bedsheets/Napkins'>"
    	+"<input type='text' id='item_count_"+ index +"' placeholder='Number of items'><br>");
	})

	$("#submitSuplpy").click(function(){
	    var data = {};
	    data.name = $("#supplyName").val();
	    data.address = $("#supplyaddress").val();
	    data.numberOfPeople = $("#peopleCount").val();
	    data.phoneNumber = $("#phoneNumber").val();
	    var res = {};
	    var items = $("#items").children();
	    for(i = 0;i < items.length;i++){
	        if($("#item_" + (i + 1)).val() != undefined)
	            res[$("#item_" + (i + 1)).val()] = $("#item_count_" + (i + 1)).val();
	    }
	    data.resourceDetails = res;

	    $.ajax({
	        type : 'POST',
            data :  JSON.stringify(data),
            contentType: "application/json",
            url : "http://localhost:8080/supply/",
            success : function(data){
                console.log("Added");
            }
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