package visao;

import modelo.Pessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.memoria.PessoaDAO;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class TelaDePessoas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	
	// DAO Pessoas
	PessoaDAO pdao = new PessoaDAO();
	
	DefaultTableModel dadosTabela;
	private JTable tblPessoas;
	JButton btnExcluir;
	
	public TelaDePessoas() {
		// configurações gerais da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // layout absoluto
		
		// centralizar a janela
		this.setLocationRelativeTo(null);
		
		// rótulos
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(26, 184, 70, 15);
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(26, 211, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(26, 238, 70, 15);
		getContentPane().add(lblTelefone);
		
		// caixas de texto
		txtNome = new JTextField();
		txtNome.setText("João da Silva");
		txtNome.setBounds(99, 182, 279, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("josilva@gmail.com");
		txtEmail.setColumns(10);
		txtEmail.setBounds(99, 209, 209, 19);
		getContentPane().add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("47 99212 1010");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(99, 236, 135, 19);
		getContentPane().add(txtTelefone);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(389, 206, 100, 25);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// obter informações da tela
				String nome = txtNome.getText();
				String email =txtEmail.getText();
				String tel = txtTelefone.getText();
				
				// adicionar na tela
				incluirPessoaNaGrid(nome, email, tel);
				
				// adicionar na camada de dados
				pdao.incluirPessoa(new Pessoa(nome, email, tel));
				
				// limpar os campos
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
			}
		});
		getContentPane().add(btnAdicionar);
		
		// configurações da tabela/grid
		dadosTabela = new DefaultTableModel(
			new Object[][] { },
			new String[] { "Nome", "Email", "Telefone" }
		);
		
		// usar construtor sem parâmetros, senão não consegue alterar defaultTableModel
		tblPessoas = new JTable();
		// permitir a seleção de apenas uma linha
		tblPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// associar modelo definido acima (definição das colunas)
		tblPessoas.setModel(dadosTabela);
		// aprimoramento visual da borda
		tblPessoas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		// tamanho da grid
		tblPessoas.setBounds(30, 38, 387, 116);
		contentPane.add(tblPessoas);
		
		// carregar os dados na grid
		for (Pessoa p : pdao.retornarPessoas()) {
			dadosTabela.addRow(new String[] {p.getNome(), p.getEmail(), p.getTelefone()});
		}				
		
		// evento que altera estado do botão excluir
		tblPessoas.getSelectionModel().addListSelectionListener(
			 new ListSelectionListener(){
				 public void valueChanged(ListSelectionEvent event) {
					 Boolean alguemSelecionado = tblPessoas.getSelectedRow() != -1;
					 btnExcluir.setEnabled(alguemSelecionado); 
				 }
	         }
		);		
		
		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Pessoas");
		lblCadastroDePessoas.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCadastroDePessoas.setBounds(119, 12, 239, 15);
		contentPane.add(lblCadastroDePessoas);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(427, 35, 100, 25);
		
		// outra forma de codificar o botão: criar o evento separado		
		ActionListener aclExcluir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// obter a linha selecionada
				int i = tblPessoas.getSelectedRow();
				// existe alguma linha selecionada?
				if (i != -1) {
					// obter nome a ser excluído
					String nomeParaExcluir = (String) dadosTabela.getValueAt(i,  2);
					// remover a linha da grid
					dadosTabela.removeRow(i);
					// remover a pessoa da fonte de dados
					pdao.removerPessoa(nomeParaExcluir);
				}
			}
		};
		// associar o evento ao botão
		btnExcluir.addActionListener(aclExcluir);
			
		// adicionar o botão ao painel
		contentPane.add(btnExcluir);	
		
		// popular o cadastro
		Pessoa p1 = new Pessoa("Tiago Tomé", "tito@gmail.com", "47 9 9231 1234");
		Pessoa p2 = new Pessoa("Suzana Vieira", "suvi@gmail.com", "47 9 9312 5324");
		Pessoa p3 = new Pessoa("Paulo Horn", "pahorn@gmail.com", "47 9 8853 5342");
		pdao.incluirPessoa(p1);
		pdao.incluirPessoa(p2);
		pdao.incluirPessoa(p3);
		incluirPessoaNaGrid(p1.getNome(), p1.getEmail(), p1.getTelefone());
		incluirPessoaNaGrid(p2.getNome(), p2.getEmail(), p2.getTelefone());
		incluirPessoaNaGrid(p3.getNome(), p3.getEmail(), p3.getTelefone());
	}
	
	// método auxiliar
	public void incluirPessoaNaGrid(String nome, String telefone, String email) {
		// obter acesso ao modelo da tabela
		DefaultTableModel tm = (DefaultTableModel) tblPessoas.getModel();
		// adicionar a linha na tabela visual
		tm.addRow(new String[] {nome, telefone, email});				
	}
}