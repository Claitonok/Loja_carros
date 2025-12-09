package teste;

import model.Loja;
import model.LojaDao;


public class TestCadastro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Loja loja = new Loja("BMW","RETE","ROXO",0,195.000);
		
		LojaDao userCadastra = new LojaDao();
		
		userCadastra.cadastra(loja);
		
		

	}

}
