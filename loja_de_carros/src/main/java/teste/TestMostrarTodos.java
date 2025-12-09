package teste;

import java.util.List;

import model.Loja;
import model.LojaDao;

public class TestMostrarTodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LojaDao user = new LojaDao();
		List<Loja> list = user.mostrarTodos(10, 0);

		for (Loja loja : list) {
			System.out.println("id: " + loja.getId());
			System.out.println("Marca: " + loja.getMarca());
			System.out.println("Modelo: " + loja.getModelo());
			System.out.println("Cor: " + loja.getCor());
			System.out.println("Km: " + loja.getKm());
			System.out.println("Valor Do Carro: " + loja.getValor());
			System.out.println("\n");

		}

	}

}
