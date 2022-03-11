$(document).ready(function() {
	
    $.getJSON('http://localhost:8083/quiz', function(json) {
	  // Loop over the JSON array.
	  var tabela =  $("#table_quiz");
	  var rows = "";
      json.forEach(function(item) {
        rows += "<tr>";
        rows += " <td>" + item.id + "</td>";
        rows += " <td>" + item.nome + "</td>";
        rows += " <td><a href='/enquete?id=" + item.id + "'>Criar enquetes</a>";
        rows += " | <a href='/ranking?id=" + item.id + "'>Ver Ranking</a></td>";
        rows += "</tr>";
      });
      tabela.find("tbody").html(rows);
	});
	
	$.getJSON('http://localhost:8083/quiz', function(json) {
	  // Loop over the JSON array.
	  var tabela =  $("#table_responder_quiz");
	  var rows = "";
      json.forEach(function(item) {
        rows += "<tr>";
        rows += " <td>" + item.id + "</td>";
        rows += " <td>" + item.nome + "</td>";
        rows += " <td><a href='/enquete?id=" + item.id + "'>Responder</a></td>";
        rows += "</tr>";
      });
      tabela.find("tbody").html(rows);
	});
	
	$('#form_quiz').submit(function(e) {
        quiz.cadastrar(this.action, $(this).serialize());
        e.preventDefault();
    });
	
});

var quiz = {
	
	cadastrar: function() {
        var url = 'http://localhost:8083/quiz';
        
        // campos do form
        var nome = $('#nome').val();
        
        $.ajax({
            url:url,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            charset:'UTF-8',
            data: JSON.stringify({'nome': nome}),
            success:function(data){
				console.log(data);
			}
        }).done(function(retorno) {
			console.log(retorno);
			location.reload();
			//alert('Quiz cadastrado com sucesso!');
        })
        .fail(function(response) {
			console.log(response);
			//alert('Quiz não cadastrado!');
        });
    },
	
}