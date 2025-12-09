package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojaDao {

	public void cadastra(Loja loja) {

		Connection conn = Conexao.obterConexao();

		String sql = "INSERT INTO loja_carro(marca, modelo, cor, km, valor) VALUES (?,?,?,?,?)";
		try {

			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, loja.getMarca());
			preparador.setString(2, loja.getModelo());
			preparador.setString(3, loja.getCor());
			preparador.setDouble(4, loja.getKm());
			preparador.setDouble(5, loja.getValor());

			preparador.execute();
			preparador.close();
			System.out.println("CARROS CADASTRADO COM SUCCESS");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Loja> mostrarTodos(int limitPag, int pagina) {

		Connection conn = Conexao.obterConexao();
		List<Loja> ListUsers = new ArrayList<>();
		String sql = "SELECT * FROM loja_carro ORDER BY id LIMIT ? OFFSET ?";
		try {

			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1, limitPag);
			preparador.setInt(2, pagina);
			preparador.execute();

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Loja loja = new Loja();

				loja.setId(resultado.getInt("id"));
				loja.setMarca(resultado.getString("marca"));
				loja.setModelo(resultado.getString("modelo"));
				loja.setCor(resultado.getString("cor"));
				loja.setKm(resultado.getDouble("km"));
				loja.setValor(resultado.getDouble("valor"));

				ListUsers.add(loja);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListUsers;
	}

	public void excluirPorId(int id) {
		Connection conn = Conexao.obterConexao();

		String sql = "DELETE FROM loja_carro WHERE id=?";
		try {

			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1, id);

			preparador.execute();
			preparador.close();

			System.out.println("CARROS EXCLUIDOS COM SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void alterar(Loja loja) {
		// TODO Auto-generated method stub
		Connection conn = Conexao.obterConexao();
		String sql = "UPDATE loja_carro SET marca=?, modelo=?, cor=?, km=?, valor=? WHERE id=?";
		try {

			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, loja.getMarca());
			preparador.setString(2, loja.getModelo());
			preparador.setString(3, loja.getCor());
			preparador.setDouble(4, loja.getKm());
			preparador.setDouble(5, loja.getValor());
			preparador.setInt(6, loja.getId());

			preparador.execute();
			preparador.close();
			System.out.println("CARROS ALTERADOS COM SUCCESS");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Loja MostrarAlterarId(int id) {

		Connection conn = Conexao.obterConexao();
		Loja loj = null;

		String sql = "SELECT * FROM loja_carro WHERE id=?";

		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				loj = new Loja();
				loj.setId(resultado.getInt("id"));
				loj.setMarca(resultado.getString("marca"));
				loj.setModelo(resultado.getString("modelo"));
				loj.setCor(resultado.getString("cor"));
				loj.setKm(resultado.getDouble("km"));
				loj.setValor(resultado.getDouble("valor"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return loj;
	}

}
