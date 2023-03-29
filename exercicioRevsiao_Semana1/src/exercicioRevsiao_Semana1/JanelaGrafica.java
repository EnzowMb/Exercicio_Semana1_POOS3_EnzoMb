package exercicioRevsiao_Semana1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaGrafica extends JFrame implements ActionListener {
	private int TAM = 3, proximo, numeroAposta;
	private Dados jogo;
	private JPanel panel;
	private JLabel labelAposta;
	private JTextField apostaTxt;
	private JButton btnApostar, btnIniciar;
	
	public JanelaGrafica() {
		componentes();
		propriedadesJanela();
	}
	
	private void componentes() {
		panel = new JPanel();
		
		labelAposta = new JLabel("Insira um numero para apostar: ");
		
		apostaTxt = new JTextField(10);
		apostaTxt.setEditable(false);
		
		btnApostar = new JButton("Apostar");
		btnApostar.addActionListener(this);
		btnApostar.setEnabled(false);
		
		btnIniciar = new JButton("Iniciar Jogo");
		btnIniciar.addActionListener(this);
		
		addcomponentes();
	}
	
	private void addcomponentes() {
		panel.add(btnIniciar);
		panel.add(labelAposta);
		panel.add(apostaTxt);
		panel.add(btnApostar);
		add(panel);
	}
	
	private void propriedadesJanela() {
		setVisible(true);
        setTitle("Jogo de Dados Simples");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnIniciar) {
			apostaTxt.setEditable(true);
			btnApostar.setEnabled(true);
			btnIniciar.setEnabled(false);
			
			jogo = new Dados();
			proximo = 0;
		}
		
		if(e.getSource() == btnApostar) {
			numeroAposta = Integer.parseInt(apostaTxt.getText());
			int verificacao = TAM;
			
			if(jogo.Logica(numeroAposta) == 2) {
				apostaTxt.setText("");
				JOptionPane.showMessageDialog(null, "Voce acertou, parabens :)))");
				apostaTxt.setEditable(false);
				btnApostar.setEnabled(false);
				btnIniciar.setEnabled(true);
			} else {
				apostaTxt.setText("");
				if(proximo < TAM) {
					proximo++;
					JOptionPane.showMessageDialog(null, jogo + "  || Tentativas disponiveis: " + (verificacao - proximo));
					if(proximo == 3) {
						JOptionPane.showMessageDialog(this, "Acabou as tentativas!!");
						apostaTxt.setEditable(false);
						btnApostar.setEnabled(false);
						btnIniciar.setEnabled(true);
					}
				}
				
			}
		}
	}

}
