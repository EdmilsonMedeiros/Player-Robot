package Paineis;

import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Botaos.BotaoPlayList;
import PR_Usuario.Usuario;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class UsuarioPerfil extends Panel{
	public UsuarioPerfil(Usuario user) 
	{
		setBounds(new Rectangle(0, 0, 840, 486));
		setLayout(null);
		
		JPanel body = new JPanel();
		body.setBounds(0, 0, 840, 486);
		body.setLayout(new CardLayout(0, 0));
		add(body);
		
		JPanel perfil = new JPanel();
		body.add(perfil, "perfil");
		perfil.setLayout(null);
		
		JLabel qtdSeguidores = new JLabel(user.getQtdSeguidores());
		qtdSeguidores.setBounds(461, 247, 105, 21);
		qtdSeguidores.setHorizontalAlignment(SwingConstants.CENTER);
		qtdSeguidores.setForeground(Color.WHITE);
		qtdSeguidores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		perfil.add(qtdSeguidores);
		
		JLabel qntSeguindo = new JLabel(user.getQtdSeguindo());
		qntSeguindo.setBounds(284, 247, 105, 21);
		qntSeguindo.setHorizontalAlignment(SwingConstants.CENTER);
		qntSeguindo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		qntSeguindo.setForeground(Color.WHITE);
		perfil.add(qntSeguindo);
		
		JLabel txtNomeUsuario = new JLabel(user.getNick());
		txtNomeUsuario.setBounds(340, 163, 161, 26);
		txtNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeUsuario.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtNomeUsuario.setForeground(Color.WHITE);
		perfil.add(txtNomeUsuario);
		
		PlayListPanel playlistpanel = new PlayListPanel();
		FlowLayout flowLayout = (FlowLayout) playlistpanel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setAlignment(FlowLayout.LEFT);
		playlistpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		playlistpanel.setAutoscrolls(true);
		playlistpanel.setBounds(36, 334, 776, 130);
		perfil.add(playlistpanel);
		
		PlayListPanelView plpv = new PlayListPanelView(user.getFavorito()); 
		body.add(plpv, "playlistnew");
		
		BotaoPlayList btnFavoritos = new BotaoPlayList(user.getFavorito());
		playlistpanel.add(btnFavoritos);
		btnFavoritos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnFavoritos.setPreferredSize(new Dimension(120, 120));
		btnFavoritos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					CardLayout c = (CardLayout)(body.getLayout());
					c.show(body, "playlistnew");
					
					//plpv.setVisible(true);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		JLabel wpp = new JLabel("");
		wpp.setBounds(0, 0, 840, 560);
		wpp.setIcon(new ImageIcon(UsuarioPerfil.class.getResource("/Libraries/img/perfill.png")));
		perfil.add(wpp);
				
	}
}
