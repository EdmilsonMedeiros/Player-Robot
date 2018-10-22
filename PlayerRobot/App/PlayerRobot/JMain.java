package PlayerRobot;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Font;
import Static.App;

public class JMain extends JFrame {

	private JPanel Root;
	int x, y;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMain frame = new JMain();
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
	public JMain() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 560);
		Root = new JPanel();
		Root.setBorder(null);
		setContentPane(Root);
		Root.setLayout(null);
		
		JPanel Main = new JPanel();
		Main.setBounds(0, 0, 840, 560);
		Main.setBorder(null);
		Root.add(Main);
		Main.setLayout(null);
		ImageIcon imgperfil = new ImageIcon(login.class.getResource("/Libraries/img/perfil.png"));
		
		Panel navbar = new Panel();
		navbar.setBackground(new Color(23,23,23));
		navbar.setBounds(0, 0, 840, 41);
		Main.add(navbar);
		navbar.setLayout(null);
		
		JButton btnClose = new JButton("");
		btnClose.setBounds(778, 0, 63, 38);
		navbar.add(btnClose);
		btnClose.setToolTipText("Fechar aplicativo");
		btnClose.setIcon(new ImageIcon(JMain.class.getResource("/Libraries/img/btnfechar.png")));
		btnClose.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClose.setBorderPainted(false);
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(23, 23, 23));
		btnClose.setAlignmentX(0.5f);
		
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
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		JLabel nav = new JLabel("");
		nav.setBounds(0, 0, 840, 38);
		navbar.add(nav);
		nav.setBorder(null);
		nav.setAlignmentX(Component.CENTER_ALIGNMENT);
		nav.setIcon(new ImageIcon(JMain.class.getResource("/Libraries/img/navbar.png")));
		
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
				JMain.this.setLocation(xx - x, yy - y);
			}
		});
		
		JPanel body = new JPanel();
		body.setBorder(null);
		body.setBounds(0, 40, 840, 483);
		body.setLayout(new CardLayout(0, 0));
		Main.add(body);
		
		JLabel bodyHome = new JLabel("");
		body.add(bodyHome, "body");
		bodyHome.setIcon(new ImageIcon(JMain.class.getResource("/Libraries/img/main.png")));
		
		JPanel Perfil = new JPanel();
		body.add(Perfil,"perfil");
		Perfil.setLayout(null);
		Perfil.setBorder(null);
		
		JPanel Perfil_body = new JPanel();
		Perfil_body.setBounds(0, 0, 840, 487);
		Perfil.add(Perfil_body);
		Perfil_body.setLayout(null);
		Perfil_body.setBorder(null);
		
		JLabel qtsSeguindo = new JLabel(App._usuario.getQtdSeguindo());
		qtsSeguindo.setHorizontalAlignment(SwingConstants.CENTER);
		qtsSeguindo.setForeground(Color.WHITE);
		qtsSeguindo.setFont(new Font("Tahoma", Font.BOLD, 18));
		qtsSeguindo.setBounds(290, 206, 86, 22);
		Perfil_body.add(qtsSeguindo);
		
		JLabel qtdSeguidores = new JLabel(App._usuario.getQtdSeguidores());
		qtdSeguidores.setHorizontalAlignment(SwingConstants.CENTER);
		qtdSeguidores.setForeground(Color.WHITE);
		qtdSeguidores.setFont(new Font("Tahoma", Font.BOLD, 18));
		qtdSeguidores.setBounds(467, 206, 86, 22);
		Perfil_body.add(qtdSeguidores);
		
		JLabel txtNomeUser = new JLabel(App._usuario.getNick());
		txtNomeUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeUser.setForeground(Color.WHITE);
		txtNomeUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNomeUser.setBounds(334, 145, 171, 22);
		Perfil_body.add(txtNomeUser);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(JMain.class.getResource("/Libraries/img/perfill.png")));
		label_1.setBounds(0, 0, 840, 486);
		Perfil_body.add(label_1);
		
		Panel Footer = new Panel();
		Footer.setBounds(0, 519, 840, 41);
		Main.add(Footer);
		Footer.setBackground(new Color(28,28,28));
		Footer.setLayout(null);
		
		JButton btnPerfil = new JButton("");
		
		btnPerfil.setToolTipText("Seu perfil");
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBorder(null);
		btnPerfil.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPerfil.setBounds(785, 2, 40, 40);
		Image imagp = imgperfil.getImage().getScaledInstance(btnPerfil.getWidth(), btnPerfil.getHeight(), Image.SCALE_SMOOTH);
		btnPerfil.setIcon(new ImageIcon(imagp));
		Footer.add(btnPerfil);
		
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout c = (CardLayout)(body.getLayout());
				c.show(body, "perfil");
			}
		});
	}
}
