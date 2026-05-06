
public class AtaqueNumerico extends CrackDeSenhas implements Runnable{
	public void run() {
		for (int i = 0 ; i < 1000000000 ; i++) {
			String senha = "" + i;
			String usuario = mapaDeSenhas.get(calcularHash(senha));
			if (usuario != null) {
				System.out.println("Achei: " + usuario + " " + senha);
			}
		}
	}
}
