import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Visao extends JFrame {	
	//propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JTextArea txtTexto = new JTextArea();
	private JScrollPane jspTexto = new JScrollPane(txtTexto);
	
	private JTextField txtResumo = new JTextField();
	
	private JButton btnCalcular = new JButton("Calcular");
	
	//  Método principal de execução da classe
	public static void main(String[] args) {
		new Visao().setVisible(true);
	}
	
	//Método construtor da classe
	public Visao() {
		setTitle("Cálculo do Resumo Unidirecional SHA-256");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//Configuração da área de texto
		jspTexto.setBounds(30, 20, 930, 560);//posição x inicail, posição x final, largura e altura
		add(jspTexto);
		txtTexto.setLineWrap(true);
		
		//Configuração da caixa de resumo
		txtResumo.setBounds(30, 600, 930, 40);
		add(txtResumo);
		
		//Configuração botão calcular
		btnCalcular.setBounds(380, 660, 200, 20);
		add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					txtResumo.setText(SHA256.calcularHash(txtTexto.getText()));
					} catch (Exception erro) {}
				}
		});
	}
	
}
