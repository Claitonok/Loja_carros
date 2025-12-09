package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection obterConexao() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db_database?useSSL=false","root","");
			System.out.println("O BANCO DE DADOS FOI CONECTADO COM SUCCESS!!!!");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("NÃO FOI POSSIVEL CONECTAR AO BANCO DE DADOS");
			e.printStackTrace();
		}
		
		return conn;
	}

}
