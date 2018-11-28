package Paineis;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Botaos.BotaoPlayList;
import Main.Main_tela;
import PR_Metodos_Musica.PegarMP3Servidor;
import PR_Musica.PlayList;
import PR_TimeLifeApp.TimeLifeApp;

public class PlayListPanel extends JPanel {
	
	public PlayListPanel() 
	{
		setBounds(0, 0, 707, 140);
		this.setBackground(new Color(23,23,23));
	}
}
