$( document ).ready(function() {
    
    $("#conteudoInicial").removeClass("invisible");

    $("#link_listar_plantas").click(function(){
        
        $.ajax({
            url: 'http://localhost:5000/listar_plantas',
            method: 'GET',
            dataType: 'json', // os dados são recebidos no formato json
            success: listar_plantas, // chama a função listar_plantas para processar o resultado
            error: function() {
                alert("erro ao ler dados, verifique o backend");
            }
        });
        function listar_plantas(plantas) {
            // inicializar um acumulador
            linhas = ""
            // percorrer as plantas retornadas em json
            for (var i in plantas) {

              // montar uma linha da tabela de plantas
              lin = "<tr>" + 
              "<td>" + plantas[i].nome + "</th>" + 
              "<td>" + plantas[i].nome_cientifico + "</td>" + 
              "<td>" + plantas[i].tamanho_folha + "</td>" + 
              "<td>" + plantas[i].periodo_poda + "</td>" +
              "</tr>";

              // adicionar a linha da tabela em um acumulador
              linhas = linhas + lin;
            }
            // colocar as linhas na tabela
            $("#corpoTabelaPlantas").html(linhas);

            // esconder todos os elementos da tela
            $("#conteudoInicial").addClass("invisible");
            $("#tabelaPlantas").addClass("invisible");

            // exibir a tabela
            $("#tabelaPlantas").removeClass("invisible");
        }

    });

  });