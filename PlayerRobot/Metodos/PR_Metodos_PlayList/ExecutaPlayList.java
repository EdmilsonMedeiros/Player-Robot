package PR_Metodos_PlayList;

import java.io.IOException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import PR_Metodos_Musica.PegarMP3Servidor;
import PR_Musica.Musica;
import PR_Musica.PlayList;
import PR_TimeLifeApp.TimeLifeApp;

public class ExecutaPlayList {
	
	PlayList playlist;
	PegarMP3Servidor getMp3;
	public ExecutaPlayList(PlayList play) 
	{
		getMp3 = new PegarMP3Servidor();
		this.playlist = play;
	}
	
	public void RodarTodasAsMusicas() throws UnsupportedTagException, InvalidDataException, IOException, Exception 
	{
		for (Musica musica : this.playlist.getMusicas()) 
		{
			if(!TimeLifeApp._playercontrol.musicaTocando) 
			{
				musica.setArquivoMP3(getMp3.getMP3DoServidor(musica.getCodigoMp3Servidor()));
				TimeLifeApp._playercontrol.addMusica(musica);
				TimeLifeApp._playercontrol.play();
			}
		}
	}
}
