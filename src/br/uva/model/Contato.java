package br.uva.model;

import java.util.Optional;
import java.sql.Date;
import java.time.Year;



public class Contato {
	
	

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	
	
	public Contato(String text, String text2, String text3) {
		nome = text;
		// TODO Auto-generated constructor stub
		email = text2;
		telefone = text3;
	}
	public Contato() {
		// TODO Auto-generated constructor stub
	}
	public Contato(long id2, String text, String text2, String text3) {
		id = id2;
		// TODO Auto-generated constructor stub
		nome = text;
		email = text2;
		telefone = text3;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id2) {
		this.id = id2;
	}
	public String getNome() {
				return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
				return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public static Contato buscaContatoPorNome() {
		// TODO Auto-generated method stub
		return null;
	}
}