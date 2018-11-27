package Login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.Main_tela;
import PR_Metodos_Usuario.MetodosUsuarioController;
import Paineis.NavBar;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login_tela {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;
	int x, y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_tela window = new Login_tela();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 560);
		frame.getContentPane().setBackground(new Color(26,26,26));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel TLogin = new JPanel();
		frame.getContentPane().add(TLogin, "body");
		TLogin.setLayout(null);
		
		NavBar nav = new NavBar();
		//nav.setSize(845, 39);
		nav.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		nav.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int xx = arg0.getXOnScreen();
				int yy = arg0.getYOnScreen();
				frame.setLocation(xx - x, yy - y);
			}
		});
		TLogin.add(nav);
		
		
		//Botao Cadastrar
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setIcon(new ImageIcon(TLogin.getClass().getResource("/Libraries/img/btnCadastrar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setIcon(new ImageIcon(TLogin.getClass().getResource("/Libraries/img/btnCadastrar1.png")));
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TLogin.getClass().getResource("/Libraries/img/btnCadastrar1.png")));
		btnCadastrar.setBackground(SystemColor.window);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setBorder(null);
		btnCadastrar.setBounds(230, 400, 177, 41);
		TLogin.add(btnCadastrar);
		
		JButton btnAcessar = new JButton("");
		btnAcessar.setIcon(new ImageIcon(TLogin.getClass().getResource("/Libraries/img/btnAcessar1.png")));
		btnAcessar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAcessar.setIcon(new ImageIcon(TLogin.getClass().getResource("/Libraries/img/btnAcessar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAcessar.setIcon(new ImageIcon(TLogin.getClass().getResource("/Libraries/img/btnAcessar1.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					MetodosUsuarioController usuarioController = new MetodosUsuarioController();
					btnAcessar.setVisible(false);
					btnCadastrar.setVisible(false);
					if(txtEmail.getText().isEmpty() || txtSenha.getText().isEmpty()) 
					{
						JOptionPane.showMessageDialog(null, "Todos os Campos Precisam está preenchidos");
						btnAcessar.setVisible(true);
						btnCadastrar.setVisible(true);
					}else 
					{
						if(usuarioController.LogarUsuario(txtEmail.getText(), txtSenha.getText())) 
						{
							Main_tela mt = new Main_tela();
							mt.frame.setVisible(true);
							frame.dispose();
							
						}
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					if(JOptionPane.OK_OPTION == 0) {
						txtSenha.setText("");
						btnAcessar.setVisible(true);
						btnCadastrar.setVisible(true);
					}
				}
			}
		});
		
		btnAcessar.setBorderPainted(false);
		btnAcessar.setForeground(new Color(240, 248, 255));
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAcessar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAcessar.setBorder(null);
		btnAcessar.setBackground(SystemColor.inactiveCaptionBorder);
		btnAcessar.setBounds(420, 400, 177, 41);
		TLogin.add(btnAcessar);
		//Componentes de Texto
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEmail.setBorder(null);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBackground(new Color(28, 28, 28));
		txtEmail.setBounds(233, 286, 361, 32);
		TLogin.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setColumns(10);
		txtSenha.setBorder(null);
		txtSenha.setBackground(new Color(28, 28, 28));
		txtSenha.setBounds(233, 347, 361, 32);
		TLogin.add(txtSenha);
		
		
		JLabel Wallpaper = new JLabel("");
		Wallpaper.setIcon(new ImageIcon(Login_tela.class.getResource("/Libraries/img/login.png")));
		Wallpaper.setBounds(0, 0, 834, 560);
		TLogin.add(Wallpaper);

	}
}
