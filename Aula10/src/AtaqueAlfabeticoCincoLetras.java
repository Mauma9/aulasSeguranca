public class AtaqueAlfabeticoCincoLetras extends CrackDeSenhas implements Runnable{

	public void run() {
		for(int i = 65 ; i < 123 ; i++) {
			for(int j = 65 ; j < 123 ; j++) {
				for(int k = 65 ; k < 123 ; k++) {
					for(int l = 65 ; l < 123 ; l++) {
						for(int m = 65 ; m  < 123 ; m++) {
							String senha = "" + ((char) i) + ((char) j) + ((char) k) + ((char) l) + ((char) m);
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
}