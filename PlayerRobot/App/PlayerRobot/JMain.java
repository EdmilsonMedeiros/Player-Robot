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
import Functions.AtualizarSeguidores;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
		
		JPanel home = new JPanel();
		home.setLayout(null);
		home.setBorder(null);
		body.add(home, "home");
		
		JPanel home_1 = new JPanel();
		home_1.setLayout(null);
		home_1.setBorder(null);
		home_1.setBounds(0, 0, 840, 487);
		home.add(home_1);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(JMain.class.getResource("/Libraries/img/main.png")));
		label_8.setBounds(0, 0, 840, 486);
		home_1.add(label_8);
		
		JPanel Perfil = new JPanel();
		body.add(Perfil,"perfil");
		Perfil.setLayout(null);
		Perfil.setBorder(null);
		
		JPanel Perfil_body = new JPanel();
		Perfil_body.setBounds(0, 0, 840, 487);
		Perfil.add(Perfil_body);
		Perfil_body.setLayout(null);
		Perfil_body.setBorder(null);
		
		JLabel qtsSeguindo = new JLabel("");
		qtsSeguindo.setHorizontalAlignment(SwingConstants.CENTER);
		qtsSeguindo.setForeground(Color.WHITE);
		qtsSeguindo.setFont(new Font("Tahoma", Font.BOLD, 18));
		qtsSeguindo.setBounds(290, 206, 86, 22);
		Perfil_body.add(qtsSeguindo);
		
		JLabel qtdSeguidores = new JLabel("");
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
		
		JPanel search = new JPanel();
		search.setLayout(null);
		search.setBorder(null);
		body.add(search, "search");
		
		JPanel search_1 = new JPanel();
		search_1.setLayout(null);
		search_1.setBorder(null);
		search_1.setBounds(0, 0, 840, 487);
		search.add(search_1);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(290, 206, 86, 22);
		search_1.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(467, 206, 86, 22);
		search_1.add(label_2);
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(334, 145, 171, 22);
		search_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 840, 486);
		search_1.add(label_4);
		
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
		
		JButton btnSearch = new JButton("");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout c = (CardLayout) (body.getLayout());
				c.show(body, "search");
			}
		});
		btnSearch.setToolTipText("Seu perfil");
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setAlignmentX(0.5f);
		btnSearch.setBounds(735, 2, 40, 40);
		ImageIcon imgsearch = new ImageIcon(login.class.getResource("/Libraries/img/btnsearch.png"));
		Image imagSearch = imgsearch.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
		btnSearch.setIcon(new ImageIcon(imagSearch));
		Footer.add(btnSearch);
		
		JButton btnMain = new JButton("");
		btnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout c = (CardLayout)(body.getLayout());
				c.show(body,"home");
			}
		});
		btnMain.setToolTipText("Seu perfil");
		btnMain.setBorderPainted(false);
		btnMain.setBorder(null);
		btnMain.setAlignmentX(0.5f);
		btnMain.setBounds(685, 2, 40, 40);
		ImageIcon imgmain = new ImageIcon(login.class.getResource("/Libraries/img/btnmain.png"));
		Image imagMain = imgmain.getImage().getScaledInstance(btnMain.getWidth(), btnMain.getHeight(), Image.SCALE_SMOOTH);
		btnMain.setIcon(new ImageIcon(imagMain));
		Footer.add(btnMain);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setBackground(new Color(27,27,27));
		slider.setBounds(100, 13, 307, 19);
		Footer.add(slider);
		
		JButton btnPlayer = new JButton("");
		btnPlayer.setToolTipText("Esse você escolheu");
		btnPlayer.setBorderPainted(false);
		btnPlayer.setBorder(null);
		btnPlayer.setAlignmentX(0.5f);
		btnPlayer.setBounds(10, 2, 40, 40);
		ImageIcon imgplay = new ImageIcon(login.class.getResource("/Libraries/img/btnplayer.png"));
		Image imagPlay = imgplay.getImage().getScaledInstance(btnPlayer.getWidth(), btnPlayer.getHeight(), Image.SCALE_SMOOTH);
		btnPlayer.setIcon(new ImageIcon(imagPlay));
		Footer.add(btnPlayer);
		
		JButton btnVolume = new JButton("");
		btnVolume.setToolTipText("Volume");
		btnVolume.setBorderPainted(false);
		btnVolume.setBorder(null);
		btnVolume.setAlignmentX(0.5f);
		btnVolume.setBounds(417, 2, 40, 40);
		ImageIcon imgvolume = new ImageIcon(login.class.getResource("/Libraries/img/volumeon.png"));
		Image imagVolume = imgvolume.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
		btnVolume.setIcon(new ImageIcon(imagVolume));
		Footer.add(btnVolume);
		
		JSlider Volumebar = new JSlider();
		Volumebar.setValue(100);
		Volumebar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				if(Volumebar.getValue() == 0) {
					ImageIcon imgvolume = new ImageIcon(login.class.getResource("/Libraries/img/volumeoff.png"));
					Image imagVolume = imgvolume.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
					btnVolume.setIcon(new ImageIcon(imagVolume));
				}else if(Volumebar.getValue() < 50) {
					ImageIcon imgvolume = new ImageIcon(login.class.getResource("/Libraries/img/volumeonMed.png"));
					Image imagVolume = imgvolume.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
					btnVolume.setIcon(new ImageIcon(imagVolume));
				}else {
					ImageIcon imgvolume = new ImageIcon(login.class.getResource("/Libraries/img/volumeon.png"));
					Image imagVolume = imgvolume.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
					btnVolume.setIcon(new ImageIcon(imagVolume));
				}
				
			}
		});
		Volumebar.setBackground(new Color(27,27,27));
		Volumebar.setBounds(464, 13, 128, 19);
		Footer.add(Volumebar);
		
		JButton button_1 = new JButton("");
		button_1.setToolTipText("Seu perfil");
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setAlignmentX(0.5f);
		button_1.setBounds(55, 2, 40, 40);
		Footer.add(button_1);
		
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AtualizarSeguidores seguidores = new AtualizarSeguidores();
				
				try {
					if(seguidores.atualizar()) {
						qtsSeguindo.setText(App._usuario.getQtdSeguindo());
						qtdSeguidores.setText(App._usuario.getQtdSeguidores());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				CardLayout c = (CardLayout)(body.getLayout());
				c.show(body, "perfil");
			}
		});
	}
}
