$(function(){
	var search = location.search;
	var string;
	if(serarch.indexOf("?") != -1){
		string = search.split("=")[1];
	}
    
	$.ajax({
		type: "POST",
		url: "/showProducts",
		data: {"id":string},
		dataType: "json",
		success: function(data){
			var products = eval(data);
			for(var i in products){
				
			}
		},
		error:function(){
			
		}
	})
})