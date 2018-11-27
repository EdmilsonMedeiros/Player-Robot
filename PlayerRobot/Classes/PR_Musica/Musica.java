package PR_Musica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import PR_Categoria.Categoria;
import PR_Compositor.Compositor;

///
/// CLASSE ABSTRATA DE MUSICA
///
public class Musica {
	// Objetos
	private int id;
	private String Nome;
	private String DataLancamento;
	private Compositor Compositor;
	private Categoria Categoria;
	private String CodigoDoMp3Servidor;
	private String UrlDaImagem;
	private ImageIcon Imagem;
	private Mp3File mp3;
	private File ArquivoMP3;

	public Musica() {
	}

	public Musica(int id, String nome, String dataLancamento, Compositor compositor, Categoria categoria,
			String CodigoServidor) {
		this();
		this.id = id;
		Nome = nome;
		this.DataLancamento = dataLancamento;
		this.Compositor = compositor;
		this.Categoria = categoria;
		this.CodigoDoMp3Servidor = CodigoServidor;
	}

	// Metodos da Classe padrão

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDataLancamento() {
		return DataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.DataLancamento = dataLancamento;
	}

	public Compositor getCompositor() {
		return Compositor;
	}

	public void setCompositor(Compositor compositor) {
		this.Compositor = compositor;
	}

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.Categoria = categoria;
	}

	public String getCodigoMp3Servidor() {
		return CodigoDoMp3Servidor;
	}

	public void setCodigoMp3Servidor(String codigoServidor) {
		this.CodigoDoMp3Servidor = codigoServidor;
	}

	public File getArquivoMP3() {
		return ArquivoMP3;
	}

	public void setArquivoMP3(File arquivoMP3) throws UnsupportedTagException, InvalidDataException, IOException {
		ArquivoMP3 = arquivoMP3;
		this.mp3 = new Mp3File(arquivoMP3);
		this.AtualizarDadosDaMusica();
	}

	public String getUrlDaImagem() {
		return UrlDaImagem;
	}

	public void setUrlDaImagem(String urlDaImagem) {
		UrlDaImagem = urlDaImagem;
	}

	public Mp3File getMp3() {
		return mp3;
	}

	public void setMp3(Mp3File mp3) {
		this.mp3 = mp3;
	}

	public ImageIcon getImagem() {
		return Imagem;
	}

	public void setImagem(ImageIcon imagem) {
		Imagem = imagem;
	}

	// Metodos para funcionamentos do Player

	private int tamanho;
	private int numberframes;
	private double timeFinal;
	private int bitrate;
	private int frameLength;
	private int sizeOfTag;
	private int currentFrame;
	private byte[] byteInsert;

	public void AtualizarDadosDaMusica() throws IOException {
		this.setCurrentFrame(0);
		this.setInformacao();
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getNumberframes() {
		return numberframes;
	}

	public void setNumberframes(int numberframes) {
		this.numberframes = numberframes;
	}

	public double getTimeFinal() {
		return timeFinal;
	}

	public void setTimeFinal(double timeFinal) {
		this.timeFinal = timeFinal;
	}

	public int getBitrate() {
		return bitrate;
	}

	public void setBitrate(String bitrate) {
		switch (Integer.valueOf(bitrate)) {
		case 0:
			this.bitrate = 128;
			break;
		case 1:
			this.bitrate = 32;
			break;
		case 10:
			this.bitrate = 40;
			break;
		case 11:
			this.bitrate = 48;
			break;
		case 100:
			this.bitrate = 56;
			break;
		case 101:
			this.bitrate = 64;
			break;
		case 110:
			this.bitrate = 80;
			break;
		case 111:
			this.bitrate = 96;
			break;
		case 1000:
			this.bitrate = 112;
			break;
		case 1001:
			this.bitrate = 128;
			break;
		case 1010:
			this.bitrate = 160;
			break;
		case 1011:
			this.bitrate = 192;
			break;
		case 1100:
			this.bitrate = 224;
			break;
		case 1101:
			this.bitrate = 256;
			break;
		case 1110:
			this.bitrate = 320;
			break;
		case 1111:
			this.bitrate = 320;
			break;
		}
	}

	public int getFrameLength() {
		return frameLength;
	}

	public void setFrameLength(int frameLength) {
		this.frameLength = frameLength;
	}

	public int getSizeOfTag() {
		return sizeOfTag;
	}

	public void setSizeOfTag(int sizeOfTag) {
		this.sizeOfTag = sizeOfTag;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
		//this.currentFrame = (int) (currentFrame * numberframes / this.timeFinal);
	}

	public void increaseCurrentFrame() {
		this.currentFrame = this.currentFrame + (int) (numberframes / (20 * this.timeFinal));
	}

	public int getCurrentTimeSecond() {
		int currentTime = (int) (this.currentFrame * this.timeFinal / numberframes);
		return currentTime;
	}

	public String getCurrentTime() {
		int currentTime = (int) (this.currentFrame * this.timeFinal / numberframes);
		String hour = String.valueOf((int) currentTime / 3600);
		String minute = String.valueOf((int) (currentTime / 60) - Integer.valueOf(hour) * 60);
		String second = String.valueOf(currentTime - Integer.valueOf(minute) * 60);
		String time = hour + ":" + minute + ":" + second;
		return time;
	}

	public String getTotalTime(){
		String hour = String.valueOf((int) (this.timeFinal / 3600));
		String minute = String.valueOf((int) (this.timeFinal / 60) - Integer.valueOf(hour) * 60);
		String second = String.valueOf((int) this.timeFinal - Integer.valueOf(minute) * 60);
		String time = hour + ":" + minute + ":" + second;
		return time;
	}

	public byte[] getByteInsert() {
		return byteInsert;
	}

	public void setByteInsert(byte[] byteInsert) {
		this.byteInsert = byteInsert;
	}

	// IMPLEMENTAÇÕES DE OUTRA APLICAÇÃO
	private void setInformacao() throws IOException {
		try {
			setNumberFrames();
			this.timeFinal = mp3.getLengthInSeconds();
			this.tamanho = (int)mp3.getLength();
			FileInputStream fileInput = new FileInputStream(ArquivoMP3);
			//tamanho = (int) ArquivoMP3.length();
			fileInput.skip(tamanho - 128);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setSizeOfTag() {
		this.sizeOfTag = 0;
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(ArquivoMP3);
			fileInput.skip(6);
			byte[] byteFrame = new byte[4];
			fileInput.read(byteFrame);
			String s1 = String.format("%8s", Integer.toBinaryString(byteFrame[0] & 0xFF)).replace(' ', '0').substring(1,
					8);
			String s2 = String.format("%8s", Integer.toBinaryString(byteFrame[1] & 0xFF)).replace(' ', '0').substring(1,
					8);
			String s3 = String.format("%8s", Integer.toBinaryString(byteFrame[2] & 0xFF)).replace(' ', '0').substring(1,
					8);
			String s4 = String.format("%8s", Integer.toBinaryString(byteFrame[3] & 0xFF)).replace(' ', '0').substring(1,
					8);

			String size = s1 + s2 + s3 + s4;
			this.sizeOfTag = Integer.parseInt(size, 2);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void setNumberFrames() {
		setSizeOfTag();
		/*FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(ArquivoMP3);
			fileInput.skip(getSizeOfTag() + 10);
			byte[] byteFrame = new byte[4];
			fileInput.read(byteFrame);
			String f1 = String.format("%8s", Integer.toBinaryString(byteFrame[0] & 0xFF)).replace(' ', '0');
			String f2 = String.format("%8s", Integer.toBinaryString(byteFrame[1] & 0xFF)).replace(' ', '0');
			String f3 = String.format("%8s", Integer.toBinaryString(byteFrame[2] & 0xFF)).replace(' ', '0');
			String f4 = String.format("%8s", Integer.toBinaryString(byteFrame[3] & 0xFF)).replace(' ', '0');
			String frames = f1 + f2 + f3 + f4;
			setBitrate(frames.substring(16, 20));
			getBitrate();
			int sampRate = 0;
			switch (Integer.valueOf(frames.substring(20, 22))) {
			case 0:
				sampRate = 44100;
				break;
			case 1:
				sampRate = 48000;
				break;
			case 10:
				sampRate = 32000;
				break;
			}
			int padd = Integer.valueOf(frames.substring(22, 23));
			frameLength = (int) ((144 * bitrate * 1000) / sampRate + padd);
			this.numberframes = (int) (ArquivoMP3.length() - getSizeOfTag() - 128) / frameLength;
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		this.numberframes = mp3.getFrameCount();
	}
}
