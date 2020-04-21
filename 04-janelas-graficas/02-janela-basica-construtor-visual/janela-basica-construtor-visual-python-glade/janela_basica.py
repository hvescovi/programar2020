import gi
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

builder.add_from_file("/home/friend/01-github/programar2020/04-janelas-graficas/02-janela-basica-construtor-visual/janela-basica-construtor-visual-python-glade/janela_basica.glade")
builder.connect_signals(handlers)
window = builder.get_object("window1") # referência da janela
window.show_all()
Gtk.main()