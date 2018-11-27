package PR_Metodos_Musica;

import java.awt.MediaTracker;
import java.net.URL;

import javax.swing.ImageIcon;

public class PegarImage {
	public PegarImage() {}
	public ImageIcon getImage(String url) throws Exception {
		try 
		{
		     URL urlImg = new URL(url);
		     ImageIcon imgIcon = new ImageIcon(urlImg);
		     while(imgIcon.getImageLoadStatus() == MediaTracker.LOADING); 
		     return imgIcon;
		     
		}catch(Exception e)
		{
			throw new Exception("Erro ao Baixar Imagem da Musica");
		}
	}
}
