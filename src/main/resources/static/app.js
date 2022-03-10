$(document).ready(function() {
	
	var dataList1 = document.getElementById('filme1');
	var dataList2 = document.getElementById('filme2');
	
	$.getJSON('http://localhost:8083/filme', function(json) {
	  // Loop over the JSON array.
      json.forEach(function(item) {
        // Create a new <option> element.
        var option = document.createElement('option');
        // Set the value using the item in the JSON array.
        option.value = item.title;
        option.id = item.id;
        // Add the <option> element to the <datalist>.
        dataList1.appendChild(option);
        //dataList2.appendChild(option);
      });
	});
	
	$.getJSON('http://localhost:8083/filme', function(json) {
	  // Loop over the JSON array.
      json.forEach(function(item) {
        // Create a new <option> element.
        var option = document.createElement('option');
        // Set the value using the item in the JSON array.
        option.value = item.title;
        option.id = item.id;
        // Add the <option> element to the <datalist>.
        dataList2.appendChild(option);
      });
	});
	
	$('#form_quiz').submit(function(e) {
        quiz.cadastrar(this.action, $(this).serialize());
        e.preventDefault();
    });
    
    $('#form_enquete').submit(function(e) {
        enquete.formar_enquete(this.action, $(this).serialize());
        e.preventDefault();
    });
    
    
	
});