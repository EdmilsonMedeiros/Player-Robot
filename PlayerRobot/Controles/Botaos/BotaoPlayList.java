package Botaos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import PR_Musica.PlayList;

public class BotaoPlayList extends JButton{
	
	public BotaoPlayList(PlayList playlist) 
	{
		setIconTextGap(-10);
		setRequestFocusEnabled(false);
		setVerticalAlignment(SwingConstants.BOTTOM);
		this.setMaximumSize(new Dimension(120, 120));
		this.setMinimumSize(new Dimension(120, 120));
		this.setPreferredSize(getPreferredSize());

		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("Tahoma", Font.BOLD, 13));
		setText(playlist.getNome());
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setBounds(0, 0, 120, 120);
		applyComponentOrientation(getComponentOrientation());
		setBorder(null);
		setFocusPainted(false);
        setFocusable(false);
        setLayout(new BorderLayout());

		//Image imag = new javax.swing.ImageIcon(this.getClass().getResource("/Libraries/img/pause.jpg")).getImage();
		setIcon(playlist.getImagem());
	}
}
