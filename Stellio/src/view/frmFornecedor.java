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
import javax.swing.ImageIcon;

public class frmFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtID;

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
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/logout.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(570, 384, 46, 46);
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
		
		txtNome = new JTextField();
		txtNome.setBounds(196, 160, 232, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(196, 191, 232, 20);
		getContentPane().add(txtFone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(196, 222, 232, 20);
		getContentPane().add(txtEmail);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/plus.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(346, 384, 46, 46);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/pencil.png")));
		btnEditar.setBounds(402, 384, 46, 46);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/trash-bin.png")));
		btnExcluir.setBounds(458, 384, 46, 46);
		getContentPane().add(btnExcluir);
		
		JButton btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/report.png")));
		btnRelatorio.setBounds(514, 384, 46, 46);
		getContentPane().add(btnRelatorio);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblID.setBounds(140, 130, 46, 14);
		getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(196, 129, 232, 20);
		getContentPane().add(txtID);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/search (1).png")));
		btnBuscar.setBounds(428, 160, 25, 20);
		getContentPane().add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(0, 0, 624, 108);
		getContentPane().add(panel);
		
		//Iniciar centralizado
		setLocationRelativeTo(null);

	} // fim do construtor
} // fim do ...
