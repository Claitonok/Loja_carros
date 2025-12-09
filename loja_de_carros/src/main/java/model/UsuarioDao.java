package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

//	PARA COMENTAR CTRL + SHIFT + C

	public void cadastar_Users(Usuarios usuario) {

		Connection conn = Conexao.obterConexao();

		String sql = "INSERT INTO api_db(nome, email, password) VALUES (?,?,?)";

		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());

			preparador.setString(3, usuario.getSenha());
			preparador.execute();
			preparador.close();

			System.out.println("USUARIO CADASTRADO COM SUCCESS");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar_Users(Usuarios usuario) {
		Connection conn = Conexao.obterConexao();
		String sql = "UPDATE api_db SET nome=?, email=?, password=? WHERE id=?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());

			preparador.setInt(4, usuario.getId());

			preparador.execute();
			preparador.close();
			System.out.println("USUARIO ALTERADO COM SUCCESS");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirPorId(int id) {
		Connection conn = Conexao.obterConexao();

		String sql = "DELETE FROM api_db WHERE id=?";
		try {

			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1, id);

			preparador.execute();
			preparador.close();

			System.out.println("USUARIO EXCLUIDOS COM SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuarios autentica(String email, String senha) {
		Connection conn = Conexao.obterConexao();
		Usuarios usuario = null;
		String sql = "SELECT * FROM api_db WHERE email=? and password=?";

		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, email);
			preparador.setString(2, senha);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				usuario = new Usuarios();
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	public Usuarios verifai_Users(String email) {

		Connection conn = Conexao.obterConexao();
		Usuarios usuario = null;
		String sql = "SELECT * FROM api_db WHERE email=?";

		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, email);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				usuario = new Usuarios();
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("password"));

				usuario.setId(resultado.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	public Usuarios Verifica_email_logar(String email) {

		Connection conn = Conexao.obterConexao();
		Usuarios usu = null;
		String sql = "SELECT * FROM api_db WHERE email=?";

		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, email);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				usu = new Usuarios();
//				usu.setEmail(resultado.getString("email"));
				usu.setSenha(resultado.getString("password"));

//				usu.setId(resultado.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
	}

}
