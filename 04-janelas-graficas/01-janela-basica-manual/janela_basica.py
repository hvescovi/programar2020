import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

class JanelaBasica(Gtk.Window):

    def __init__(self):
        # executar o método construtor da janela
        Gtk.Window.__init__(self, title="Janela básica")
        # criar um layout vertical, 6 pixels entre cada componente
        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=6)
        box.set_property("margin", 8) # adicionar uma borda na janela
        self.add(box) # inserir o layout na janela
        self.msg = Gtk.Label("Digite o seu nome: ") # criar um rótulo na janela
        box.pack_start(self.msg, True, True, 0) # adicionar o rótulo ao layout
        # criar um layout horizontal para por caixa de entrada ao lado do botão
        hbox = Gtk.Box() # padrão: horizontal
        # criar uma caixa de texto e adicioná-la ao layout horizontal
        self.nome = Gtk.Entry()
        hbox.pack_start(self.nome, True, True, 0)
        self.button = Gtk.Button(label="Ok") # criar botão "Ok"
        # associar evento de clique ao botão
        self.button.connect("clicked", self.acao_clique)
        # adicionar botão ao layout horizontal
        hbox.pack_start(self.button, True, True, 0)
        # adicionar layout horizontal ao layout vertical
        box.pack_start(hbox, True, True, 0)
        # criar rótulo na janela para mensagem pós-clique
        self.msg2 = Gtk.Label()
        self.msg2.set_width_chars(20)
        # adicionar no layout vertical
        box.pack_start(self.msg2, True, True, 0)

    #  evento de clique no botão
    def acao_clique(self, widget):
        # colocar no segundo rótulo o conteúdo da caixa de texto
        self.msg2.set_label("Seu nome é: "+self.nome.get_text())

win = JanelaBasica() # instanciar janela
win.connect("destroy", Gtk.main_quit) # encerrar o programa ao fechar a janela
win.set_position(Gtk.WindowPosition.CENTER) # centralizar janela
win.show_all() # exibir janela
Gtk.main() # início do gtk (loop contínuo)