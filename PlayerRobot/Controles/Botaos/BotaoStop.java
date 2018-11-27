package Botaos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import PR_TimeLifeApp.TimeLifeApp;
import Paineis.Footer;

public class BotaoStop extends JButton {
	
	public BotaoStop(Footer panel) 
	{
		setIcon(new ImageIcon(panel.getClass().getResource("/Libraries/img/btnstop.png")));
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TimeLifeApp._playercontrol.PararMusica();
				TimeLifeApp._footer.stop();
			}
		});
		this.setMnemonic(KeyEvent.VK_P);
		
		
	}
}
