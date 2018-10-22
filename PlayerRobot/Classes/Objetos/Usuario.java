package Objetos;

public class Usuario {

	//Atributos da Classe
	private    int id;
	private String nick;
	private String email;
	private String nome;
	private String telefone;
	private String lkFoto;
	
	//informações seguidoers
	private String qtdSeguidores;
	private String qtdSeguindo;
	
	
	//Construtores da Classe
	public Usuario() {}
	public Usuario(int id, String nick, String email, String nome, String telefone, String lkFotos) {
		this.id       = id;
		this.nick     = nick;
		this.email    = email;
		this.nome     = nome;
		this.telefone = telefone;
		this.lkFoto   = lkFotos;
		
	}
	//Métodos da Classe
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLkFoto() {
		return lkFoto;
	}
	public void setLkFoto(String lkFoto) {
		this.lkFoto = lkFoto;
	}
	public String getQtdSeguidores() {
		return qtdSeguidores;
	}
	public void setQtdSeguidores(String qtdSeguidores) {
		this.qtdSeguidores = qtdSeguidores;
	}
	public String getQtdSeguindo() {
		return qtdSeguindo;
	}
	public void setQtdSeguindo(String qtdSeguindo) {
		this.qtdSeguindo = qtdSeguindo;
	}
}
