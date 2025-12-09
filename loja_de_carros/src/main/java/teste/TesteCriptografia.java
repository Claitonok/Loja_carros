package teste;

import java.util.Base64;

public class TesteCriptografia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String textoOriginal = "esta é uma string de teste para serialização/deserialização em Base64";
        System.out.println("Texto original: " + textoOriginal);
        
        String textoSerializado = Base64.getEncoder().encodeToString(textoOriginal.getBytes());
        System.out.println("\n");
        System.out.println("Texto em Base64: " + textoSerializado);

        String textoDeserializado = new String(Base64.getDecoder().decode(textoSerializado));
        System.out.println("\n");
        System.out.println("Texto deserializado: "+ textoDeserializado);
        
	}

}
