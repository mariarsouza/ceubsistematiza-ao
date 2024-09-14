package br.uva.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.uva.model.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao(Connection connection) {
		this.connection = connection;
	}

	// Implementar c�digo para inserir o contato no banco de dados e fechar conex�es
	public void salvar(Contato contato) throws SQLException {
		String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)){
			{
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getEmail());
				pstm.setObject(3, contato.getTelefone());
				pstm.executeUpdate();
				int rowsInserted = pstm.executeUpdate();

				if (rowsInserted > 0)
					;
				System.out.println("Um novo Contato foi inserido");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
				}
			
		

	

	// Implementar c�digo para alterar o contato no banco de dados e fechar conex�es
	public void alterar(Contato contato){
		String sql = "UPDATE contatos SET nome=?, email=?, telefone=? where idcon=?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setObject(3, contato.getTelefone());
			pstm.setLong(4, contato.getId());
			pstm.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Implementar c�digo para excluir o contato no banco de dados e fechar conex�es
	public void excluir(long id2) throws SQLException {
		String sql = "DELETE FROM contatos WHERE idcon = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setLong(1, id2);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> listaContatos() {
		String sql = "SELECT * FROM contatos";
		List<Contato> contatos = new ArrayList<Contato>();
		Connection connection = null;
		PreparedStatement pstm = null;

		ResultSet rst = null;
		try {
			connection = ConnectionDataBase.getConnection();
            pstm = connection.prepareStatement(sql);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
            	while(rst.next()) {
                    Contato contato = new Contato();
                    contato.setId(rst.getLong("idcon"));
                    contato.setNome(rst.getString("nome"));
                    contato.setEmail(rst.getString("email"));
                    contato.setTelefone(rst.getString("telefone"));
                contatos.add(contato);
                           	}
            	
            }
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return contatos;
	}
	
                	
                

	// Implementar c�digo para devolver um List com todos os contatos no banco de
	// dados e fechar conex�es
	// Atentar para o fato de que a data_nascimento � um Date do MySQL e getDate
	// retorna um java.sql.Date e dtNascimento � um LocalDate

	public Contato buscaContatoPorNome(String nome) throws Exception {
		String sql = "SELECT * contatos FROM nome";
ResultSet rs = null;
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, "%" + nome + "%");
			rs = pstm.executeQuery();
					if(!rs.next()) {
						throw new Exception("N�o foi Encontrado" + "Nome: " + nome);
					}
					
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			return null;
		
	}
}