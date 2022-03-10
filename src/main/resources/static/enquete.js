var enquete = {
	
	formar_enquete: function(params) {
        var url = 'http://localhost:8083/enquete';
        
        // campos do form
        var filme1 = $('#f1').val();
        var filme2 = $('#f2').val();
        
        $.ajax({
            url:url,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            charset:'UTF-8',
            //crossDomain: true,
            data: JSON.stringify([{"filme1" : filme1}, {"filme2" : filme2}]),
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