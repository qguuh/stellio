package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);

		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Stellio");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(22, 27, 237, 23);
		getContentPane().add(lblNome);
		
		JLabel lblDescricao = new JLabel("Sistema para gestao de estoque e PVD");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(22, 61, 326, 14);
		getContentPane().add(lblDescricao);
		
		JLabel lblAuthor = new JLabel("Autor: Gustavo");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuthor.setBounds(20, 84, 159, 14);
		getContentPane().add(lblAuthor);
		
		JLabel lblVersao = new JLabel("Versão 1.0");
		lblVersao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVersao.setBounds(22, 106, 145, 14);
		getContentPane().add(lblVersao);
		
		JLabel lblMIT = new JLabel("");
		lblMIT.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit.png")));
		lblMIT.setBounds(360, 11, 64, 64);
		getContentPane().add(lblMIT);
		
		JLabel lblGithub = new JLabel("");
		lblGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
		lblGithub.setBounds(21, 220, 32, 32);
		getContentPane().add(lblGithub);
		
		JLabel lblGitLink = new JLabel("github.com/qguuh");
		lblGitLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://github.com/qguuh");
			}
		});
		lblGitLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitLink.setForeground(new Color(0, 51, 255));
		lblGitLink.setBounds(63, 226, 103, 23);
		getContentPane().add(lblGitLink);
		
		JButton lblVoltar = new JButton("Voltar");
		lblVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// fechar apenas o sobre
				dispose();
			}
		});
		lblVoltar.setBounds(335, 226, 89, 23);
		getContentPane().add(lblVoltar);
		
		setLocationRelativeTo(null);
	} // fim do construtor
	
	private void link(String url) {
		// a linha abaixo obtem o desktop do cliente
		Desktop desktop = Desktop.getDesktop();
		// uso do try catch (tratamento de exeções)
		try {
			// objeto URI para acessar os métodos necessários para estabelecer uma conexão com a url (link)
			URI uri = new URI(url);
			// abrir o link no navegador padrão do cliente
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
