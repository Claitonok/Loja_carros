package model;

import java.util.Base64;

public class Criptografar_senha {
	
	/**CRIPTOGRAFANDO 
	 * @param senha
	 * @return retorna uma string com a senha CRIPTOGRAFADA
	 * */
	public String criptografar_Bse64_Encode(String senha) {
		return new String(Base64.getEncoder().encodeToString(senha.getBytes()));
	}
	
	/**DESCRIPTOGRAFANDO
	 * @param senha
	 * @return retorna uma senha DESCRIPTOGRAFADA
	 * */
	public String criptografar_Base64_Decode(String senha) {
		return new String(Base64.getDecoder().decode(senha));
	}
}
