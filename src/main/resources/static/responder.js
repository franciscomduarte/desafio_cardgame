$(document).ready(function() {
	
	var urlParams = new URLSearchParams(location.search);
    var id = urlParams.get('id');
	
	$.getJSON('http://localhost:8083/enquete/'+id, function(json) {
	  // Loop over the JSON array.
	  var div_filme1 =  $("#filme1");
	  var div_filme2 =  $("#filme2");

	  var filme1 = "";
	  var filme2 = "";
	  filme1 += "<div><img src='" + json.filmes[0].poster + "'/></div>";
	  filme1 += "<b>Título:</b>" + json.filmes[0].title;
	  filme1 += "<br><b>Ano:</b>:" + json.filmes[0].year;
	  filme1 += "<br><b>Diretor:</b>" + json.filmes[0].director;
	  filme1 += "<br><b>Atores:</b>" + json.filmes[0].actors;
	  filme1 += "<br>É esse! <input type='radio' name='filme_escolhido' value='" + json.filmes[0].id + "'></input><br><br><br><br>";
	  
	  filme2 += "<div><img src='" + json.filmes[1].poster + "'/></div>";
	  filme2 += "Título:" + json.filmes[1].title;
	  filme2 += "<br><b>Ano:</b>:" + json.filmes[1].year;
	  filme2 += "<br><b>Diretor:</b>" + json.filmes[1].director;
	  filme2 += "<br><b>Atores:</b>" + json.filmes[1].actors;
	  filme2 += "<br>É esse! <input type='radio' class='form-check-input' name='filme_escolhido' value='" + json.filmes[1].id + "'></input>";
	  
      div_filme1.html(filme1);
      div_filme2.html(filme2);
      console.log(json);
	});
	
	$('#form_responder').submit(function(e) {
        enquete.responder(this.action, $(this).serialize());
        e.preventDefault();
    });
	
});

var enquete = {
	
	responder: function(params, form) {
		
        var urlParams = new URLSearchParams(location.search);
        var idEnquete = urlParams.get('id');
        
        var url = 'http://localhost:8083/enquete/'+idEnquete;
        var idFilme = $("input[name='filme_escolhido']:checked").val();
        
        $.ajax({
            url:url,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            charset:'UTF-8',
            data: JSON.stringify({'idFilme' : idFilme}),
            success:function(data){
				console.log(data);
			}
        }).done(function(retorno) {
			console.log(retorno);
			location.href = document.referrer;
        })
        .fail(function(response) {
			console.log(response);
        });
    },
	

}