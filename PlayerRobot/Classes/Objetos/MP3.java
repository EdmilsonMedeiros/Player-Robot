package Objetos;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class MP3 {
	public void reprodutor(){

		FileInputStream in;
		//TRATAMENTO DE ERRO
		try {
		//INICIALIZA O FILEUPSTREAM COM O ENDEREÇO DO ARQUIVO PARA REPRODUZIR
		in = new FileInputStream("Libraries/03 Nossa Canção (feat. Leonardo Gonçalves) [Ao Vivo].mp3");

		//Cria uma instancia da classe player passando para ele o InpuStream do arquivo
		Player p = new Player(in);

		//executa o som
		p.play();

		} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JavaLayerException e) {
				e.printStackTrace();
		}

		}

		}