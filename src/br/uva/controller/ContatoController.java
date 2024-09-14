package br.uva.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JOptionPane;

import br.uva.dao.ConnectionDataBase;
import br.uva.dao.ContatoDao;
import br.uva.model.Contato;
//import br.uva.modelo.Categoria;

public class ContatoController {

	private Connection connection;
	private ContatoDao contatoDao;

	public ContatoController() {
		this.connection = ConnectionDataBase.getConnection();
		 contatoDao = new ContatoDao(connection);
	}

	// salvar um contato invocando o m�todo dao correspondente
	public void salvar(Contato contato) throws SQLException{

		this.contatoDao.salvar(contato);

		// Atentar para o fato de que a dtNascimento chega como String e, em Contato �
		// um LocalDate

	}

	public void alterar(Contato contato) throws SQLException {

		this.contatoDao.alterar(contato);
	}

	public List<Contato> listaContatos() {
		return this.contatoDao.listaContatos();
		} 
		
		

		// Retornar uma lista com todos os contatos invocando o m�todo dao
		// correspondente
		// Tratar o SQLException exibindo, em caso de erro, uma mensagem com um
		// showMessageDialog com o conte�do "Problemas ao localizar contatos" +
		// e.getLocalizedMessage() e retornando null

	

	public void excluir(long id2) throws SQLException {
		// excluir um contato por id invocando o m�todo dao correspondente
		this.contatoDao.excluir(id2);

	}

	public Contato buscaContatoPorNome(String nome) throws Exception {
		return this.contatoDao.buscaContatoPorNome(nome);
	}

	public void salvar(String text, String text2, String text3) {
		Contato contato = new Contato(text, text2, text3);		// TODO Auto-generated method stub
	try {
		this.contatoDao.salvar(contato);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}

	public void alterar(long id, String text, String text2, String text3) {
		Contato contato = new Contato(id,text, text2, text3);		// TODO Auto-generated method stub
		try {
			this.contatoDao.alterar(contato);
		   
			// TODO Auto-generated catch block
		
	
		}finally {
			
		}
	}
	
}
