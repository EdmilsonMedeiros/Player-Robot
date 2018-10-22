package Functions;

import java.io.BufferedInputStream;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayMusica  {	
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser(); 										//SELECIONA O ARQUIVO MP3
		int result = fc.showOpenDialog(null);
		
																					//ENTÃO, SE ESCOLHEMOS O ARQUIVO, PODEMOS PROSSEGUIR
		if(result == JFileChooser.APPROVE_OPTION) {
			try {
				File file = new File(fc.getSelectedFile().getAbsolutePath());
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				try {
					Player player = new Player(bis);
					System.out.println(fc.getSelectedFile().getAbsolutePath()); 	//APENAS PARA MOSTRAR UM ARQUIVO
					player.play();
				}catch(JavaLayerException e) {
					System.out.println("Impossivel ler o arquivo");
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}