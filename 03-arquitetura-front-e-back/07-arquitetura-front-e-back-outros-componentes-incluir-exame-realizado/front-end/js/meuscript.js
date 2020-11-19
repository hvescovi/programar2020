$(function() { // quando o documento estiver pronto/carregado
    
    // função para exibir pessoas na tabela
    function exibir_pessoas() {
        $.ajax({
            url: 'http://localhost:5000/listar_pessoas',
            method: 'GET',
            dataType: 'json', // os dados são recebidos no formato json
            success: listar, // chama a função listar para processar o resultado
            error: function(problema) {
                alert("erro ao ler dados, verifique o backend: ");
            }
        });
        function listar (pessoas) {
            // esvaziar o corpo da tabela
            $('#corpoTabelaPessoas').empty();
            // tornar visível a página de pessoas
            mostrar_conteudo("cadastroPessoas");      
            // percorrer a lista de pessoas retornadas; 
            for (var i in pessoas) { //i vale a posição no vetor
                lin = '<tr id="linha_'+pessoas[i].id+'">' + 
                '<td>' + pessoas[i].nome + '</td>' + 
                '<td>' + pessoas[i].email + '</td>' + 
                '<td>' + pessoas[i].telefone + '</td>' + 
                '<td><a href=# id="excluir_' + pessoas[i].id + '" ' + 
                  'class="excluir_pessoa"><img src="img/excluir.png" '+
                  'alt="Excluir pessoa" title="Excluir pessoa"></a>' + 
                '</td>' + 
                '</tr>';
                // adiciona a linha no corpo da tabela
                $('#corpoTabelaPessoas').append(lin);
            }
        }
    }

    // função que mostra um conteúdo e esconde os outros
    function mostrar_conteudo(identificador) {
        // esconde todos os conteúdos
        $("#cadastroPessoas").addClass('d-none');
        $("#conteudoInicial").addClass('d-none');
        $("#cadastroExamesRealizados").addClass('d-none');
        // torna o conteúdo escolhido visível
        $("#"+identificador).removeClass('d-none');      
    }

    // código para mapear o click do link Listar
    $(document).on("click", "#linkListarPessoas", function() {
        exibir_pessoas();
    });
    
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
        var dados = JSON.stringify({ nome: nome, email: email, telefone: tel });
        // fazer requisição para o back-end
        $.ajax({
            url: 'http://localhost:5000/incluir_pessoa',
            type: 'POST',
            dataType: 'json', // os dados são recebidos no formato json
            contentType: 'application/json', // tipo dos dados enviados
            data: dados, // estes são os dados enviados
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
            alert("erro ao incluir dados, verifique o backend: ");
        }
    });

    // código a ser executado quando a janela de inclusão de pessoas for fechada
    $('#modalIncluirPessoa').on('hide.bs.modal', function (e) {
        // se a página de listagem não estiver invisível
        if (! $("#cadastroPessoas").hasClass('d-none')) {
            // atualizar a página de listagem
            exibir_pessoas();
        }
    });

    // a função abaixo é executada quando a página abre
    mostrar_conteudo("conteudoInicial");

    // código para os ícones de excluir pessoas (classe css)
    $(document).on("click", ".excluir_pessoa", function() {
        // obter o ID do ícone que foi clicado
        var componente_clicado = $(this).attr('id'); 
        // no id do ícone, obter o ID da pessoa
        var nome_icone = "excluir_";
        var id_pessoa = componente_clicado.substring(nome_icone.length);
        // solicitar a exclusão da pessoa
        $.ajax({
            url: 'http://localhost:5000/excluir_pessoa/'+id_pessoa,
            type: 'DELETE', // método da requisição
            dataType: 'json', // os dados são recebidos no formato json
            success: pessoaExcluida, // chama a função listar para processar o resultado
            error: erroAoExcluir
        });
        function pessoaExcluida (retorno) {
            if (retorno.resultado == "ok") { // a operação deu certo?
                // remover da tela a linha cuja pessoa foi excluída
                $("#linha_" + id_pessoa).fadeOut(1000, function(){
                    // informar resultado de sucesso
                    alert("Pessoa removida com sucesso!");
                });
            } else {
                // informar mensagem de erro
                alert(retorno.resultado + ":" + retorno.detalhes);
            }            
        }
        function erroAoExcluir (retorno) {
            // informar mensagem de erro
            alert("erro ao excluir dados, verifique o backend: ");
        }
    });



    // função para exibir exames realizados
    // essa função é bem parecida com a função exibir_pessoas, certo? ;-)
    function exibir_exames_realizados() {
        $.ajax({
            url: 'http://localhost:5000/listar_exames_realizados',
            method: 'GET',
            dataType: 'json', // os dados são recebidos no formato json
            success: listar, // chama a função listar para processar o resultado
            error: function(problema) {
                alert("erro ao ler dados, verifique o backend: ");
            }
        });
        function listar (exames_realizados) {
            // esvaziar o corpo da tabela
            $('#corpoTabelaExamesRealizados').empty();
            // tornar visível a página de exames realizados
            mostrar_conteudo("cadastroExamesRealizados");      
            // percorrer a lista de exames realizados retornados; 
            for (var i in exames_realizados) { //i vale a posição no vetor
                lin = '<tr id="linha_exame_realizado_'+exames_realizados[i].id+'">' + 
                '<td>' + exames_realizados[i].data + '</td>' + 
                '<td>' + exames_realizados[i].resultado + '</td>' + 
                // dados da pessoa
                '<td>' + exames_realizados[i].pessoa.nome + '</td>' + 
                '<td>' + exames_realizados[i].pessoa.email + '</td>' + 
                '<td>' + exames_realizados[i].pessoa.telefone + '</td>' + 
                // dados do exame
                '<td>' + exames_realizados[i].exame.nome + '</td>' + 
                '<td>' + exames_realizados[i].exame.unidade + '</td>' + 
                '<td>' + exames_realizados[i].exame.vr + '</td>' + 
                '<td><a href=# id="excluir_exame_realizado_' + exames_realizados[i].id + '" ' + 
                  'class="excluir_exame_realizado"><img src="img/excluir.png" '+
                  'alt="Excluir exame realizado" title="Excluir exame realizado"></a>' + 
                '</td>' + 
                '</tr>';
                // adiciona a linha no corpo da tabela
                $('#corpoTabelaExamesRealizados').append(lin);
            }
        }
    }

    // código para mapear o click do link Exames Realizados
    $(document).on("click", "#linkListarExamesRealizados", function() {
        exibir_exames_realizados();
    });

    function carregarCombo(combo_id, nome_classe) {
        $.ajax({
            url: 'http://localhost:5000/listar/'+nome_classe,
            method: 'GET',
            dataType: 'json', // os dados são recebidos no formato json
            success: carregar, // chama a função listar para processar o resultado
            error: function(problema) {
                alert("erro ao ler dados, verifique o backend: ");
            }
        });
        function carregar (dados) {
            // esvaziar o combo
            $('#'+combo_id).empty();
            // mostra ícone carregando...
            $('#loading_'+combo_id).removeClass('d-none');
            // percorrer a lista de dados
            for (var i in dados) { //i vale a posição no vetor
                $('#'+combo_id).append(
                    $('<option></option>').attr("value", 
                        dados[i].id).text(dados[i].nome));
            }
            // espera um pouco, para ver o ícone "carregando"
            setTimeout(() => { 
                $('#loading_'+combo_id).addClass('d-none');
             }, 1000);
        }
    }

    $('#modalIncluirExameRealizado').on('shown.bs.modal', function (e) {
        // carregar as listas de pessoas e exames
        carregarCombo("campoPessoaId", "Pessoa");
        carregarCombo("campoExameId", "Exame");
    })

     // incluir exame realizado
     $(document).on("click", "#btIncluirExameRealizado", function() {
        //pegar dados da tela
        data = $("#campoData").val();
        resultado = $("#campoResultado").val();
        pessoa_id = $("#campoPessoaId").val();
        exame_id = $("#campoExameId").val();
        // preparar dados no formato json
        var dados = JSON.stringify({ data: data, resultado: resultado, pessoa_id: pessoa_id, exame_id: exame_id });
        // fazer requisição para o back-end
        $.ajax({
            url: 'http://localhost:5000/incluir_exame_realizado',
            type: 'POST',
            dataType: 'json', // os dados são recebidos no formato json
            contentType: 'application/json', // tipo dos dados enviados
            data: dados, // estes são os dados enviados
            success: dadosIncluidos, // chama a função listar para processar o resultado
            error: erroAoIncluir
        });
        function dadosIncluidos (retorno) {
            if (retorno.resultado == "ok") { // a operação deu certo?
                // informar resultado de sucesso
                alert("Dados incluídos com sucesso!");
                // limpar os campos
                $("#campoData").val("");
                $("#campoResultado").val("");
                $("#campoPessoaId").val("");
                $("#campoExameId").val("");
            } else {
                // informar mensagem de erro
                alert(retorno.resultado + ":" + retorno.detalhes);
            }            
        }
        function erroAoIncluir (retorno) {
            // informar mensagem de erro
            alert("erro ao incluir dados, verifique o backend: ");
        }
    });
    
});