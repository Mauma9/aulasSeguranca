
public class AtaqueAlfabeticoMaiusculoTresLetras extends CrackDeSenhas implements Runnable{
	public void run() {
		for(int i = 65 ; i < 91 ; i++) {
			for(int j = 65 ; j < 91 ; j++) {
				for(int k = 65 ; k < 91 ; k++) {
					for(int l = 65 ; l < 91 ; l++) {
						String senha = "" + ((char) i) + ((char) j) + ((char) k) + ((char) l);
						String usuario = mapaDeSenhas.get(calcularHash(senha));
						if (usuario != null) {
							System.out.println("Achei: " + usuario + " " + senha);
						}
					}
				}
			}
		}
		
	}
}
