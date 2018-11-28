package Paineis;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import PR_Musica.Musica;
import PR_Musica.PlayList;
import PR_TimeLifeApp.TimeLifeApp;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import PR_Metodos_Musica.PegarMP3Servidor;
import PR_Metodos_PlayList.ExecutaPlayList;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;

public class PlayListPanelView extends JPanel {
	
public PlayListPanelView(PlayList pl) 
	{
		setBounds(new Rectangle(0, 0, 840, 486));
		setBackground(new Color(23,23,23));
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(638, 26, 89, 23);
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					setVisible(false);
					//setVisible(true);

				} catch (Throwable e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnVoltar);
		
		JButton btnTocarPlaylist = new JButton("TOCAR PLAYLIST");
		btnTocarPlaylist.setOpaque(false);
		btnTocarPlaylist.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTocarPlaylist.setForeground(new Color(255, 255, 255));
		btnTocarPlaylist.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTocarPlaylist.setBackground(new Color(34, 139, 34));
		btnTocarPlaylist.setBorder(null);
		btnTocarPlaylist.setBounds(592, 175, 135, 23);
		btnTocarPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					/*ExecutaPlayList epl = new ExecutaPlayList(pl);
					epl.RodarTodasAsMusicas();*/
					//setVisible(true);
					TimeLifeApp._playercontrol.addPlayList(pl);
					PegarMP3Servidor getMp3 = new PegarMP3Servidor();
					Musica m = TimeLifeApp._playercontrol.playlist.pesquisarMusicaPeloId(0);
					m.setArquivoMP3(getMp3.getMP3DoServidor(m.getCodigoMp3Servidor()));
					TimeLifeApp._playercontrol.addMusica(m);
					TimeLifeApp._playercontrol.play();
					
				} catch (Throwable e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnTocarPlaylist);
		
		
		JPanel todasMusicas = new JPanel();
		todasMusicas.setForeground(Color.WHITE);
		todasMusicas.setAutoscrolls(true);
		todasMusicas.setBounds(126, 209, 601, 23);
		todasMusicas.setLayout(new GridLayout(1, 3, 0, 0));
		todasMusicas.setBackground(SystemColor.activeCaptionText);
		add(todasMusicas);
		
		JLabel txtTitulo = new JLabel("Titulo");
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTitulo.setForeground(Color.WHITE);
		todasMusicas.add(txtTitulo);
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel txtArtista = new JLabel("Artista");
		txtArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtArtista.setForeground(Color.WHITE);
		txtArtista.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtArtista.setBounds(new Rectangle(0, 0, 30, 0));
		txtArtista.setHorizontalAlignment(SwingConstants.CENTER);
		txtArtista.setAlignmentX(Component.CENTER_ALIGNMENT);
		todasMusicas.add(txtArtista);
		
		JLabel txtAlbum = new JLabel("\u00C1lbum");
		txtAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAlbum.setForeground(Color.WHITE);
		txtAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		todasMusicas.add(txtAlbum);
		
		
		
		JLabel lblCriadoPor = new JLabel("Criado por: "+pl.getUsuario().getNick());
		lblCriadoPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCriadoPor.setForeground(Color.WHITE);
		lblCriadoPor.setBounds(309, 146, 273, 29);
		add(lblCriadoPor);
		
		JLabel lblNewLabel = new JLabel("PLAYLIST");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(308, 92, 110, 22);
		add(lblNewLabel);
		
		JLabel lblNomeDaPlaylist = new JLabel(pl.getNome());
		lblNomeDaPlaylist.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNomeDaPlaylist.setForeground(Color.WHITE);
		lblNomeDaPlaylist.setBounds(304, 103, 384, 50);
		add(lblNomeDaPlaylist);
		
		JLabel FotoPlayList = new JLabel("");
		FotoPlayList.setBackground(Color.GRAY);
		FotoPlayList.setOpaque(true);
		FotoPlayList.setHorizontalAlignment(SwingConstants.CENTER);
		FotoPlayList.setIcon(pl.getImagem());
		FotoPlayList.setBounds(128, 23, 171, 162);
		add(FotoPlayList);
		
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(PlayListPanelView.class.getResource("/Libraries/img/p1.png")));
		wallpaper.setBounds(0, 0, 840, 486);
		add(wallpaper);
	}
}
