package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;

public class JanelaPessoas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPessoas frame = new JanelaPessoas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaPessoas() {
		// definições gerais da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// grid
		table = new JTable();
		table.setBounds(12, 79, 429, 196);
		contentPane.add(table);
		
		// título
		JLabel lblNewLabel = new JLabel("Cadastro de Pessoas");
		lblNewLabel.setBounds(173, 26, 132, 16);
		contentPane.add(lblNewLabel);
		
		// definindo a estrutura da tabela (colunas)
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Nome");
		model.addColumn("Email");
		model.addColumn("Telefone");
		
		// adicionando dados
		model.addRow(new String[]{"João", "josilva@gmail.com", "32223-1232"});
		model.addRow(new String[]{"Maria", "maoliveira@gmail.com", "99232-1415"});
	}
}