package PR_Musica;

public class PlayListTipo {
	
	private int    Id;
	private String Descricao;
	
	public PlayListTipo() {}
	public PlayListTipo(int id, String descricao) {
		this();
		Id = id;
		Descricao = descricao;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
}
