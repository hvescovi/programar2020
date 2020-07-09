$(function() { // quando o documento estiver pronto/carregado
    
    // código para mapear o click do link Listar
    $(document).on("click", "#linkListarPessoas", function() {
        $.ajax({
            url: 'http://localhost:5000/listar_pessoas',
            method: 'GET',
            dataType: 'json', // os dados são recebidos no formato json
            success: listar, // chama a função listar para processar o resultado
            error: function() {
                alert("erro ao ler dados, verifique o backend");
            }
        });
        function listar (pessoas) {
            // tornar a tabela visível
            mostrar_conteudo("tabelaPessoas");
      
            // percorrer a lista de pessoas retornadas; 
            for (var i in pessoas) { //i vale a posição no vetor
                lin = '<tr>' + // elabora linha com os dados da pessoa
                '<td>' + pessoas[i].nome + '</td>' + 
                '<td>' + pessoas[i].email + '</td>' + 
                '<td>' + pessoas[i].telefone + '</td>' + 
                '</tr>';
                // adiciona a linha no corpo da tabela
                $('#corpoTabelaPessoas').append(lin);
            }
        }
    });

    // função que mostra um conteúdo e esconde os outros
    function mostrar_conteudo(identificador) {
        // esconde todos os conteúdos
        $("#tabelaPessoas").addClass('invisible');
        $("#conteudoInicial").addClass('invisible');
        // torna o conteúdo escolhido visível
        $("#"+identificador).removeClass('invisible');      
    }

    // a função abaixo é executada quando a página abre
    mostrar_conteudo("conteudoInicial");

    // código para mapear click do link Inicio
    $(document).on("click", "#linkInicio", function() {
        mostrar_conteudo("conteudoInicial");
    });

    // código para mapear click do botão incluir pessoa
    $(document).on("click", "#btIncluirPessoa", function() {
        //pegar dados da tela
        nome = $("#campoNome").val();
        email = $("#campoEmail").val();
        tel = $("#campoTelefone").val();
        // preparar dados no formato json
        var dados = JSON.stringify({ nome: nome, email: email, telefone: tel })        
        alert("==>"+dados);
        // fazer requisição para o back-end
        $.ajax({
            url: 'http://localhost:5000/incluir_pessoa',
            type: 'POST',
            dataType: 'json', // os dados são recebidos no formato json
            contentType: 'application/json', //content type
            data: dados, // estes são os dados enviados
            //processData: false,            
            success: pessoaIncluida, // chama a função listar para processar o resultado
            error: erroAoIncluir
        });
        function pessoaIncluida (retorno) {
            if (retorno.resultado == "ok") { // a operação deu certo?
                // informar resultado de sucesso
                alert("Pessoa incluída com sucesso!");
                // limpar os campos
                $("#campoNome").val("");
                $("#campoEmail").val("");
                $("#campoTelefone").val("");
            } else {
                // informar mensagem de erro
                alert(retorno.resultado + ":" + retorno.detalhes);
            }            
        }
        function erroAoIncluir (retorno) {
            // informar mensagem de erro
            alert("ERRO: "+retorno.resultado + ":" + retorno.detalhes);
        }
    });

});
