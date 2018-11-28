package PR_Usuario;

import PR_Musica.PlayList;

///
/// CLASSE ABSTRATA USUARIO
///
public class Usuario {

	//Atributos da Classe
	private    int id;
	private String nick;
	private String email;
	private String nome;
	private String telefone;
	private String lkFoto;
	
	//informa��es seguidoers
	private String qtdSeguidores;
	private String qtdSeguindo;
	
	
	//Informa��es da conta
	private PlayList favorito;
	
	//Construtores da Classe
	public Usuario() {}
	public Usuario(int id, String nick, String email, String nome, String telefone, String lkFotos) {
		this();
		this.id       = id;
		this.nick     = nick;
		this.email    = email;
		this.nome     = nome;
		this.telefone = telefone;
		this.lkFoto   = lkFotos;
		
	}
	//M�todos da Classe
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
	public PlayList getFavorito() {
		return favorito;
	}
	public void setFavorito(PlayList favorito) {
		this.favorito = favorito;
	}
}
