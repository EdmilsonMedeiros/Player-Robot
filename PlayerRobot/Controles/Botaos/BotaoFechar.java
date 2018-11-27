package Botaos;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BotaoFechar extends JButton {
	public BotaoFechar() 
	{
		setBackground(new Color(23,23,23));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setBorderPainted(false);
		setBorder(null);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setIcon(new ImageIcon(this.getClass().getResource("/Libraries/img/btnfechar.png")));
		setBounds(787, 0, 48, 41);
	}
}
