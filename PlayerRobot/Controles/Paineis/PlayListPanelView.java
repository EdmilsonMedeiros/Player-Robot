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
import Tables.Modelo_PlayList;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class PlayListPanelView extends JPanel {
	private JTable table;
	
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

		Modelo_PlayList modelplaylist = new Modelo_PlayList(pl.getMusicas());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(23,23,23)));
		scrollPane.setBounds(128, 222, 616, 233);
		scrollPane.getViewport().setBackground(new Color(23,23,23));
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionBackground(new Color(169, 169, 169));
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setForeground(Color.WHITE);
		table.setRowHeight(30);
		table.getTableHeader().setBorder(new LineBorder(new Color(23, 23, 23)));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.BLACK);
		table.setAutoCreateRowSorter(true);
		table.setBackground(new Color(23,23,23));
		table.setModel(modelplaylist);
		add(btnVoltar);
		
//		/	
				
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
