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
            //crossDomain: true,
            data: JSON.stringify({'nome': nome}),
            success:function(data){
				console.log(data);
			}
        }).done(function(retorno) {
			console.log(retorno);
			//alert('Quiz cadastrado com sucesso!');
        })
        .fail(function(response) {
			console.log(response);
			//alert('Quiz não cadastrado!');
        });
    },
	
}