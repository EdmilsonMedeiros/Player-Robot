package Paineis;

import java.awt.Panel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import PR_TimeLifeApp.TimeLifeApp;
import PR_Usuario.Usuario;

public class Perfil extends Panel {
	
	public Perfil(Usuario user) 
	{
		setBounds(new Rectangle(0, 519, 840, 486));
		setLayout(null);
		
		JLabel qtdSeguidores = new JLabel(user.getQtdSeguidores());
		qtdSeguidores.setHorizontalAlignment(SwingConstants.CENTER);
		qtdSeguidores.setForeground(Color.WHITE);
		qtdSeguidores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		qtdSeguidores.setBounds(474, 199, 77, 36);
		add(qtdSeguidores);
		
		JLabel qntSeguindo = new JLabel(user.getQtdSeguindo());
		qntSeguindo.setHorizontalAlignment(SwingConstants.CENTER);
		qntSeguindo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		qntSeguindo.setForeground(Color.WHITE);
		qntSeguindo.setBounds(294, 199, 77, 36);
		add(qntSeguindo);
		
		JLabel txtNomeUsuario = new JLabel(user.getNick());
		txtNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeUsuario.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtNomeUsuario.setForeground(Color.WHITE);
		txtNomeUsuario.setBounds(311, 143, 221, 24);
		add(txtNomeUsuario);
		
		JLabel body = new JLabel("");
		body.setIcon(new ImageIcon(Perfil.class.getResource("/Libraries/img/perfill.png")));
		body.setBounds(0, 0, 840, 486);
		add(body);
		
	}
}
