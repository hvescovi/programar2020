package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class TelaIncluirPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	
	// lista de pessoas
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private JTable tblPessoas;
		
	public TelaIncluirPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// centralizar a janela
		this.setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(12, 48, 70, 15);
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 75, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 102, 70, 15);
		getContentPane().add(lblTelefone);
		
		txtNome = new JTextField();
		txtNome.setBounds(85, 46, 279, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(85, 73, 209, 19);
		getContentPane().add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(85, 100, 135, 19);
		getContentPane().add(txtTelefone);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cria uma pessoa com as informações da tela
				Pessoa nova = new Pessoa(txtNome.getText(), 
						txtEmail.getText(), txtTelefone.getText());
				// adicionar a pessoa
				pessoas.add(nova);

				// limpar os campos
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
				
				// adiciona a pessoa na tabela visual
				//tblPessoas.
			}
		});
		btnNewButton.setBounds(85, 129, 117, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblCadastroDeNova = new JLabel("Cadastro de Nova Pessoa");
		lblCadastroDeNova.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeNova.setBounds(0, 12, 378, 15);
		getContentPane().add(lblCadastroDeNova);

		
        String[][] dados = { 
            { "João da Silva", "josilva@gmail.com", "47 99211 2020" }, 
            { "Maria Oliveira", "maliver@gmail.com", "47 98841 2323" } 
        }; 
  
        String[] nomesColunas = { "Nome", "Email", "Telefone" }; 

		tblPessoas = new JTable(dados, nomesColunas);
		//tblPessoas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblPessoas.setBounds(27, 190, 428, 86);
		contentPane.add(tblPessoas);
		
		
		
		// incluir duas pessoas por padrão no cadastro
		
	}
}
