package Login;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Functions.Logar;
import Main.Main;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmPlayerrobot;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmPlayerrobot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerrobot = new JFrame();
		frmPlayerrobot.getContentPane().setMinimumSize(new Dimension(9, 9));
		frmPlayerrobot.getContentPane().setMaximumSize(new Dimension(9, 9));
		frmPlayerrobot.setForeground(Color.WHITE);
		frmPlayerrobot.setTitle("PlayerRobot");
		frmPlayerrobot.setResizable(false);
		frmPlayerrobot.setBackground(SystemColor.windowText);
		frmPlayerrobot.getContentPane().setBackground(new Color(23, 23, 23));
		frmPlayerrobot.getContentPane().setLayout(null);
		frmPlayerrobot.setBounds(100, 100, 340, 480);
		frmPlayerrobot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerrobot.setUndecorated(true);
		
		txtSenha = new JPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBounds(46, 316, 253, 28);
		frmPlayerrobot.getContentPane().add(txtSenha);
		
		JButton btnClose = new JButton("");
		btnClose.setBackground(new Color(63,62,62));
		btnClose.setIcon(new ImageIcon(Login.class.getResource("/Libraries/img/fechar.png")));
		btnClose.setBounds(291, 0, 49, 36);
		frmPlayerrobot.getContentPane().add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		txtEmail = new JTextField();
		txtEmail.setFont(txtEmail.getFont().deriveFont(txtEmail.getFont().getStyle() | Font.BOLD));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(46, 269, 253, 28);
		frmPlayerrobot.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAcessar = new JButton("");
		btnAcessar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAcessar.setContentAreaFilled(false);
		btnAcessar.setBorderPainted(false);
		btnAcessar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/Libraries/img/btnacessar.png")));
		btnAcessar.setBackground(new Color(63,62,62));
		
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logar logar = new Logar();
				try {
					boolean autentica = logar.start(txtEmail.getText(), txtSenha.getText());
					if(autentica == true) {
						Main main = new Main();
						main.setVisible(true);
						frmPlayerrobot.dispose();
						
						System.out.println("Conseguiu!");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnAcessar.setBounds(0, 421, 340, 59);
	
		
		frmPlayerrobot.getContentPane().add(btnAcessar);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Login.class.getResource("/Libraries/img/body.png")));
		logo.setBounds(0, 0, 340, 482);
		frmPlayerrobot.getContentPane().add(logo);
		
	}
}
