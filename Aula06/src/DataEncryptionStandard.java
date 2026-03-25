import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DataEncryptionStandard {
	private static String encriptar(String texto, String chave) throws Exception {
		
		Cipher objCifra = Cipher.getInstance("DES"); //instanciação da cifra
		SecretKey objChave = new SecretKeySpec(chave.getBytes("UTF-8"), "DES");//Especificação e expanssão da chave 16 micro chaves de 48 bits cada uma
		objCifra.init(Cipher.ENCRYPT_MODE, objChave);//inicialização da cifra
		byte[] cifra = objCifra.doFinal(texto.getBytes("UTF-8"));//Devolve uma rede de bytes(que é o texto criptografado[criptografia própriamente dita])
		return Base64.getEncoder().encodeToString(cifra);//Codificação do resultado
	}
	
	private static String decriptar(String cifra, String chave) throws Exception {
			
			Cipher objCifra = Cipher.getInstance("DES");
			SecretKey objChave = new SecretKeySpec(chave.getBytes("UTF-8"), "DES");
			objCifra.init(Cipher.DECRYPT_MODE, objChave);
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
