package neto_news.portal.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import neto_news.portal.Objects.Perfil;

public class SenhaService {
       
	public static String Criptografar(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		   
		   MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	       byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

	       StringBuilder hexString = new StringBuilder();
	       for (byte b : messageDigest) {
	         hexString.append(String.format("%02X", 0xFF & b));
	       }
	       String senhahex = hexString.toString();

	       return senhahex;
	}
	
	public static boolean VerificarSenha(Perfil perfil, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String crip = Criptografar(senha);
		return crip.equals(perfil.getSenha());
	}
}
