package PR_Compositor;
import java.io.File;

///
/// CLASSE ABSTRATA DE COMPOSITOR
///
public class Compositor {
	//Objetos
	private int    id;
	private String nome;
	private File   Imagem;
	//Construtores
	public Compositor() {}
	public Compositor(int id, String nome, File imagem) {
		this();
		this.id = id;
		this.nome = nome;
		this.Imagem = imagem;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public File getImagem() {
		return Imagem;
	}
	public void setImagem(File imagem) {
		this.Imagem = imagem;
	} 
}