package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import modelo.Pessoa;
import javax.swing.JList;

public class TelaDePessoas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	
	// lista de pessoas
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	DefaultTableModel dadosTabela;
	DefaultListModel dadosLista;
	private JTable tblPessoas;
	private JList mensagens;
		
	Timer timer; 
	
	public TelaDePessoas() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		// lista de exibição de mensagens
		dadosLista = new DefaultListModel();
		mensagens = new JList(dadosLista);
		mensagens.setBounds(24, 280, 503, 86);
		contentPane.add(mensagens);
		
		int delay = 5000; //milliseconds
		ActionListener limpadorDeMensagens = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  if (dadosLista.getSize() > 0) {
		        	  dadosLista.remove(0);
		          }
		      }
		};
		timer = new Timer(delay, limpadorDeMensagens);
		timer.start();
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
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
				
				// obter acesso ao modelo da tabela
				DefaultTableModel tm = (DefaultTableModel) tblPessoas.getModel();
				// adicionar a linha na tabela visual
				tm.addRow(new Object[] {nova.getNome(), nova.getEmail(), nova.getTelefone()});
			}
		});
		btnAdicionar.setBounds(317, 233, 100, 25);
		getContentPane().add(btnAdicionar);
		
		dadosTabela = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Email", "Telefone"
				}
		);
		
		// não usar construtor com parâmetros senão não consegue alterar defaultTableModel
		tblPessoas = new JTable();
		tblPessoas.setModel(dadosTabela);
		// definir visualmente o número de colunas
		tblPessoas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblPessoas.setBounds(30, 38, 387, 116);
		contentPane.add(tblPessoas);
		
		// adicionar algumas pessoas exemplo
		
		// adicionar na lista interna
		pessoas.add(new Pessoa("Tiago Tomé", "tito@gmail.com", "47 9 9231 1234"));
		pessoas.add(new Pessoa("Suzana Vieira", "suvi@gmail.com", "47 9 9312 5324"));
		pessoas.add(new Pessoa("Paulo Horn", "pahorn@gmail.com", "47 9 8853 5342"));
		
		// adicionar na tabela visual
		for (Pessoa p : pessoas) {
			dadosTabela.addRow(new Object[] {p.getNome(), p.getEmail(), p.getTelefone()});
		}
		
		/*
		tblPessoas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Email", "Telefone"
				}
			               )
		);
		*/
		
		dadosTabela.addTableModelListener(
				new TableModelListener() 
				{
				    public void tableChanged(TableModelEvent evt) 
				    {
				    	 switch (evt.getType()) {
				    	    case TableModelEvent.UPDATE:
				    	    				    	    
						    	// existe alguma linha selecionada?
								if (tblPessoas.getSelectedRow() >= 0) {
									// obter acesso ao modelo da tabela
									//DefaultTableModel tm = (DefaultTableModel) tblPessoas.getModel();
									// obter a linha selecionada
									int i = tblPessoas.getSelectedRow();
									// criar pessoa com dados da linha atualizada
									String nome = (String) dadosTabela.getValueAt(i,  0);
									String email = (String) dadosTabela.getValueAt(i,  1);
									String telefone = (String) dadosTabela.getValueAt(i,  2);
									Pessoa alterada = new Pessoa(nome, email, telefone);
									// trocar a pessoa velha pela nova
									pessoas.set(i, alterada);
									
									dadosLista.addElement("Pessoa "+nome+" alterada");
									//mensagens.setModel(atual);
								}
								
							break;
							
				    	    case TableModelEvent.INSERT:
				    	    	dadosLista.addElement("Pessoa inserida");
				    	    	break;
				    	 }
				    	 
				    }
				});
		
		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Pessoas");
		lblCadastroDePessoas.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCadastroDePessoas.setBounds(119, 12, 239, 15);
		contentPane.add(lblCadastroDePessoas);
		
		JButton btnExclui = new JButton("Excluir");
		btnExclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// existe alguma linha selecionada?
				if (tblPessoas.getSelectedRow() >= 0) {
					// obter a linha selecionada
					int i = tblPessoas.getSelectedRow();
					
					try {
					// remover a linha
					dadosTabela.removeRow(i);
					} catch (Exception ex) {
						tblPessoas.repaint();
					}
				}
			}
		});
		btnExclui.setBounds(427, 35, 100, 25);
		contentPane.add(btnExclui);	
	}
}