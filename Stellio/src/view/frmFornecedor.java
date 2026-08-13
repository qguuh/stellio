package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class frmFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFornecedor dialog = new frmFornecedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public frmFornecedor() {
		setResizable(false);
		setTitle("Fornecedores");
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar ao Menu");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(499, 407, 115, 23);
		getContentPane().add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(140, 161, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFone.setBounds(140, 192, 46, 14);
		getContentPane().add(lblFone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(140, 223, 46, 14);
		getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(196, 160, 232, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 191, 232, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 222, 232, 20);
		getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(105, 407, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(202, 407, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(301, 407, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton lbl = new JButton("Relatório");
		lbl.setBounds(400, 407, 89, 23);
		getContentPane().add(lbl);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblID.setBounds(140, 130, 46, 14);
		getContentPane().add(lblID);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(196, 129, 232, 20);
		getContentPane().add(textField_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(434, 159, 89, 23);
		getContentPane().add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(0, 0, 624, 105);
		getContentPane().add(panel);
		
		//Iniciar centralizado
		setLocationRelativeTo(null);

	} // fim do construtor
} // fim do ...
