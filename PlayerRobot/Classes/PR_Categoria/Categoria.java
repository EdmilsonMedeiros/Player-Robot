package PR_Categoria;
///
/// CLASSE ABSTRATA DE CATEGORIAS DE MUSICAS
///
public class Categoria {
	//OBJETOS
	private int id;
	private String descricao;
	//CONSTRUTORES
	public Categoria() {}
	public Categoria(int id, String descricao) {
		this();
		this.id = id;
		this.descricao = descricao;
	}
	
	//METODOS 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
