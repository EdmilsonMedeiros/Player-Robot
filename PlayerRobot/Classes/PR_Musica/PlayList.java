package PR_Musica;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import PR_Usuario.Usuario;

public class PlayList{
	
	private int 		 	  Id;
	private String 		 	  Nome;
	private String            Descricao;
	private String 		 	  UrlImagem;
	private ImageIcon         Imagem;
	private Usuario           Usuario;
	private PlayListTipo 	  Tipo;
	private ArrayList<Musica> Musicas;
	
	public PlayList() {
		this.Musicas = new ArrayList<Musica>();
	}
	public PlayList(int Id, String Nome, String UrlImagem, Usuario Usuario,PlayListTipo Tipo) 
	{
		this();
		this.Id = Id;
		this.Nome = Nome;
		this.UrlImagem = UrlImagem;
		this.Usuario = Usuario;
		this.Tipo = Tipo;
	}
	
	
	public void add(Musica m) 
	{
		this.Musicas.add(m);
	}
	
	public int Count() 
	{
		return this.Musicas.size();
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
    public String getUrlImagem() {
		return UrlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		UrlImagem = urlImagem;
	}
	public Usuario getUsuario() {
		return Usuario;
	}
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	public PlayListTipo getTipo() {
		return Tipo;
	}
	public void setTipo(PlayListTipo tipo) {
		Tipo = tipo;
	}
	public ArrayList<Musica> getMusicas() {
		return Musicas;
	}
	public void setMusicas(ArrayList<Musica> musicas) {
		Musicas = musicas;
	}
	public ImageIcon getImagem() {
		return Imagem;
	}
	public void setImagem(ImageIcon imagem) {
		Imagem = imagem;
	}
	public Musica pesquisarMusicaPeloId(int id) {
		for(int i = 0; i < this.Musicas.size(); i++) 
		{
			return this.Musicas.get(id);
		}
		return null;
	}
	
}