package Paineis;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Botaos.BotaoFechar;

public class NavBar extends Panel{
	
	public NavBar() 
	{
		setBounds(0,0,845,38);
		setLayout(null);
		
		BotaoFechar btnFechar = new BotaoFechar();
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnFechar.setIcon(new ImageIcon(this.getClass().getResource("/Libraries/img/btnfecharcima.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnFechar.setIcon(new ImageIcon(this.getClass().getResource("/Libraries/img/btnfechar.png")));
			}
		});
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		add(btnFechar);
		
		JLabel navbar = new JLabel("");
		navbar.setIcon(new ImageIcon(this.getClass().getResource("/Libraries/img/navbar.png")));
		navbar.setBounds(0, 0, 845, 39);
		add(navbar);
	}
}
