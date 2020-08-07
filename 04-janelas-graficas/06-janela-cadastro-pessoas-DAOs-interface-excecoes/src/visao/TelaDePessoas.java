package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//import dao.memoria.PessoaDAO;
import dao.json.PessoaDAO;
import modelo.Pessoa;

public class TelaDePessoas extends JFrame {

	private JTable tblPessoas;
	private JButton btnExcluir;
	DefaultTableModel dadosTabela; // acesso aos dados da tabela
	PessoaDAO pdao = new PessoaDAO(); // acesso à camada de dados
		
	public TelaDePessoas() {
		// configurações gerais da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 307);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // layout absoluto
		// centralizar a janela
		this.setLocationRelativeTo(null);
		
		// título da janela
		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Pessoas");
		lblCadastroDePessoas.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCadastroDePessoas.setBounds(119, 12, 239, 15);
		contentPane.add(lblCadastroDePessoas);
				
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
		JTextField txtNome = new JTextField();
		txtNome.setText("João da Silva");
		txtNome.setBounds(99, 182, 279, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setText("josilva@gmail.com");
		txtEmail.setColumns(10);
		txtEmail.setBounds(99, 209, 209, 19);
		getContentPane().add(txtEmail);
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setText("47 99212 1010");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(99, 236, 135, 19);
		getContentPane().add(txtTelefone);
		
		//botão adicionar
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(389, 206, 100, 25);
		// definir ação do botão adicionar
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// obter informações da tela
				String nome = txtNome.getText();
				String email =txtEmail.getText();
				String tel = txtTelefone.getText();
				// criar a nova pessoa
				Pessoa nova = new Pessoa(nome, email, tel);
				try {
				// adicionar na camada de dados
				pdao.incluirPessoa(nova);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null,  "Erro: "+ ex.getMessage());
				}
				// adicionar na tela
				dadosTabela.addRow(new String[] {nova.getNome(),
						nova.getTelefone(), nova.getEmail()});
				// limpar os campos
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
			}
		});
		getContentPane().add(btnAdicionar);
		
		// configurações da tabela/grid
		dadosTabela = new DefaultTableModel(
			new String[][] { }, // dados iniciais
			new String[] { "Nome", "Email", "Telefone" } // cabeçalho
		);		
		// usar construtor sem parâmetros, senão não consegue alterar defaultTableModel
		tblPessoas = new JTable(dadosTabela);
		// permitir a seleção de apenas uma linha
		tblPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// associar modelo definido acima (definição das colunas)
		tblPessoas.setModel(dadosTabela);
		// aprimoramento visual da borda
		tblPessoas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		// tamanho da grid
		tblPessoas.setBounds(30, 38, 387, 116);
		// inserir jscrollpane para exibir cabeçalho da tabela
		JScrollPane scrollPane = new JScrollPane(tblPessoas);
		scrollPane.setLocation(28, 39);
		scrollPane.setSize(390,125);
		contentPane.add(scrollPane);
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
		
		// botão de exclusão
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
					String nomeParaExcluir = (String) dadosTabela.getValueAt(i,  0);
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
	}
}