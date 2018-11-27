package Botaos;

import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Main.Main_tela;

public class BotaoPerfil extends JButton {
	
	public BotaoPerfil(Main_tela panel) 
	{
		setIcon(new ImageIcon(panel.getClass().getResource("/Libraries/img/perfil.png")));
		
	}
}
