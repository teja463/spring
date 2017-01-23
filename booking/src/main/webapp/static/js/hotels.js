$(function(){
	$("#cities").change(function(){
		var city = $(this).val();
//		console.log("city changed to"+city);
		$.ajax({
			url:"/booking/hotels/list?city="+city,
			success : function(data){
//				alert("received : "+data);
//				console.log("data : "+data);
				$("#citiesTable").html(data);
			},
			error : function(error, msg){
//				alert("error : "+error +" msg : "+msg);
//				console.log("error : "+error +" msg : "+msg);
				$("#citiesTable").html(error);
			}
		});
	});
});