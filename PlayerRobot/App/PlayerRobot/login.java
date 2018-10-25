package PlayerRobot;
import Functions.Logar;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	int x, y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(23,23,23));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel navbar = new JLabel("");
		
		navbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		navbar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int xx = arg0.getXOnScreen();
				int yy = arg0.getYOnScreen();
				login.this.setLocation(xx - x, yy - y);
			}
		});
		
		JButton btnClose = new JButton("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnClose.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnfecharcima.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnClose.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnfechar.png")));
			}
		});
		
		JLabel imgload = new JLabel("");
		imgload.setHorizontalTextPosition(SwingConstants.CENTER);
		imgload.setHorizontalAlignment(SwingConstants.CENTER);
		imgload.setAlignmentX(Component.CENTER_ALIGNMENT);
		imgload.setBounds(205, 259, 420, 208);
		ImageIcon img = new ImageIcon(login.class.getResource("/Libraries/img/load.gif"));
		Image imag = img.getImage().getScaledInstance(imgload.getWidth(), imgload.getHeight(), Image.SCALE_FAST);
		imgload.setIcon(new ImageIcon(imag));
		imgload.setVisible(false);
		contentPane.add(imgload);
		
		
		btnClose.setBackground(new Color(23,23,23));
		btnClose.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClose.setBorderPainted(false);
		btnClose.setBorder(null);
		btnClose.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClose.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnfechar.png")));
		btnClose.setBounds(787, 0, 48, 41);
		contentPane.add(btnClose);
		navbar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/navbar.png")));
		navbar.setBounds(0, 0, 845, 41);
		contentPane.add(navbar);
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnCadastrar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnCadastrar1.png")));
			}
		});
		btnCadastrar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnCadastrar1.png")));
		btnCadastrar.setBackground(SystemColor.window);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setBorder(null);
		btnCadastrar.setBounds(230, 400, 177, 41);
		contentPane.add(btnCadastrar);
		

		JButton btnAcessar = new JButton("");
		btnAcessar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnAcessar1.png")));
		btnAcessar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAcessar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnAcessar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAcessar.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/btnAcessar1.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					imgload.setVisible(true);
					Logar logar = new Logar();
					btnAcessar.setVisible(false);
					btnCadastrar.setVisible(false);
					if(logar.start(txtEmail.getText(), txtSenha.getText())) {
						JMain main = new JMain();
						main.setVisible(true);
						login.this.dispose();
						
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					if(JOptionPane.OK_OPTION == 0) {
						txtSenha.setText("");
						imgload.setVisible(false);
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
		contentPane.add(btnAcessar);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEmail.setBorder(null);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBackground(new Color(28, 28, 28));
		txtEmail.setBounds(233, 286, 361, 32);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setColumns(10);
		txtSenha.setBorder(null);
		txtSenha.setBackground(new Color(28, 28, 28));
		txtSenha.setBounds(233, 347, 361, 32);
		contentPane.add(txtSenha);
		
		JLabel body = new JLabel("");
		body.setBorder(null);
		body.setAlignmentX(Component.CENTER_ALIGNMENT);
		body.setFont(new Font("Tahoma", Font.PLAIN, 16));
		body.setBounds(0, 0, 834, 564);
		body.setRequestFocusEnabled(false);
		body.setFocusTraversalKeysEnabled(false);
		body.setFocusable(false);
		body.setIcon(new ImageIcon(login.class.getResource("/Libraries/img/login.png")));
		contentPane.add(body);
	
		
	}
	
}
