package visao;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class JanelaBasica {

    public static void criar() {
        // criar a janela e configurar tamanho e ação de fechamento
        JFrame j = new JFrame("Janela básica");
        j.setPreferredSize(new Dimension(250, 130));
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // configurar layout da janela
        j.getContentPane().setLayout(new FlowLayout());
        // criar um texto (rótulo)
        JLabel msg = new JLabel("Digite o seu nome: ");
        // adicionar a mensagem na janela
        j.getContentPane().add(msg);
        // criar uma caixa de texto e adicionar na janela
        JTextField nome = new JTextField("", 10);
        j.getContentPane().add(nome);
        // criar um botão e adicionar na janela
        JButton but = new JButton("OK");
        j.getContentPane().add(but);
        // criar outro rótulo e adicionar na janela
        JLabel msg2 = new JLabel("");
        j.getContentPane().add(msg2);
        // adicionar um tratador de evento ao botão
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // colocar no segundo rótulo o título da caixa de texto
                msg2.setText("Seu nome é: "+nome.getText());
            }
        });
        // operações finais sobre a janela
        j.setLocationRelativeTo(null); // centralizar
        j.pack(); // montar 
        j.setVisible(true); // tornar visível
    }
    public static void main(String[] args) {
        JanelaBasica.criar();
    }
}