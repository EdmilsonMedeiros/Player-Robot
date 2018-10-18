package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 583, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setForeground(Color.DARK_GRAY);
		btnPlay.setBackground(Color.GRAY);
		btnPlay.setBounds(178, 276, 89, 57);
		frame.getContentPane().add(btnPlay);
		
		JButton button = new JButton(">>");
		button.setBackground(Color.GRAY);
		button.setForeground(Color.LIGHT_GRAY);
		button.setBounds(430, 293, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("<<");
		button_1.setBackground(Color.GRAY);
		button_1.setForeground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(57, 293, 89, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnPuse = new JButton("Puse");
		btnPuse.setForeground(Color.DARK_GRAY);
		btnPuse.setBackground(Color.GRAY);
		btnPuse.setBounds(303, 276, 89, 57);
		frame.getContentPane().add(btnPuse);
		
		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setFont(new Font("Track", Font.PLAIN, 11));
		lblMusica.setForeground(Color.WHITE);
		lblMusica.setBounds(57, 221, 462, 14);
		frame.getContentPane().add(lblMusica);
	}
}
