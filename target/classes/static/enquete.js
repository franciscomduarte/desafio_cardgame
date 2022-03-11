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
	
	$.getJSON('http://localhost:8083/enquete', function(json) {
	  // Loop over the JSON array.
	  var tabela =  $("#table_enquete");
	  var rows = "";
      json.forEach(function(item) {
        rows += "<tr>";
        rows += " <td>" + item.id + "</td>";
        rows += " <td>" + item.quiz.nome + "</td>";
        rows += " <td>" + item.filmes[0].title+ "</td>";
        rows += " <td>" + item.filmes[1].title+ "</td>";
        rows += " <td>" + (item.respondida == true ? 'Sim' : 'Não') + "</td>";
        var link = "<a href='/responder?id=" + item.id + "'>Responder enquete</a>";
        rows += " <td>" + (item.respondida == true ? '-' : link ) + "</td>";
        rows += "</tr>";
      });
      tabela.find("tbody").html(rows);
	});
	
	$('#form_enquete').submit(function(e) {
        enquete.formar_enquete(this.action, $(this).serialize());
        e.preventDefault();
    });
	
});

var enquete = {
	
	formar_enquete: function() {
        var url = 'http://localhost:8083/enquete';
        
        var urlParams = new URLSearchParams(location.search);
        var id = urlParams.get('id');
        
        // campos do form
        var filme1 = $('#f1').val();
        var filme2 = $('#f2').val();
        
        $.ajax({
            url:url,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            charset:'UTF-8',
            data: JSON.stringify({'filme1' : filme1, 'filme2' : filme2, 'id' : id}),
            success:function(data){
				console.log(data);
			}
        }).done(function(retorno) {
			console.log(retorno);
			location.reload();
        })
        .fail(function(response) {
			console.log(response);
        });
    },

}