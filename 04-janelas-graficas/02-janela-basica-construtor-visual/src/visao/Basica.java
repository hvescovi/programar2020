package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Basica extends JFrame {

	public Basica() {
		// configurações básicas da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // não é preciso "this."
		setBounds(0, 0, 225, 140); // tamanho da janela
		setLocationRelativeTo(null); // centralizar a janela
		setTitle("Básica Java WM"); 
						
		JPanel painel = new JPanel(); // painel de componentes
		painel.setLayout(null); // layout absoluto
		setContentPane(painel); // adicionar painel à janela
		
		//rótulos
		JLabel lblMensagem = new JLabel("");
		// coordenadas e dimensões do componente: x, y, largura, altura 
		lblMensagem.setBounds(29, 60, 180, 15); 
		painel.add(lblMensagem);
		
		JLabel lblTitulo = new JLabel("Digite o seu nome:");
		lblTitulo.setBounds(33, 12, 133, 15);
		painel.add(lblTitulo);
		
		// caixa de entrada
		JTextField txtNome = new JTextField();
		txtNome.setBounds(29, 35, 114, 19);
		painel.add(txtNome);
				
		// botão
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(153, 31, 53, 26);
		// ação do botão
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensagem.setText("O seu nome é: "+txtNome.getText());
			}
		});		
		painel.add(btnOk);		
	}
}