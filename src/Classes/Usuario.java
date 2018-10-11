/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Natanael
 */
public class Usuario {
    //Atributos da Classe
	private    int id;
	private String nick;
	private String email;
	private String nome;
	private    int telefone;
	private String lkFoto;
	//Construtores da Classe
	public Usuario() {}
	public Usuario(int id, String nick, String email, String nome, int telefone, String lkFotos) {
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
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getLkFoto() {
		return lkFoto;
	}
	public void setLkFoto(String lkFoto) {
		this.lkFoto = lkFoto;
	}
}
