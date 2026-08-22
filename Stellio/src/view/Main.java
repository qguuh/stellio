package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

// importar o controller
import controller.FornecedorController;
// Importar Database
import database.Database;
import model.Fornecedor;
import utils.Validador;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

	// Criação de um objeto para ligar com a conexão
	Database db = new Database();
	private JLabel lblStatus;
	private JLabel lblMySQL;
	private JTextField txtEmail;
	private JTextField txtFone;
	private JTextField txtNome;
	private JTextField txtID;

	// instalar o fornecedorController
	private FornecedorController controller;
	private JTextField txtBuscarNome;
	private JTextField txtEditEmail;
	
	
	private String modo = ""; // "editar" ou "excluir"

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
		
		

		// criar o objeto controller
		controller = new FornecedorController();

		// Criar um objeto fornecedor
		Fornecedor fornecedor = new Fornecedor();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/dress  512px.png")));
		setTitle("Stellio");
		setBounds(100, 100, 845, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelAdicionar = new JPanel();
		panelAdicionar.setBackground(new Color(210, 210, 210));
		panelAdicionar.setBounds(64, 113, 705, 262);
		contentPane.add(panelAdicionar);
		panelAdicionar.setLayout(null);
		panelAdicionar.setVisible(false);

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblID.setBounds(319, 13, 87, 32);
		panelAdicionar.add(lblID);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(85, 90, 115, 32);
		panelAdicionar.add(lblNome);

		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setHorizontalAlignment(SwingConstants.CENTER);
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFone.setBounds(85, 132, 115, 32);
		panelAdicionar.add(lblFone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(85, 174, 115, 32);
		panelAdicionar.add(lblEmail);

		txtEmail = new JTextField();

		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(200, 174, 342, 32);
		panelAdicionar.add(txtEmail);
		// Validação de número máximo de caracteres
		txtEmail.setDocument(new Validador(50));

		txtFone = new JTextField();
		
		// Mudar o campo >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		txtFone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				txtEmail.requestFocus();
				}
			}
		});
		
		txtEditEmail = new JTextField();

		txtEditEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEditEmail.setColumns(10);
		txtEditEmail.setBounds(200, 174, 342, 32);
		panelAdicionar.add(txtEditEmail);
		
		
		txtFone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFone.setColumns(10);
		txtFone.setBounds(200, 132, 342, 32);
		panelAdicionar.add(txtFone);
		// Validação de número máximo de caracteres
		txtFone.setDocument(new Validador(20));

		txtNome = new JTextField();
		
		// Mudar o campo >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtFone.requestFocus();
				}
			}
		});

		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setColumns(10);
		txtNome.setBounds(200, 90, 342, 32);
		panelAdicionar.add(txtNome);
		// Validação de número máximo de caracteres
		txtNome.setDocument(new Validador(50));

		txtID = new JTextField();
		txtID.setBorder(null);
		txtID.setBackground(new Color(210, 210, 210));
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtID.setColumns(10);
		txtID.setBounds(319, 48, 87, 32);
		panelAdicionar.add(txtID);

		// ==================================================================================
		// CRUD Create - Cadastrar fornecedor >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// ==================================================================================
		JButton btnAdd = new JButton("");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Validação de campos obrigatórios
				if (txtNome.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor.");
					txtNome.requestFocus();
				} else if (txtFone.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor.");
					txtFone.requestFocus();
				} else {
					// Lógica principal se os campos obrigatórios estivarem preenchidos
					
					try {
						// Crud Create

						// transferir os dados da tela para o objeto
						fornecedor.setNome(txtNome.getText());
						fornecedor.setFone(txtFone.getText());
						fornecedor.setEmail(txtEmail.getText());

						txtNome.requestFocus();

						// Enviar o objeto para o controller
						controller.Adicionar(fornecedor);

						// mensagem de confirmação
						JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso.");

						// Limpar campos
						limparCampos();

					} catch (Exception e2) {
						System.out.println(e2);
						JOptionPane.showMessageDialog(null, "Erro ao salvar ");
					}
				}
			}
		});
		// ==================================================================================
		// FIM - CRUD Create >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// ==================================================================================
			
		// ==================================================================================
		// ENVIAR OS DADOS AO PRECIONAR ENTER (FORMA ALTERNATIVA)
		// ==================================================================================
		
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
				btnAdd.doClick();
				txtNome.requestFocus();
					}
				}
		});
		
		btnAdd.setBackground(new Color(210, 210, 210));
		btnAdd.setIcon(new ImageIcon(Main.class.getResource("/img/add-file.png")));
		btnAdd.setBounds(631, 188, 64, 64);
		panelAdicionar.add(btnAdd);

		btnAdd.setBorderPainted(false);
		
		
		
		
		
		// ==================================================================================
		// CRUD Update - Editar fornecedor >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// ==================================================================================
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Validação de campos obrigatórios
				if (txtNome.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor.");
					txtNome.requestFocus();
				} else if (txtFone.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor.");
					txtFone.requestFocus();
				} else {
					// Lógica principal se os campos obrigatórios estivarem preenchidos
					
					try {
						// Crud Update

						// transferir os dados da tela para o objeto
						fornecedor.setNome(txtNome.getText());
						fornecedor.setFone(txtFone.getText());
						fornecedor.setEmail(txtEditEmail.getText());
						fornecedor.setIdFornecedor(Integer.parseInt(txtID.getText()));

						txtNome.requestFocus();

						// Enviar o objeto para o controller
						controller.Editar(fornecedor);

						// mensagem de confirmação
						JOptionPane.showMessageDialog(null, "Fornecedor Editado com sucesso.");

						// Limpar campos
						limparCampos();

					} catch (Exception e2) {
						System.out.println(e2);
						JOptionPane.showMessageDialog(null, "Erro ao Editar.");
					}
				}				
			}
		});
		// FIM DO CRUD Update >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		// ==================================================================================
		// ENVIAR OS DADOS AO PRECIONAR ENTER (FORMA ALTERNATIVA)
		// ==================================================================================
		txtEditEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					btnEdit.doClick();
					txtNome.requestFocus();
						}
				
			}
		});
		
		btnEdit.setIcon(new ImageIcon(Main.class.getResource("/img/written-paper.png")));
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setBorderPainted(false);
		btnEdit.setBackground(new Color(210, 210, 210));
		btnEdit.setBounds(631, 188, 64, 64);
		panelAdicionar.add(btnEdit);
		
		
		// ==================================================================================
		// CRUD Delete - Excluir fornecedor >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// ==================================================================================

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						//Validação de campos obrigatórios
						if (txtID.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o ID do fornecedor.");
							txtNome.requestFocus();
						/*} else if (txtFone.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor.");
							txtFone.requestFocus();*/
						} else {
							// Lógica principal se os campos obrigatórios estivarem preenchidos
							
							
					        // Janela de confirmação
					        int resposta = JOptionPane.showConfirmDialog(
					                null,
					                "Tem certeza que deseja excluir o fornecedor \"" + txtNome.getText() + "\"?",
					                "Confirmar exclusão",
					                JOptionPane.YES_NO_OPTION,
					                JOptionPane.WARNING_MESSAGE
					        );
							
					        if (resposta == JOptionPane.YES_OPTION) {

					            try {
					                int idFornecedor = Integer.parseInt(txtID.getText());

					                boolean sucesso = controller.Excluir(idFornecedor);

					                if (sucesso) {
					                    JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso.");
					                    limparCampos();
					                } else {
					                    JOptionPane.showMessageDialog(null, "Não foi possível excluir. Fornecedor não encontrado.");
					                }

					            } catch (NumberFormatException ex) {
					                JOptionPane.showMessageDialog(null, "ID inválido.");
					            }
					        }
							
							
							
						}				
					}
				});
				// FIM DO CRUD Update >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		btnDelete.setIcon(new ImageIcon(Main.class.getResource("/img/delete.png")));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(210, 210, 210));
		btnDelete.setBounds(631, 188, 64, 64);
		panelAdicionar.add(btnDelete);
		
		txtBuscarNome = new JTextField();
		txtBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBuscarNome.setColumns(10);
		txtBuscarNome.setBounds(200, 90, 342, 32);
		panelAdicionar.add(txtBuscarNome);
		
				JButton btnSearch = new JButton("");
				
						
						
						// ==================================================================================
						// CRUD Read - Buscar fornecedor >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						// ==================================================================================
						btnSearch.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								// Validação
								if (txtBuscarNome.getText().isBlank()) {
									JOptionPane.showMessageDialog(null, "Informe o nome do Fornecedor.");
									txtBuscarNome.requestFocus();
								} else {
									// Lógica principal
									
									try {
										// Capturar o nome para busca
										
										String nome = txtBuscarNome.getText();
										
										// Instanciar (Criar) o fornecedor executando a busca através do controller
										Fornecedor fornecedor = controller.buscar(nome);
										
										// se existir um fornecedor cadastrado
										
										if (fornecedor != null) {
											// Setar os campos do formulário
											txtID.setText(String.valueOf(fornecedor.getIdFornecedor()));
											txtBuscarNome.setText(fornecedor.getNome());
											txtFone.setText(fornecedor.getFone());
											txtEmail.setText(fornecedor.getEmail());
											
								            if (modo.equals("editar")) {
								            	panelAdicionar.requestFocus();
								            	
								                txtID.setEditable(false);
								                txtBuscarNome.setEditable(true);
								                txtFone.setEditable(true);
								                txtEmail.setEditable(true);
								                
								                
								                btnEdit.setVisible(true);
								                btnDelete.setVisible(false);
								                
								              
								                
								            } else if (modo.equals("excluir")) {
								            	panelAdicionar.requestFocus();
								            	

								                txtID.setEditable(false);
								                txtBuscarNome.setEditable(true);
								                txtFone.setEditable(false);
								                txtEmail.setEditable(false);
								                
								                
								                btnDelete.setVisible(true);
								                btnEdit.setVisible(false);
								                
								            } else if (modo.equals("Buscar")) {
								            	panelAdicionar.requestFocus();

								            	
								                txtID.setEditable(false);
								                txtBuscarNome.setEditable(true);
								                txtFone.setEditable(false);
								                txtEmail.setEditable(false);
								                
								                
								                btnDelete.setVisible(false);
								                btnEdit.setVisible(false);
								            } else {
								            	System.out.println("Erro ao rodar 'modo.equals'");
								            }
											
											// Fazer aparecer os campos após buscar o nome
											lblID.show();
											lblFone.show();
											lblEmail.show();
											
											txtEditEmail.hide();
											txtID.show();
											txtBuscarNome.show();
											txtFone.show();
											txtEmail.show();
											
											

											
											// Fazer os campos ficar centralizado com os outros campos (Nome)
											txtBuscarNome.setBounds(200, 90, 342, 32);
											lblNome.setBounds(85, 90, 115, 32);
											//wait(100);
											btnSearch.setBounds(540, 90, 25, 32);
											
											// Fazer os campos ficar centralizado com os outros campos (ID)
											txtID.setBounds(319, 48, 87, 32);
											lblID.setBounds(319, 13, 87, 32);
											
										} else {
											
											// O comando abaixo resolve o bug de aparecer a tela de erro 2 vezes caso pressione [ENTER]
											panelAdicionar.requestFocus();
											
											JOptionPane.showInternalMessageDialog(null, "Fornecedor não cadastrado.");
											txtBuscarNome.requestFocus();
											limparCampos();
											
										}
										
									} catch (Exception e2) {
										System.out.println(e2);
									}
								}
								
								
							}
						});
						// FIM >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						
						btnSearch.setIcon(new ImageIcon(Main.class.getResource("/img/loupe.png")));
						btnSearch.setBorderPainted(false);
						btnSearch.setBackground(new Color(210, 210, 210));
						btnSearch.setBounds(542, 90, 25, 32);
						panelAdicionar.add(btnSearch);

		JPanel panelFornecedor = new JPanel();
		panelFornecedor.setBackground(new Color(210, 210, 210));
		panelFornecedor.setBounds(64, 70, 705, 375);
		contentPane.add(panelFornecedor);
		panelFornecedor.setLayout(null);

		JButton btnEditar = new JButton("");

		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setBackground(new Color(210, 210, 210));
		btnEditar.setIcon(new ImageIcon(Main.class.getResource("/img/draw.png")));
		btnEditar.setBounds(207, 311, 64, 64);
		panelFornecedor.add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBackground(new Color(210, 210, 210));

		btnExcluir.setIcon(new ImageIcon(Main.class.getResource("/img/trash.png")));
		btnExcluir.setBounds(312, 311, 64, 64);
		panelFornecedor.add(btnExcluir);

		JButton btnRelatorio = new JButton("");
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setBackground(new Color(210, 210, 210));
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRelatorio.setIcon(new ImageIcon(Main.class.getResource("/img/file.png")));
		btnRelatorio.setBounds(416, 311, 64, 64);
		panelFornecedor.add(btnRelatorio);

		// TELA NÃO APARECENDO QUANDO O PROGRAMA ABRE

		panelFornecedor.setVisible(false);

		// REMOÇÃO E BORDA DOS BOTÕES FORNECEDORES
		btnRelatorio.setBorderPainted(false);
		btnExcluir.setBorderPainted(false);
		btnEditar.setBorderPainted(false);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnAdicionar.setIcon(new ImageIcon(Main.class.getResource("/img/add.png")));
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBackground(new Color(210, 210, 210));
		btnAdicionar.setBounds(105, 311, 64, 64);
		panelFornecedor.add(btnAdicionar);

		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setIconTextGap(15);
		lblFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/team.png")));
		lblFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedores.setBounds(0, 0, 705, 46);
		panelFornecedor.add(lblFornecedores);
		
		JButton btnBuscar = new JButton("");

		btnBuscar.setIcon(new ImageIcon(Main.class.getResource("/img/search.png")));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(new Color(210, 210, 210));
		btnBuscar.setBounds(525, 311, 64, 64);
		panelFornecedor.add(btnBuscar);

		
		
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBackground(new Color(210, 210, 210));
		panelProdutos.setBounds(64, 70, 705, 375);
		contentPane.add(panelProdutos);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setIconTextGap(15);
		lblProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/box.png")));
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelProdutos.add(lblProdutos);
		panelProdutos.setVisible(false);

		JPanel panelSobre = new JPanel();
		panelSobre.setBackground(new Color(210, 210, 210));
		panelSobre.setBounds(64, 70, 705, 375);
		contentPane.add(panelSobre);
		panelSobre.setLayout(null);

		JLabel lblMIT = new JLabel("");
		lblMIT.setBounds(614, 30, 64, 64);
		lblMIT.setIcon(new ImageIcon(Main.class.getResource("/img/java.png")));
		panelSobre.add(lblMIT);

		JLabel lblGithub = new JLabel("");
		lblGithub.setIcon(new ImageIcon(Main.class.getResource("/img/github.png")));
		lblGithub.setBounds(20, 332, 32, 32);
		panelSobre.add(lblGithub);

		JLabel lblGitLink = new JLabel("github.com/qguuh");
		lblGitLink.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGitLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://github.com/qguuh");
			}
		});
		lblGitLink.setForeground(new Color(0, 51, 255));
		lblGitLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitLink.setBounds(60, 336, 126, 23);
		panelSobre.add(lblGitLink);

		JLabel lblNome_1 = new JLabel("Stellio");
		lblNome_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome_1.setFont(new Font("Vladimir Script", Font.BOLD, 72));
		lblNome_1.setBounds(149, 95, 409, 64);
		panelSobre.add(lblNome_1);

		JLabel lblDescricao = new JLabel("Sistema para gestão de estoque e PVD");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("NSimSun", Font.BOLD, 20));
		lblDescricao.setBounds(149, 169, 409, 33);
		panelSobre.add(lblDescricao);

		JLabel lblAuthor = new JLabel("Feito por: Gustavo");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("NSimSun", Font.BOLD, 20));
		lblAuthor.setBounds(149, 212, 409, 23);
		panelSobre.add(lblAuthor);

		JLabel lblVersao = new JLabel("Versão: 1.6");
		lblVersao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersao.setFont(new Font("NSimSun", Font.BOLD, 20));
		lblVersao.setBounds(149, 247, 409, 23);
		panelSobre.add(lblVersao);
		panelSobre.setVisible(false);

		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(210, 210, 210));
		panelInferior.setBounds(0, 454, 832, 107);
		contentPane.add(panelInferior);
		panelInferior.setLayout(null);

		// ============================================================================
		// BOTÕES INFERIORES FUNCIONAIS
		// ============================================================================

		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setBounds(170, 11, 64, 64);
		panelInferior.add(btnFornecedores);
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setForeground(new Color(0, 0, 0));
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/team.png")));

		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setBounds(270, 11, 64, 64);
		panelInferior.add(btnProdutos);
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setForeground(new Color(0, 0, 0));

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(375, 11, 64, 64);
		panelInferior.add(btnHome);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setForeground(new Color(0, 0, 0));

		JButton btnSobre = new JButton("Sobre");
		btnSobre.setBounds(480, 11, 64, 64);
		panelInferior.add(btnSobre);
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setForeground(new Color(0, 0, 0));

		// REMOÇÃO DE BORDA DOS BOTÕES
		btnFornecedores.setBorderPainted(false);
		btnProdutos.setBorderPainted(false);
		btnHome.setBorderPainted(false);
		btnSobre.setBorderPainted(false);

		btnFornecedores.setIconTextGap(25);
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFornecedores.setBackground(new Color(210, 210, 210));

		btnProdutos.setBackground(new Color(210, 210, 210));
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/box.png")));
		btnProdutos.setIconTextGap(25);

		btnHome.setBackground(new Color(210, 210, 210));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHome.setIcon(new ImageIcon(Main.class.getResource("/img/home.png")));
		btnHome.setIconTextGap(25);

		JButton btnSair = new JButton("");
		btnSair.setBounds(590, 11, 64, 64);
		panelInferior.add(btnSair);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.addActionListener(new ActionListener() {
			// Quando clicar no botão
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema",
						"Confirmar saída", JOptionPane.YES_NO_OPTION);
				// Apoio ao entendimento da lógica
				// System.out.println(resposta);
				if (resposta == 0) {
					System.exit(0); // encerra o sistema
				}
			}
		});

		// Remove as bordas
		btnSair.setBorderPainted(false);

		btnSair.setBackground(new Color(210, 210, 210));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair.setIcon(new ImageIcon(Main.class.getResource("/img/logout.png")));
		btnSair.setIconTextGap(25);

		btnSobre.setBackground(new Color(210, 210, 210));
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/info.png")));
		btnSobre.setHorizontalAlignment(SwingConstants.LEFT);
		btnSobre.setIconTextGap(25);

		// =========================================================================================================

		JLabel lblDatabase = new JLabel("");
		lblDatabase.setBounds(330, 81, 31, 26);
		panelInferior.add(lblDatabase);
		lblDatabase.setIcon(new ImageIcon(Main.class.getResource("/img/database.png")));
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 11));

		lblMySQL = new JLabel("");
		lblMySQL.setHorizontalAlignment(SwingConstants.CENTER);
		lblMySQL.setBounds(361, 81, 104, 26);
		panelInferior.add(lblMySQL);
		lblMySQL.setFont(new Font("Tahoma", Font.PLAIN, 11));

		lblStatus = new JLabel("•");
		lblStatus.setBounds(467, 80, 25, 26);
		panelInferior.add(lblStatus);
		lblStatus.setForeground(new Color(0, 174, 0));
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
		panelLateral1.setBounds(0, 268, 17, 177);
		contentPane.add(panelLateral1);

		JPanel panelLateral2 = new JPanel();
		panelLateral2.setLayout(null);
		panelLateral2.setBackground(new Color(210, 210, 210));
		panelLateral2.setBounds(0, 70, 17, 177);
		contentPane.add(panelLateral2);

		JPanel panelCard1 = new JPanel();
		panelCard1.setVisible(false);
		panelCard1.setBackground(new Color(210, 210, 210));
		panelCard1.setBounds(59, 70, 230, 177);
		contentPane.add(panelCard1);
		panelCard1.setLayout(null);

		JPanel panelCard2 = new JPanel();
		panelCard2.setBackground(new Color(210, 210, 210));
		panelCard2.setBounds(299, 70, 230, 177);
		contentPane.add(panelCard2);

		JPanel panelCard3 = new JPanel();
		panelCard3.setBackground(new Color(210, 210, 210));
		panelCard3.setBounds(539, 70, 230, 177);
		contentPane.add(panelCard3);
		panelCard3.setVisible(false);

		JPanel panelCard4 = new JPanel();
		panelCard4.setLayout(null);
		panelCard4.setBackground(new Color(210, 210, 210));
		panelCard4.setBounds(59, 268, 230, 177);
		contentPane.add(panelCard4);
		panelCard4.setVisible(false);
		panelCard4.setVisible(false);

		JPanel panelCard5 = new JPanel();
		panelCard5.setBackground(new Color(210, 210, 210));
		panelCard5.setBounds(299, 268, 230, 177);
		contentPane.add(panelCard5);
		panelCard5.setVisible(false);

		JPanel panelCard6 = new JPanel();
		panelCard6.setBackground(new Color(210, 210, 210));
		panelCard6.setBounds(539, 268, 230, 177);
		contentPane.add(panelCard6);
		panelCard2.setVisible(false);
		panelCard6.setVisible(false);

		JPanel panelLateralGrande = new JPanel();
		panelLateralGrande.setLayout(null);
		panelLateralGrande.setBackground(new Color(210, 210, 210));
		panelLateralGrande.setBounds(815, 70, 17, 375);
		contentPane.add(panelLateralGrande);

		JPanel panelMeioGrande = new JPanel();
		panelMeioGrande.setLayout(null);
		panelMeioGrande.setBackground(new Color(210, 210, 210));
		panelMeioGrande.setBounds(64, 71, 705, 375);
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
		// LADO CARD
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

				// Botões inferiores >>>>>>>>>>>>>>>>>>>>>>>>>
				panelFornecedor.hide();
				panelSobre.hide();
				panelAdicionar.hide();
				panelProdutos.hide();

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
		// LADO GRANDE
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

				// Tela meio Card e tela dos botões inferiores
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();

				// Botões inferiores >>>>>>>>>>>>>>>>>>>>>>>>>
				panelFornecedor.hide();
				panelSobre.hide();
				panelAdicionar.hide();
				panelProdutos.hide();

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

		// Tela grande sumindo do meio

		btnLateralGrande.setVisible(false);

		btnLateralGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				panelMeioGrande.hide();
				panelLateralGrande.show();

			}
		});

		// ============================================================================
		// BOTÕES INFERIORES CLICÁVEIS
		// BOTÕES FUNCIONAIS NA LINHA 333
		// ============================================================================

		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();
				panelLateral2.show();
				panelLateral1.show();

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelSobre.hide();
				panelAdicionar.hide();
				panelProdutos.hide();

				// Aparecer a tela fornecedor
				panelFornecedor.show();

				/*
				 * frmFornecedor fornecedor = new frmFornecedor(); fornecedor.setVisible(true);
				 */

			}
		});

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();

				// Sumir a opção de ID e o botão de buscar (não necessário para este botão)
				lblID.hide();
				txtID.hide();
				btnSearch.hide();
				txtBuscarNome.hide();

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelSobre.hide();
				panelProdutos.hide();

				// sumir os botões
				btnEdit.hide();
				btnDelete.hide();
				
				// Fazer aparecer os campos após buscar o nome
				lblFone.show();
				lblEmail.show();
				
				txtNome.show();
				txtFone.show();
				txtEmail.show();
				txtEditEmail.hide();
				
				// Fazer os campos ficar centralizado com os outros campos
				txtNome.setBounds(200, 90, 342, 32);
				lblNome.setBounds(85, 90, 115, 32);
				btnSearch.setBounds(540, 90, 25, 32);
				


				// aparecer o botão editar
				btnAdd.show();

				panelFornecedor.show();
				panelAdicionar.show();
				txtNome.requestFocus();
				limparCampos();

			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = "editar";
				
				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();
				

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelSobre.hide();
				panelProdutos.hide();

				// sumir os botões
				btnAdd.hide();
				btnDelete.hide();
				
				// Aparecer Somente o ID ao clicar
				lblID.hide();
				lblNome.hide();
				lblFone.hide();
				lblEmail.hide();
				
				txtID.hide();
				
				txtBuscarNome.hide();
				btnSearch.hide();
				txtNome.hide();
				txtFone.hide();
				txtEmail.hide();
				txtEditEmail.hide();
				
				
				lblNome.show();
				lblNome.setBounds(78, 135, 115, 32);
				txtBuscarNome.show();
				txtBuscarNome.setBounds(200, 135, 342, 32);
				
				btnSearch.show();
				btnSearch.setBounds(542, 135, 25, 32);
				

				// aparecer o botão editar (aparece somente após achar o ID cadastrado)
				btnEdit.hide();

				panelFornecedor.show();
				panelAdicionar.show();
				txtBuscarNome.requestFocus();
				limparCampos();

			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = "excluir";
				
				
				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();



				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelSobre.hide();
				panelProdutos.hide();

				// sumir os botões
				btnAdd.hide();
				btnEdit.hide();
				
				// Aparecer Somente o ID ao clicar
				lblID.hide();
				lblNome.hide();
				lblFone.hide();
				lblEmail.hide();
				
				txtID.hide();

				
				txtBuscarNome.hide();
				btnSearch.hide();
				txtNome.hide();
				txtFone.hide();
				txtEmail.hide();
				txtEditEmail.hide();

				
				lblNome.show();
				lblNome.setBounds(78, 135, 115, 32);
				txtBuscarNome.show();
				txtBuscarNome.setBounds(200, 135, 342, 32);
				
				btnSearch.show();
				btnSearch.setBounds(542, 135, 25, 32);
				
				
				
				// Fazer os campos ficar centralizado com os outros campos
				//txtBuscarNome.setBounds(200, 90, 342, 32);

				


				// aparecer o botão editar (Botão só aparece quando acha o ID do fornecedor)
				btnDelete.hide();

				panelFornecedor.show();
				panelAdicionar.show();
				txtBuscarNome.requestFocus();
				limparCampos();
				


			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = "Buscar";
				
				
				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();

				// Sumir a opção de ID e o botão de buscar (não necessário para este botão)
				lblID.hide();
				lblFone.hide();
				lblEmail.hide();
				
				
				txtID.hide();
				txtFone.hide();
				txtEmail.hide();
				txtEditEmail.hide();
				
				txtNome.hide();
				
				
				lblNome.show();
				lblNome.setBounds(78, 135, 115, 32);
				txtBuscarNome.show();
				txtBuscarNome.setBounds(200, 135, 342, 32);
				
				btnSearch.show();
				btnSearch.setBounds(542, 135, 25, 32);

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelSobre.hide();
				panelProdutos.hide();

				// sumir os botões
				btnAdd.hide();
				btnEdit.hide();

				// aparecer o botão editar
				btnDelete.hide();

				panelFornecedor.show();
				panelAdicionar.show();
				txtBuscarNome.requestFocus();
				limparCampos();
				
				
				
				
				

		
			}
		});

		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Fazer ele não aparecer ao abrir
				// panelProdutos.setVisible(false);

				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelFornecedor.hide();
				panelSobre.hide();
				panelAdicionar.hide();

				panelProdutos.show();

			}
		});

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelFornecedor.hide();
				panelSobre.hide();
				panelAdicionar.hide();
				panelProdutos.hide();

			}
		});

		btnSobre.addActionListener(new ActionListener() {
			// Ativar a tela sobre
			public void actionPerformed(ActionEvent e) {
				// Tela meio CARD e GRANDE (escondido) E Laterais aparecendo
				panelCard1.hide();
				panelCard2.hide();
				panelCard3.hide();
				panelCard4.hide();
				panelCard5.hide();
				panelCard6.hide();
				panelMeioGrande.hide();
				panelLateralGrande.show();

				// tela lateral CARD e GRANDE (aparecendo)
				panelLateral2.show();
				panelLateral1.show();
				panelLateral2.show();
				panelLateral1.show();

				// Aparecer os botões para puxar o CARD e Grande

				// botão CARD
				btnLateralCard.setVisible(false);
				btnMeioCard.setVisible(true);

				// botões do Grande
				btnMeioGrande.setVisible(true);
				btnLateralGrande.setVisible(false);

				// Sumir com todas as telas dos botões inferiores
				panelFornecedor.hide();
				panelAdicionar.hide();
				panelProdutos.hide();

				// Aparecer a tela sobre
				panelSobre.show();
			}
		});
		
		
		// =====================================================================================
		// FUNÇÃO PARA BUSCAR O NOME AO APERTAR O ENTER
		// =====================================================================================
		txtBuscarNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					// Fazer todo o comando do CRUD READ
					btnSearch.doClick();
					
					// Tirar o foco no bloco de texto
					txtBuscarNome.requestFocus();
				}
			}
		});

		btnLateralGrande.setBounds(777, 232, 32, 49);
		contentPane.add(btnLateralGrande);

		JLabel lblVestido = new JLabel("");
		lblVestido.setIcon(new ImageIcon(Main.class.getResource("/img/dress 128px.png")));
		lblVestido.setBounds(215, 204, 119, 143);
		contentPane.add(lblVestido);

		JLabel lblStellio = new JLabel("Stellio");
		lblStellio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStellio.setFont(new Font("Vladimir Script", Font.BOLD, 85));
		lblStellio.setBounds(326, 204, 249, 107);
		contentPane.add(lblStellio);

		JLabel lblRodape = new JLabel("Vestidos de alta costura");
		lblRodape.setFont(new Font("NSimSun", Font.PLAIN, 20));
		lblRodape.setHorizontalAlignment(SwingConstants.CENTER);
		lblRodape.setBounds(306, 298, 300, 26);
		contentPane.add(lblRodape);

		// Iniciar centralizado
		setLocationRelativeTo(null);

		// Iniciar com a tela cheia
		// setExtendedState(JFrame.MAXIMIZED_BOTH);

		// atualizar Data
		atualizarData();

		// status do banco (mudar texto e cor da bolinha)
		if (db.testarConexao() == true) {
			// System.out.println("Banco conectado");
			lblMySQL.setText("MySQL Conectado");
			lblStatus.setForeground(new Color(0, 174, 0));
			lblStatus.setBounds(459, 80, 25, 26);
			lblDatabase.setBounds(339, 81, 31, 26);
		} else {
			// System.out.println("Erro na conexão");
			lblMySQL.setText("MySQL Desconectado");
			lblStatus.setForeground(new Color(204, 0, 0));
		}

	} // fim do public main (constuctor)


	// ==================================================================================
	// Limpar Campos
	// ==================================================================================
	void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtBuscarNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtEditEmail.setText(null);

		txtNome.requestFocus(); // posicionar o cursor no nome

	} // fim do limpar campos

	// ==================================================================================
	// Link direcionado ao Github
	// ==================================================================================
	private void link(String url) {
		// a linha abaixo obtem o desktop do cliente
		Desktop desktop = Desktop.getDesktop();
		// uso do try catch (tratamento de exeções)
		try {
			// objeto URI para acessar os métodos necessários para estabelecer uma conexão
			// com a url (link)
			URI uri = new URI(url);
			// abrir o link no navegador padrão do cliente
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Fim do código ao github
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// ==================================================================================
	// função (método) para atualizar a data do sistema
	// ==================================================================================

	private void atualizarData() {
		// obter a data do sistema operacional
		LocalDate now = LocalDate.now();
		// formatar a data
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// alterar o texto de lblData
		lblData.setText(now.format(format));
	} // fim do atualizarData
} // fim da classe Main (principal)
