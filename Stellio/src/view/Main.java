package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Cursor;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Uso da biblioteca flatlaf (Swing moderno)
		   FlatLightLaf.setup();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/dress (3).png")));
		setTitle("Stellio");
		setBounds(100, 100, 840, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(210, 210, 210));
		panelInferior.setBounds(0, 454, 824, 107);
		contentPane.add(panelInferior);
		panelInferior.setLayout(null);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setBounds(240, 11, 64, 64);
		panelInferior.add(btnFornecedores);
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setForeground(new Color(0, 0, 0));
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/team.png")));
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFornecedor fornecedor = new frmFornecedor();
				fornecedor.setVisible(true);			}
		});
		
		// Remove as bordas 
		btnFornecedores.setBorderPainted(false);
		
		// Deixa o fundo transparente
		//btnFornecedores.setContentAreaFilled(false);
		
		btnFornecedores.setIconTextGap(25);
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFornecedores.setBackground(new Color(192, 192, 192));
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setBounds(314, 11, 64, 64);
		panelInferior.add(btnProdutos);
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setForeground(new Color(0, 0, 0));
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// Remove as bordas 
		btnProdutos.setBorderPainted(false);
		
		btnProdutos.setBackground(new Color(192, 192, 192));
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/box.png")));
		btnProdutos.setIconTextGap(25);
		
		JButton btnPDV = new JButton("Vendas");
		btnPDV.setBounds(388, 11, 64, 64);
		panelInferior.add(btnPDV);
		btnPDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPDV.setForeground(new Color(0, 0, 0));
		btnPDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// Remove as bordas 
		btnPDV.setBorderPainted(false);
		
		btnPDV.setBackground(new Color(192, 192, 192));
		btnPDV.setHorizontalAlignment(SwingConstants.LEFT);
		btnPDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPDV.setIcon(new ImageIcon(Main.class.getResource("/img/cashier.png")));
		btnPDV.setIconTextGap(25);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.setBounds(462, 11, 64, 64);
		panelInferior.add(btnVendas);
		btnVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendas.setForeground(new Color(0, 0, 0));
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// Remove as bordas 
		btnVendas.setBorderPainted(false);
		
		btnVendas.setBackground(new Color(192, 192, 192));
		btnVendas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVendas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVendas.setIcon(new ImageIcon(Main.class.getResource("/img/grocery-store.png")));
		btnVendas.setIconTextGap(25);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(610, 11, 69, 64);
		panelInferior.add(btnSair);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.addActionListener(new ActionListener() {
			// Quando clicar no botão 
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema", "Confirmar saída", JOptionPane.YES_NO_OPTION);
				// Apoio ao entendimento da lógica
				System.out.println(resposta);
				if (resposta == 0) {
					System.exit(0); // encerra o sistema
				} 
			}
		});
		
		// Remove as bordas 
		btnSair.setBorderPainted(false);
		
		btnSair.setBackground(new Color(192, 192, 192));
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair.setIcon(new ImageIcon(Main.class.getResource("/img/logout.png")));
		btnSair.setIconTextGap(25);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setBounds(536, 11, 64, 64);
		panelInferior.add(btnSobre);
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setForeground(new Color(0, 0, 0));
		btnSobre.addActionListener(new ActionListener() {
			// Ativar a tela sobre
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		
		// Remove as bordas 
		btnSobre.setBorderPainted(false);
		
		btnSobre.setBackground(new Color(192, 192, 192));
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/info.png")));
		btnSobre.setHorizontalAlignment(SwingConstants.LEFT);
		btnSobre.setIconTextGap(25);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(370, 81, 31, 26);
		panelInferior.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setIcon(new ImageIcon(Main.class.getResource("/img/storage (1).png")));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_4 = new JLabel("MySQL Desconectado");
		lblNewLabel_4.setBounds(401, 81, 104, 26);
		panelInferior.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_4_2 = new JLabel("•");
		lblNewLabel_4_2.setBounds(507, 80, 25, 26);
		panelInferior.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Stellio");
		lblNewLabel.setBounds(96, 11, 134, 64);
		panelInferior.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de PDV");
		lblNewLabel_1.setBounds(96, 81, 124, 14);
		panelInferior.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(22, 28, 64, 64);
		panelInferior.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/img/dress (3).png")));
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDashboard.setBounds(69, 11, 110, 49);
		contentPane.add(lblDashboard);
		
		JLabel lblDashboardLogo = new JLabel("");
		lblDashboardLogo.setIcon(new ImageIcon(Main.class.getResource("/img/speedometer (5).png")));
		lblDashboardLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDashboardLogo.setBounds(30, 11, 44, 49);
		contentPane.add(lblDashboardLogo);
		
		JLabel lbCalendário = new JLabel("");
		lbCalendário.setIcon(new ImageIcon(Main.class.getResource("/img/calendar (1).png")));
		lbCalendário.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCalendário.setBounds(651, 11, 32, 49);
		contentPane.add(lbCalendário);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(693, 21, 101, 31);
		contentPane.add(lblData);
		
		JPanel panelCard4 = new JPanel();
		panelCard4.setLayout(null);
		panelCard4.setBackground(new Color(210, 210, 210));
		panelCard4.setBounds(10, 267, 175, 176);
		contentPane.add(panelCard4);
		
		JPanel panelCard1 = new JPanel();
		panelCard1.setLayout(null);
		panelCard1.setBackground(new Color(210, 210, 210));
		panelCard1.setBounds(10, 71, 175, 176);
		contentPane.add(panelCard1);
		
		JPanel panelCard7 = new JPanel();
		panelCard7.setLayout(null);
		panelCard7.setBackground(new Color(210, 210, 210));
		panelCard7.setBounds(567, 71, 247, 372);
		contentPane.add(panelCard7);
		
		JPanel panelCard5 = new JPanel();
		panelCard5.setLayout(null);
		panelCard5.setBackground(new Color(210, 210, 210));
		panelCard5.setBounds(195, 267, 175, 176);
		contentPane.add(panelCard5);
		
		JPanel panelCard2 = new JPanel();
		panelCard2.setLayout(null);
		panelCard2.setBackground(new Color(210, 210, 210));
		panelCard2.setBounds(195, 71, 175, 176);
		contentPane.add(panelCard2);
		
		JPanel panelCard3 = new JPanel();
		panelCard3.setLayout(null);
		panelCard3.setBackground(new Color(210, 210, 210));
		panelCard3.setBounds(380, 71, 175, 176);
		contentPane.add(panelCard3);
		
		JPanel panelCard6 = new JPanel();
		panelCard6.setLayout(null);
		panelCard6.setBackground(new Color(210, 210, 210));
		panelCard6.setBounds(380, 267, 175, 176);
		contentPane.add(panelCard6);
		
		//Iniciar centralizado
		setLocationRelativeTo(null);
		
		// Iniciar com a tela cheia
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// atualizar Data
		atualizarData();

	} // fim do public main (constuctor)
	
	// função (método) para atualizar a data do sistema
	private void atualizarData() {
		// obter a data do sistema operacional
		LocalDate now = LocalDate.now();
		// formatar a data
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// alterar o texto de lblData
		lblData.setText(now.format(format));
	} // fim do atualizarData
} // fim da classe Main (principal)
