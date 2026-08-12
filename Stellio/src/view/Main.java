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
		
		JPanel paneLateral = new JPanel();
		paneLateral.setBackground(new Color(192, 192, 192));
		paneLateral.setBounds(0, 0, 228, 561);
		contentPane.add(paneLateral);
		paneLateral.setLayout(null);
		
		JButton btnProdutos = new JButton("Produtos");
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
		btnProdutos.setBounds(10, 184, 208, 48);
		paneLateral.add(btnProdutos);
		
		JButton btnPDV = new JButton("Vendas");
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
		btnPDV.setBounds(10, 243, 208, 48);
		paneLateral.add(btnPDV);
		
		JButton btnVendas = new JButton("Vendas");
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
		btnVendas.setBounds(10, 302, 208, 48);
		paneLateral.add(btnVendas);
		
		JButton btnSair = new JButton("Sair");
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
		btnSair.setBounds(10, 361, 208, 48);
		paneLateral.add(btnSair);
		
		JButton btnSobre = new JButton("Sobre");
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
		btnSobre.setBounds(10, 457, 208, 48);
		paneLateral.add(btnSobre);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/img/dress (3).png")));
		lblLogo.setBounds(10, 33, 64, 64);
		paneLateral.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("Stellio");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(84, 21, 134, 64);
		paneLateral.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de PDV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(94, 83, 124, 14);
		paneLateral.add(lblNewLabel_1);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setForeground(new Color(0, 0, 0));
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/team.png")));
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// Remove as bordas 
		btnFornecedores.setBorderPainted(false);
		
		// Deixa o fundo transparente
		//btnFornecedores.setContentAreaFilled(false);
		
		btnFornecedores.setIconTextGap(25);
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFornecedores.setBackground(new Color(192, 192, 192));
		btnFornecedores.setBounds(10, 125, 208, 48);
		paneLateral.add(btnFornecedores);
		
		JLabel lbnTracado = new JLabel("---------------------------");
		lbnTracado.setForeground(new Color(0, 0, 0));
		lbnTracado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbnTracado.setBounds(20, 420, 198, 26);
		paneLateral.add(lbnTracado);
		
		JLabel lblNewLabel_4 = new JLabel("MySQL Desconectado");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(61, 535, 104, 26);
		paneLateral.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Main.class.getResource("/img/storage (1).png")));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4_1.setBounds(20, 535, 31, 26);
		paneLateral.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("•");
		lblNewLabel_4_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_2.setBounds(167, 530, 25, 29);
		paneLateral.add(lblNewLabel_4_2);
		
		JPanel panelCard1 = new JPanel();
		panelCard1.setBackground(new Color(210, 210, 210));
		panelCard1.setBounds(238, 71, 185, 145);
		contentPane.add(panelCard1);
		panelCard1.setLayout(null);
		
		JLabel lblProduto = new JLabel("");
		lblProduto.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProduto.setIcon(new ImageIcon(Main.class.getResource("/img/box (1).png")));
		lblProduto.setBounds(10, 11, 32, 44);
		panelCard1.add(lblProduto);
		
		JPanel panelCard2 = new JPanel();
		panelCard2.setBackground(new Color(210, 210, 210));
		panelCard2.setBounds(434, 71, 185, 145);
		contentPane.add(panelCard2);
		panelCard2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/img/alert (1).png")));
		lblNewLabel_2.setBounds(10, 11, 32, 44);
		panelCard2.add(lblNewLabel_2);
		
		JPanel panelCard3 = new JPanel();
		panelCard3.setBackground(new Color(210, 210, 210));
		panelCard3.setBounds(631, 71, 185, 145);
		contentPane.add(panelCard3);
		panelCard3.setLayout(null);
		
		JPanel panelCard4 = new JPanel();
		panelCard4.setBackground(new Color(210, 210, 210));
		panelCard4.setBounds(238, 226, 185, 145);
		contentPane.add(panelCard4);
		panelCard4.setLayout(null);
		
		JPanel panelCard5 = new JPanel();
		panelCard5.setBackground(new Color(210, 210, 210));
		panelCard5.setBounds(434, 227, 185, 145);
		contentPane.add(panelCard5);
		panelCard5.setLayout(null);
		
		JPanel panelCard6 = new JPanel();
		panelCard6.setBackground(new Color(210, 210, 210));
		panelCard6.setBounds(631, 227, 185, 145);
		contentPane.add(panelCard6);
		panelCard6.setLayout(null);
		
		JPanel panelCard7 = new JPanel();
		panelCard7.setBackground(new Color(210, 210, 210));
		panelCard7.setBounds(238, 382, 578, 168);
		contentPane.add(panelCard7);
		panelCard7.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDashboard.setBounds(277, 11, 110, 49);
		contentPane.add(lblDashboard);
		
		JLabel lblDashboardLogo = new JLabel("");
		lblDashboardLogo.setIcon(new ImageIcon(Main.class.getResource("/img/speedometer (5).png")));
		lblDashboardLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDashboardLogo.setBounds(238, 11, 44, 49);
		contentPane.add(lblDashboardLogo);
		
		JLabel lbCalendário = new JLabel("");
		lbCalendário.setIcon(new ImageIcon(Main.class.getResource("/img/calendar (1).png")));
		lbCalendário.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCalendário.setBounds(673, 11, 32, 49);
		contentPane.add(lbCalendário);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(715, 21, 101, 31);
		contentPane.add(lblData);
		
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
