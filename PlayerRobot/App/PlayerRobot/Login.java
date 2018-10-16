package PlayerRobot;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Functions.Logar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmPlayerrobot;
	private JTextField txtSenha;
	private JTextField txtEmail;

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
		frmPlayerrobot.getContentPane().setSize(new Dimension(9, 9));
		frmPlayerrobot.getContentPane().setMinimumSize(new Dimension(9, 9));
		frmPlayerrobot.getContentPane().setMaximumSize(new Dimension(9, 9));
		frmPlayerrobot.setForeground(Color.WHITE);
		frmPlayerrobot.setTitle("PlayerRobot");
		frmPlayerrobot.setResizable(false);
		frmPlayerrobot.setBackground(SystemColor.windowText);
		frmPlayerrobot.getContentPane().setBackground(new Color(23, 23, 23));
		frmPlayerrobot.getContentPane().setLayout(null);
		frmPlayerrobot.setBounds(100, 100, 335, 482);
		frmPlayerrobot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerrobot.setUndecorated(true);

		
		Panel navMenu = new Panel();
		navMenu.setBounds(0, 0, 335, 66);
		navMenu.setBackground(new Color(20, 26, 30));
		frmPlayerrobot.getContentPane().add(navMenu);
		navMenu.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		Button button_1 = new Button("New button");
		navMenu.add(button_1);
		
		Button button = new Button("New button");
		navMenu.add(button);
		
		JButton btnSair = new JButton("");
		btnSair.setBorderPainted(false);
		btnSair.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSair.setBorder(null);
		btnSair.setMinimumSize(new Dimension(9, 9));
		btnSair.setPreferredSize(new Dimension(50, 50));
		btnSair.setSize(new Dimension(10, 10));
		btnSair.setMaximumSize(new Dimension(9, 9));
		btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSair.setContentAreaFilled(false);
		btnSair.setBounds(new Rectangle(0, 0, 50, 50));
		btnSair.setIcon(new ImageIcon("E:\\Natanael\\Icon\\close_white.png"));
		btnSair.setForeground(SystemColor.text);
		btnSair.setBackground(SystemColor.controlText);
		navMenu.add(btnSair);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(76, 280, 206, 20);
		frmPlayerrobot.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(76, 224, 206, 20);
		frmPlayerrobot.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(137, 131, 46, 14);
		frmPlayerrobot.getContentPane().add(lblNewLabel);
		
		JButton btnAcessar = new JButton("ACESSAR");
		
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logar logar = new Logar();
				try {
					boolean autentica = logar.start(txtEmail.getText(), txtSenha.getText());
					if(autentica == true) {
						System.out.println("Conseguiu!");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		
		btnAcessar.setBounds(246, 429, 89, 53);
	
		
		frmPlayerrobot.getContentPane().add(btnAcessar);
		
	}
	
	
}
