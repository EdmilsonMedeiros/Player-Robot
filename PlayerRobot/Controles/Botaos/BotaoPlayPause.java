package Botaos;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import PR_TimeLifeApp.TimeLifeApp;
import Paineis.Footer;

public class BotaoPlayPause extends JButton {
	
	private boolean tocando;
	private Footer  p;
	
	public BotaoPlayPause(Footer panel) {
		tocando = false;
		this.p = panel;
		this.setIcon(new ImageIcon(panel.getClass().getResource("/Libraries/img/btnplayer.png")));
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TimeLifeApp._playercontrol.possuiMusica()) 
				{
					if (tocando) {
						tocando = false;
						MudarImagem(false);
						TimeLifeApp._playercontrol.PararMusica();
						p.pause();
					} else {
						tocando = true;
						MudarImagem(true);
						try {
							int pausado = TimeLifeApp._playercontrol.musica.getCurrentFrame();
							TimeLifeApp._playercontrol.Play(pausado);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						p.run();
					}
				}
				
			}
		});
		this.setMnemonic(KeyEvent.VK_P);
	}
	
	public void tatocando(boolean toca) {
		this.tocando = toca;
	}
	
	public void MudarImagem(boolean op) 
	{
		if(op) 
		{
			ImageIcon imgPause1 = new ImageIcon(p.getClass().getResource("/Libraries/img/btnpause.png"));
			Image imagPause1 = imgPause1.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(imagPause1));
		}else 
		{
			ImageIcon imgPause = new ImageIcon(p.getClass().getResource("/Libraries/img/btnplayer.png"));
			Image imagPause = imgPause.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(imagPause));
		}
	}
}
