package visao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import modelo.Pessoa;

public class Painel extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;

	// lista de pessoas
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	/**
	 * Create the panel.
	 */
	public Painel() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(12, 48, 70, 15);
		add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 75, 70, 15);
		add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 102, 70, 15);
		add(lblTelefone);
		
		txtNome = new JTextField();
		txtNome.setBounds(85, 46, 279, 19);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(85, 73, 209, 19);
		add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(85, 100, 135, 19);
		add(txtTelefone);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cria uma pessoa com as informações da tela
				Pessoa nova = new Pessoa(txtNome.getText(), 
						txtEmail.getText(), txtTelefone.getText());
				// adicionar a pessoa
				pessoas.add(nova);
				
				// exibir mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Pessoa cadastradao com sucesso");
				
				// limpar os campos
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
				
				
			}
		});
		btnNewButton.setBounds(141, 147, 117, 25);
		add(btnNewButton);
		
		JLabel lblCadastroDeNova = new JLabel("Cadastro de Nova Pessoa");
		lblCadastroDeNova.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeNova.setBounds(0, 12, 378, 15);
		add(lblCadastroDeNova);

	}
}
