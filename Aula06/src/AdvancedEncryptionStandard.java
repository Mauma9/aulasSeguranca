import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AdvancedEncryptionStandard {
	private static String encriptar(String texto, String chave) throws Exception{
		Cipher objCifra = Cipher.getInstance("AES/CBC/PKCS5Padding");//inicia a cifra
		SecretKey objChave = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");//Inicialização e expansção da chave
		IvParameterSpec objIv = new IvParameterSpec("abcdefghijklmnop".getBytes());//Especificação do vetor de inicialização
		objCifra.init(Cipher.ENCRYPT_MODE, objChave, objIv);//inicialização da cifra
		byte[] cifra = objCifra.doFinal(texto.getBytes("UTF-8"));//Devolve uma rede de bytes(que é o texto criptografado[criptografia própriamente dita])
		return Base64.getEncoder().encodeToString(cifra);//Codificação do resultado
	}
	
	private static String decriptar(String cifra, String chave) throws Exception{
		Cipher objCifra = Cipher.getInstance("AES/CBC/PKCS5Padding");//inicia a cifra
		SecretKey objChave = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");//Inicialização e expansção da chave
		IvParameterSpec objIv = new IvParameterSpec("abcdefghijklmnop".getBytes());//Especificação do vetor de inicialização
		objCifra.init(Cipher.DECRYPT_MODE, objChave, objIv);//inicialização da cifra
		byte[] texto = objCifra.doFinal(Base64.getDecoder().decode(cifra));
		return new String(texto, "UTF-8");
	}
	
	public static void main(String[] args) {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Digite um texto: ");
			String texto = leitor.readLine();
			
			System.out.println("Digite uma chave: ");
			String chave = leitor.readLine();
			
			String cifra = encriptar(texto, chave);
			System.out.println(cifra);
			System.out.println(decriptar(cifra, chave));
		} catch(Exception erro) {
			System.out.println(erro);
		}
	}
}
