package LoginCadastro;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.Main_tela;
import PR_Metodos_Usuario.CadastrarUsuario;
import PR_Metodos_Usuario.MetodosUsuarioController;
import Paineis.NavBar;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class LoginCadastro_tela {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;
	int x, y;
	private JTextField CadtxtUsuario;
	private JTextField CadtxtEmail;
	private JPasswordField CadtxtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCadastro_tela window = new LoginCadastro_tela();
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
	public LoginCadastro_tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 560);
		frame.getContentPane().setBackground(new Color(26,26,26));
		frame.getContentPane().setLayout(null);
		
		JPanel panels = new JPanel();
		panels.setBounds(0, 0, 834, 560);
		frame.getContentPane().add(panels);
		panels.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		login.setBounds(0,0,834,560);
		panels.add(login, "login");
		
		//Botao Cadastrar
				btnCadastrar = new JButton("");
				btnCadastrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCadastrar.setIcon(new ImageIcon(login.getClass().getResource("/Libraries/img/btnCadastrar2.png")));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnCadastrar.setIcon(new ImageIcon(login.getClass().getResource("/Libraries/img/btnCadastrar1.png")));
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							CardLayout c = (CardLayout)(panels.getLayout());
							c.show(panels, "cadastrar");
							
						}catch(Exception e) 
						{
							
						}
					}
				});
				login.setLayout(null);
				btnCadastrar.setIcon(new ImageIcon(login.getClass().getResource("/Libraries/img/btnCadastrar1.png")));
				btnCadastrar.setBackground(SystemColor.window);
				btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnCadastrar.setBorderPainted(false);
				btnCadastrar.setBorder(null);
				btnCadastrar.setBounds(230, 400, 177, 41);
				login.add(btnCadastrar);
				
				
				JButton btnAcessar = new JButton("");
				btnAcessar.setIcon(new ImageIcon(login.getClass().getResource("/Libraries/img/btnAcessar1.png")));
				btnAcessar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnAcessar.setIcon(new ImageIcon(login.getClass().getResource("/Libraries/img/btnAcessar2.png")));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnAcessar.setIcon(new ImageIcon(login.getClass().getResource("/Libraries/img/btnAcessar1.png")));
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
				login.add(btnAcessar);
				
				txtEmail = new JTextField();
				txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
				txtEmail.setBorder(null);
				txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
				txtEmail.setBackground(new Color(28, 28, 28));
				txtEmail.setBounds(233, 286, 361, 32);
				login.add(txtEmail);
				txtEmail.setColumns(10);
				
				txtSenha = new JPasswordField();
				txtSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
				txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
				txtSenha.setColumns(10);
				txtSenha.setBorder(null);
				txtSenha.setBackground(new Color(28, 28, 28));
				txtSenha.setBounds(233, 347, 361, 32);
				login.add(txtSenha);
				
				JLabel wallpaper = new JLabel("");
				wallpaper.setBounds(0, 0, 834, 560);
				wallpaper.setIcon(new ImageIcon(LoginCadastro_tela.class.getResource("/Libraries/img/login.png")));
				login.add(wallpaper);
				
		JPanel cadastrar = new JPanel();
		cadastrar.setBounds(0,0,834,560);
		cadastrar.setLayout(null);
		panels.add(cadastrar, "cadastrar");
		
		CadtxtUsuario = new JTextField();
		CadtxtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		CadtxtUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		CadtxtUsuario.setColumns(10);
		CadtxtUsuario.setBorder(null);
		CadtxtUsuario.setBackground(new Color(28, 28, 28));
		CadtxtUsuario.setBounds(426, 217, 361, 32);
		cadastrar.add(CadtxtUsuario);
		
		CadtxtSenha = new JPasswordField();
		CadtxtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		CadtxtSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		CadtxtSenha.setColumns(10);
		CadtxtSenha.setBorder(null);
		CadtxtSenha.setBackground(new Color(28, 28, 28));
		CadtxtSenha.setBounds(426, 349, 361, 32);
		cadastrar.add(CadtxtSenha);
		
		CadtxtEmail = new JTextField();
		CadtxtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		CadtxtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		CadtxtEmail.setColumns(10);
		CadtxtEmail.setBorder(null);
		CadtxtEmail.setBackground(new Color(28, 28, 28));
		CadtxtEmail.setBounds(426, 278, 361, 32);
		cadastrar.add(CadtxtEmail);
		
		JTextField CadtxtNome = new JTextField();
		CadtxtNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		CadtxtNome.setBorder(null);
		CadtxtNome.setHorizontalAlignment(SwingConstants.CENTER);
		CadtxtNome.setBackground(new Color(28, 28, 28));
		CadtxtNome.setBounds(426, 157, 361, 32);
		CadtxtNome.setColumns(10);
		cadastrar.add(CadtxtNome);
		
		JButton btnCadastrarc = new JButton("Cadastrar");
		btnCadastrarc.setForeground(SystemColor.desktop);
		btnCadastrarc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarc.setBorderPainted(false);
		btnCadastrarc.setBorder(null);
		btnCadastrarc.setBackground(SystemColor.inactiveCaptionBorder);
		btnCadastrarc.setAlignmentX(0.5f);
		btnCadastrarc.setBounds(618, 432, 177, 41);
		cadastrar.add(btnCadastrarc);
		
		btnCadastrarc.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					CadastrarUsuario cu = new CadastrarUsuario();
					JOptionPane.showMessageDialog(null, cu.Cadastrar(CadtxtNome.getText(),CadtxtUsuario.getText(),CadtxtEmail.getText(),CadtxtSenha.getText()));
					if(JOptionPane.OK_OPTION == 0) {
						CadtxtNome.setText("");
						CadtxtEmail.setText("");
						CadtxtUsuario.setText("");
						CadtxtEmail.setText("");
						CadtxtSenha.setText("");
						CardLayout c = (CardLayout)(panels.getLayout());
						c.show(panels, "login");
					}
					
				}catch(Exception e) 
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
					if(JOptionPane.OK_OPTION == 0) {
						CadtxtNome.setText("");
						CadtxtEmail.setText("");
						CadtxtUsuario.setText("");
						CadtxtEmail.setText("");
						CadtxtSenha.setText("");
					}
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setAlignmentX(0.5f);
		btnCancelar.setBounds(420, 432, 177, 41);
		cadastrar.add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					CardLayout c = (CardLayout)(panels.getLayout());
					c.show(panels, "login");
				}catch(Exception e) 
				{
					
				}
			}
		});
		
		JLabel wallpaper2 = new JLabel("");
		wallpaper2.setIcon(new ImageIcon(LoginCadastro_tela.class.getResource("/Libraries/img/telaCadastro.png")));
		wallpaper2.setBounds(0, 0, 834, 560);
		cadastrar.add(wallpaper2);
		
		

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
		frame.getContentPane().add(nav);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setResizable(false);
	}
}
