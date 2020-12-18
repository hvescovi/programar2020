import gi, os
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

builder = Gtk.Builder()

def acao_btn_ok_click(button):
    txt_nome = builder.get_object("txt_nome");
    lbl_mensagem = builder.get_object('lbl_mensagem')
    lbl_mensagem.set_text("Seu nome é: "+txt_nome.get_text())

handlers = {
    "fechar": Gtk.main_quit,
    "btn_ok_click": acao_btn_ok_click
}

caminho = os.path.dirname(os.path.abspath(__file__))
arquivo = os.path.join(caminho, 'janela-basica.glade')
builder.add_from_file(arquivo)
builder.connect_signals(handlers)
window = builder.get_object("window1") # referência da janela
window.show_all()
Gtk.main()