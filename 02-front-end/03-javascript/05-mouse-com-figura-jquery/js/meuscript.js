// inicialmente, deve-se mover o carro; 
// criamos uma variável para controle, se o carro se move ou não
// 1 significa que deve mover, zero significa não mover
var mover = 1

// quando houver um movimento de mouse na janela atual
$(window).mousemove(function(event) {

    // é pra mover o carro?
    if (mover == 1) {
        // posicione a imagem no local do mouse
        $("#carro").css({
            top: event.pageY,
            left: event.pageX
        });
    }
});

// quando houver um clique na janela
$(window).click(function() {
    // inverte a situação de mover o carro
    mover == 1 ? mover = 0 : mover = 1;
});