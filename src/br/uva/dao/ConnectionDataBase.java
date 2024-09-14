package br.uva.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDataBase {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL_MYSQL = "jdbc:mysql://localhost/dbcontato";
	private static final String USER = "root";
	private static final String PASS = "22179750";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL_MYSQL, USER, PASS);

		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexão", ex);
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {

			} // TODO Auto-generated catch block
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		if (stmt != null) {
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
		if (rs != null) {
		}

	}
}
