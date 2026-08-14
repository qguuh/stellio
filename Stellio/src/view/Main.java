package view;

import java.awt.Color;
import java.awt.Cursor;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/dress  512px.png")));
		setTitle("Stellio");
		setBounds(100, 100, 845, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(210, 210, 210));
		panelInferior.setBounds(0, 454, 832, 107);
		contentPane.add(panelInferior);
		panelInferior.setLayout(null);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setBounds(153, 11, 64, 64);
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
		btnProdutos.setBounds(248, 11, 64, 64);
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
		btnPDV.setBounds(338, 11, 64, 64);
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
		btnVendas.setBounds(428, 11, 64, 64);
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
		btnSair.setBounds(613, 11, 64, 64);
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
		btnSobre.setBounds(518, 11, 64, 64);
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
		
		JLabel lblDatabase = new JLabel("");
		lblDatabase.setBounds(338, 81, 31, 26);
		panelInferior.add(lblDatabase);
		lblDatabase.setIcon(new ImageIcon(Main.class.getResource("/img/storage (1).png")));
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblMySQL = new JLabel("MySQL Desconectado");
		lblMySQL.setBounds(369, 81, 104, 26);
		panelInferior.add(lblMySQL);
		lblMySQL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblStatus = new JLabel("•");
		lblStatus.setBounds(475, 80, 25, 26);
		panelInferior.add(lblStatus);
		lblStatus.setForeground(new Color(204, 0, 0));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDashboard.setBounds(49, 11, 110, 49);
		contentPane.add(lblDashboard);
		
		JLabel lblDashboardLogo = new JLabel("");
		lblDashboardLogo.setIcon(new ImageIcon(Main.class.getResource("/img/speedometer (5).png")));
		lblDashboardLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDashboardLogo.setBounds(10, 11, 44, 49);
		contentPane.add(lblDashboardLogo);
		
		JLabel lbCalendário = new JLabel("");
		lbCalendário.setIcon(new ImageIcon(Main.class.getResource("/img/calendar (1).png")));
		lbCalendário.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCalendário.setBounds(678, 11, 32, 49);
		contentPane.add(lbCalendário);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(720, 21, 101, 31);
		contentPane.add(lblData);
		
		JPanel panelLateral1 = new JPanel();
		panelLateral1.setLayout(null);
		panelLateral1.setBackground(new Color(210, 210, 210));
		panelLateral1.setBounds(0, 268, 17, 176);
		contentPane.add(panelLateral1);
		
		JPanel panelLateral2 = new JPanel();
		panelLateral2.setLayout(null);
		panelLateral2.setBackground(new Color(210, 210, 210));
		panelLateral2.setBounds(0, 70, 17, 176);
		contentPane.add(panelLateral2);
		
		JPanel panelCard1 = new JPanel();
		panelCard1.setVisible(false);
		panelCard1.setBackground(new Color(210, 210, 210));
		panelCard1.setBounds(59, 70, 230, 176);
		contentPane.add(panelCard1);
		panelCard1.setLayout(null);
		
		JPanel panelCard2 = new JPanel();
		panelCard2.setBackground(new Color(210, 210, 210));
		panelCard2.setBounds(299, 70, 230, 176);
		contentPane.add(panelCard2);
		
		JPanel panelCard3 = new JPanel();
		panelCard3.setBackground(new Color(210, 210, 210));
		panelCard3.setBounds(539, 70, 230, 176);
		contentPane.add(panelCard3);
		panelCard3.setVisible(false);
		
		JPanel panelCard4 = new JPanel();
		panelCard4.setLayout(null);
		panelCard4.setBackground(new Color(210, 210, 210));
		panelCard4.setBounds(59, 268, 230, 176);
		contentPane.add(panelCard4);
		panelCard4.setVisible(false);
		panelCard4.setVisible(false);
		
		JPanel panelCard5 = new JPanel();
		panelCard5.setBackground(new Color(210, 210, 210));
		panelCard5.setBounds(299, 268, 230, 176);
		contentPane.add(panelCard5);
		panelCard5.setVisible(false);
		
		JPanel panelCard6 = new JPanel();
		panelCard6.setBackground(new Color(210, 210, 210));
		panelCard6.setBounds(539, 268, 230, 176);
		contentPane.add(panelCard6);
		panelCard2.setVisible(false);
		panelCard6.setVisible(false);
		
		JPanel panelLateralGrande = new JPanel();
		panelLateralGrande.setLayout(null);
		panelLateralGrande.setBackground(new Color(210, 210, 210));
		panelLateralGrande.setBounds(815, 70, 17, 374);
		contentPane.add(panelLateralGrande);
		
		JPanel panelMeioGrande = new JPanel();
		panelMeioGrande.setLayout(null);
		panelMeioGrande.setBackground(new Color(210, 210, 210));
		panelMeioGrande.setBounds(64, 70, 705, 374);
		contentPane.add(panelMeioGrande);
		panelMeioGrande.setVisible(false);
		
		
		
		
		
		// Criação dos botões funcionais 
		
		JButton btnMeioCard = new JButton("");
		btnMeioCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMeioCard.setIcon(new ImageIcon(Main.class.getResource("/img/right-arrow.png")));
		
		JButton btnLateralCard = new JButton("");
		btnLateralCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLateralCard.setIcon(new ImageIcon(Main.class.getResource("/img/left-arrow.png")));
		
		JButton btnMeioGrande = new JButton("");
		btnMeioGrande.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMeioGrande.setIcon(new ImageIcon(Main.class.getResource("/img/left-arrow.png")));
		
		JButton btnLateralGrande = new JButton("");
		btnLateralGrande.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLateralGrande.setIcon(new ImageIcon(Main.class.getResource("/img/right-arrow.png")));
		
		// Remove as bordas e deixar o fundo transparente
		btnMeioCard.setBorderPainted(false);
		btnMeioCard.setContentAreaFilled(false);
		
		btnLateralCard.setBorderPainted(false);
		btnLateralCard.setContentAreaFilled(false);
		
		btnMeioGrande.setBorderPainted(false);
		btnMeioGrande.setContentAreaFilled(false);
		
		btnLateralGrande.setBorderPainted(false);
		btnLateralGrande.setContentAreaFilled(false);
		
		
		// --------------------------------------------------------------------
		//                            LADO CARD
		// --------------------------------------------------------------------
		
		// Cards aparecendo no meio
		btnMeioCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// painel lateral
				
				panelLateral2.hide();
				panelLateral1.hide();
				
				// boão
				btnMeioCard.setVisible(false);
				btnLateralCard.setVisible(true);
				
				// tela meio
				panelCard1.show();
				panelCard2.show();
				panelCard3.show();
				panelCard4.show();
				panelCard5.show();
				panelCard6.show();
				
				// Fazer o Meio Grande voltar ao normal
				
				panelMeioGrande.hide();
				panelLateralGrande.show();
				
				// Botão lado Grande voltando ao normal
				
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);
			}
		});
		
		btnMeioCard.setBounds(23, 232, 32, 49);
		contentPane.add(btnMeioCard);

		
		// Cards sumindo do meio
		btnLateralCard.setVisible(false);
		
		
		// Fazer os icones aparecer na lateral
		btnLateralCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// botão
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);
				
				// tela lateral
				panelLateral2.show();
				panelLateral1.show();
				
				// Tela meio CARD
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				
			}
		});
		btnLateralCard.setBounds(23, 232, 32, 49);
		contentPane.add(btnLateralCard);
		
		// --------------------------------------------------------------------
		//                        LADO GRANDE
		// --------------------------------------------------------------------
		
				// Tela grande aparecendo no meio
				btnMeioGrande.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// botões do Grande
						btnMeioGrande.setVisible(false);
						btnLateralGrande.setVisible(true);
						
						// Tela meio Grande
						panelMeioGrande.show();
						panelLateralGrande.hide();
						
						// Tela meio e botão CARD (fazer todo o Card voltar ao normal)
						
						// Tela meio Card
						panelCard1.hide();
						panelCard2.hide();
						panelCard3.hide();
						panelCard4.hide();
						panelCard5.hide();
						panelCard6.hide();
						
						// Botão Card
						btnLateralCard.setVisible(false);
						btnMeioCard.setVisible(true);
						
						// tela lateral
						panelLateral2.show();
						panelLateral1.show();
						
					}
				});
				btnMeioGrande.setBounds(777, 232, 32, 49);
				contentPane.add(btnMeioGrande);
				
				
				
				//Tela grande sumindo do meio
				
				btnLateralGrande.setVisible(false);
				
				btnLateralGrande.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						btnMeioGrande.setVisible(true);
						btnLateralGrande.setVisible(false);
						
						panelMeioGrande.hide();
						panelLateralGrande.show();
						
						
					}
				});
				btnLateralGrande.setBounds(777, 232, 32, 49);
				contentPane.add(btnLateralGrande);
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/img/dress 128px.png")));
				lblNewLabel_2.setBounds(215, 204, 119, 143);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Stellio");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("Vladimir Script", Font.BOLD, 85));
				lblNewLabel_3.setBounds(326, 204, 249, 107);
				contentPane.add(lblNewLabel_3);
				
				JLabel lblNewLabel_5 = new JLabel("Vestidos de alta costura");
				lblNewLabel_5.setFont(new Font("NSimSun", Font.PLAIN, 20));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setBounds(306, 298, 300, 26);
				contentPane.add(lblNewLabel_5);
		
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
