package Paineis;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import Botaos.BotaoPerfil;
import Botaos.BotaoPlayPause;
import Botaos.BotaoStop;
import JSliders.LinhaDoTempo;
import Main.Main_tela;
import PR_Metodos_Musica.PegarMP3Servidor;
import PR_Musica.Musica;
import PR_Musica.PlayList;
import PR_TimeLifeApp.TimeLifeApp;
import java.awt.Font;

public class Footer extends Panel {
	private PegarMP3Servidor getMp3 = new PegarMP3Servidor();
	private Timer		   contador;
	private BotaoPlayPause btnPlayPause;
	private BotaoStop      btnStop;
	private LinhaDoTempo   linhadoTempo;
	private JLabel  	   tempoInicialMusica;
	private JLabel  	   tempoFinalMusica;
	private int			   valorAtual;
	
	public Footer() {
		this.btnPlayPause 		= new BotaoPlayPause(this);
		this.btnStop			= new BotaoStop(this);
		this.linhadoTempo 		= new LinhaDoTempo();
		contador = new Timer(55, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimeLifeApp._playercontrol.musica.increaseCurrentFrame();
				linhadoTempo.setMinimum(0);
				linhadoTempo.setMaximum((int)TimeLifeApp._playercontrol.musica.getMp3().getFrameCount());
				linhadoTempo.setValue(TimeLifeApp._playercontrol.musica.getCurrentFrame());
				TimeLifeApp._playercontrol.tempo = linhadoTempo.getValue();
				linhadoTempo.setMajorTickSpacing(10);
				linhadoTempo.setPaintTicks(false);
				linhadoTempo.setPaintLabels(false);
				linhadoTempo.setPaintTrack(true);
				tempoInicialMusica.setText(TimeLifeApp._playercontrol.musica.getCurrentTime());
				tempoFinalMusica.setText(TimeLifeApp._playercontrol.musica.getTotalTime());
				try {
					ContinuaTocando();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.setBounds(0, 519, 840, 41);
		this.setBackground(new Color(28,28,28));
		this.setLayout(null);
		linhadoTempo.setBackground(new Color(27,27,27));
		linhadoTempo.setBounds(110, 11, 307, 19);
		this.add(this.linhadoTempo);
		
		this.tempoInicialMusica = new JLabel("00:00:00"); 
		this.tempoInicialMusica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.tempoInicialMusica.setBounds(116, 26, 46, 14);
		this.add(this.tempoInicialMusica);
		
		this.tempoFinalMusica   = new JLabel("00:00:00");
		this.tempoFinalMusica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.tempoFinalMusica.setBounds(380, 26, 46, 14);
		this.add(this.tempoFinalMusica);
		
		btnPlayPause.setBorderPainted(false);
		btnPlayPause.setBorder(null);
		btnPlayPause.setAlignmentX(0.5f);
		btnPlayPause.setBounds(10, 2, 40, 40);
		this.add(this.btnPlayPause);
		
		btnStop.setBorderPainted(false);
		btnStop.setBorder(null);
		btnStop.setAlignmentX(0.5f);
		btnStop.setBounds(55, 2, 40, 40);
		this.add(this.btnStop);
		
	}
	
	public void run(){
		btnPlayPause.tatocando(true);
		btnPlayPause.MudarImagem(true);
		contador.start();
	}

	public void pause() {
		contador.stop();
		btnPlayPause.tatocando(false);
	}
		
	public void stop() {
		btnPlayPause.tatocando(false);
		linhadoTempo.setValue(0);
		TimeLifeApp._playercontrol.PararMusica();
		btnPlayPause.MudarImagem(false);
		this.tempoInicialMusica.setText("00:00:00");
		this.tempoFinalMusica.setText("00:00:00");
		this.contador.stop();
	}
	
	public void ContinuaTocando() throws Exception{
		if(TimeLifeApp._playercontrol.musica.getCurrentFrame() == TimeLifeApp._playercontrol.musica.getMp3().getFrameCount()) 
		{
			contador.stop();
			if(TimeLifeApp._playercontrol.continuarTocando == false) {
				this.stop();
				if(TimeLifeApp._playercontrol.tocandoplaylist)
				{
					for(Musica musica : TimeLifeApp._playercontrol.playlist.getMusicas()) 
					{
						if(musica.getId() != TimeLifeApp._playercontrol.musica.getId()) 
						{
							musica.setArquivoMP3(getMp3.getMP3DoServidor(musica.getCodigoMp3Servidor()));
							TimeLifeApp._playercontrol.addMusica(musica);
							TimeLifeApp._playercontrol.play();
						}
					}
				}
			}else
			{
				this.stop();
				TimeLifeApp._playercontrol.play();
			}
		}
	}
}
