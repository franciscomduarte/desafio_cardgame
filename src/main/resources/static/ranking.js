$(document).ready(function() {
	
	var urlParams = new URLSearchParams(location.search);
    var id = urlParams.get('id');
	
	$.getJSON('http://localhost:8083/quiz/'+id, function(json) {
	  // Loop over the JSON array.

      console.log(JSON.stringify(json.enquetes));
	});
	
});

var ranking = {

}