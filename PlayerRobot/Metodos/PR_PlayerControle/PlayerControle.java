package PR_PlayerControle;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import PR_Musica.Musica;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;
import PR_TimeLifeApp.TimeLifeApp;
import Paineis.Footer;

public class PlayerControle  extends PlaybackListener implements Runnable {
	
	public  Musica 		   musica;
	private AdvancedPlayer player;
	private Thread 		   playerThread;
	private int 	       inicioMusica;
	private int 		   finalMusica;
	private boolean 	   musicaTocando;
	public  boolean        continuarTocando;
	private int 		   number;
	public  int            tempo;
	private Footer         footer;
	
	
	public PlayerControle() {}
	
	public void addMusica(Musica ms) throws Exception {
		this.musica = ms;
	}
	public boolean possuiMusica() {
		if(musica != null) {
			return true;
		}
		return false;
	}
	public void play() throws Exception {
		this.number = 1;
		if(musicaTocando) {
			this.player.close();
		}
		this.musicaTocando = true;
		try
		{			
			FileInputStream mp3 = new FileInputStream(musica.getArquivoMP3());
			BufferedInputStream buffer = new BufferedInputStream(mp3);
			this.player = new AdvancedPlayer(buffer);
			this.player.setPlayBackListener(this);
			this.playerThread = new Thread(this,"AudioPlayerThread");
			this.playerThread.start();
			
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	
	public void Play(int startmusica) throws Exception{
		this.number = 2;
		if(musicaTocando) {
			this.player.close();
		}
		this.musicaTocando = true;
		musica.setCurrentFrame(startmusica);

		this.inicioMusica = (int) (startmusica);
		try
		{
			FileInputStream mp3 = new FileInputStream(musica.getArquivoMP3());
			BufferedInputStream buffer = new BufferedInputStream(mp3);
			this.player = new AdvancedPlayer(buffer);
			this.player.setPlayBackListener(this);
			this.playerThread = new Thread(this,"AudioPlayerThread");
			this.playerThread.start();
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public void Play(int iniciomusica, int finalmusic) throws Exception
	{
		this.number = 3;
		if(musicaTocando)
		{
			this.player.close();
		}
		this.musicaTocando = true;
		musica.setCurrentFrame(iniciomusica);
		this.inicioMusica = (int) (iniciomusica * musica.getMp3().getFrameCount() / musica.getTimeFinal());
		this.finalMusica  = (int) (finalmusic *musica.getMp3().getFrameCount() / musica.getTimeFinal());
		try
		{
			FileInputStream mp3 = new FileInputStream(musica.getArquivoMP3());
			BufferedInputStream buffer = new BufferedInputStream(mp3);
			this.player = new AdvancedPlayer(buffer);
			this.player.setPlayBackListener(this);
			this.playerThread = new Thread(this,"AudioPlayerThread");
			this.playerThread.start();
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
	
	public void PararMusica() {
		this.player.close();
		this.musicaTocando = false;
	}
	
	@Override
	public void run() {
		try {
			switch (number) {
			case 1:
				TimeLifeApp._footer.run();
				this.player.play();
				break;
			case 2:
				TimeLifeApp._footer.run();
				this.player.play(this.inicioMusica,musica.getMp3().getFrameCount());
				break;
			case 3:
				this.player.play(this.inicioMusica, this.finalMusica);
				break;
			}
		} catch (javazoom.jl.decoder.JavaLayerException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
