package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bingo extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	private JButton btnGenerarNumero;
	private JButton btnNuevoCarton;
	private JLabel lblNumero;
	private int []numerosBingo=new int [90];
	private List<JButton> buttons=new ArrayList<JButton>();
	private int count;
	private List<FrmModeloCarton> cartones=new ArrayList<FrmModeloCarton>();
	int contarCartones;
	private boolean linea=false;
	private boolean bingo=false;

	
	public Bingo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 749);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		definirVentana();
		definirEventos();
		setVisible(true);
	}


	private void definirEventos() {
		// TODO Auto-generated method stub
		btnGenerarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevoCarton.setEnabled(false);
				if (count==90) {
					btnGenerarNumero.setEnabled(false);
				}else {
					int numero=generarAleatoriosSinRepeticion(1, 1, 90);
					String numeroStr=String.valueOf(numero);
					for (int x=0;x<buttons.size();x++) {
						if (buttons.get(x).getText().equals(numeroStr)) {
							buttons.get(x).setBackground(Color.GREEN);
							buttons.get(x).setEnabled(true);
						}
						
					}
					lblNumero.setText(numeroStr);
					for (int x=0;x<cartones.size();x++) {
						for (int y=0;y<cartones.get(x).listaPaneles.size();y++) {
							if (cartones.get(x).listaPaneles.get(y).getText().equals(numeroStr)) {
								cartones.get(x).listaPaneles.get(y).setBackground(Color.GREEN);
								if (y<9) {
									cartones.get(x).contarLinea[0]++;
								}else if (y>=9 && y<18) {
									cartones.get(x).contarLinea[1]++;
								}else {
									cartones.get(x).contarLinea[2]++;
								}
							}
							
						}
						
					}
					if (linea==false) {
						cantarLinea();
					}
					if (bingo==false) {
						cantarBingo();
					}
					
				}
				
				
			}

			private void cantarBingo() {
				// TODO Auto-generated method stub
				for (int x=0;x<cartones.size();x++) {
					int total=cartones.get(x).contarLinea[0]+cartones.get(x).contarLinea[1]+cartones.get(x).contarLinea[2];
					if (total==15) {
						JFrame jFrame = new JFrame();
				        JOptionPane.showMessageDialog(jFrame, "El carton " + (x+1) + " tiene bingo");
				        bingo=true;
				        btnGenerarNumero.setEnabled(false);
					}
						
					
					
				}
			}

			private void cantarLinea() {
				// TODO Auto-generated method stub
				for (int x=0;x<cartones.size();x++) {
					if (cartones.get(x).contarLinea[0]==5) {
						JFrame jFrame = new JFrame();
				        JOptionPane.showMessageDialog(jFrame, "El carton " + (x+1) + " tiene linea en fila " + 1);
				        linea=true;
					}else if (cartones.get(x).contarLinea[1]==5) {
						JFrame jFrame = new JFrame();
				        JOptionPane.showMessageDialog(jFrame, "El carton " + (x+1) + " tiene linea en fila " + 2);
				        linea=true;
					}else if (cartones.get(x).contarLinea[2]==5) {
						JFrame jFrame = new JFrame();
				        JOptionPane.showMessageDialog(jFrame, "El carton " + (x+1) + " tiene linea en fila " + 3);
				        linea=true;
					}
					
				}
			}
		});
		
		btnNuevoCarton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmModeloCarton carton=new FrmModeloCarton(contarCartones++);
				cartones.add(carton);
			}
		});
	}


	private void definirVentana() {
		// TODO Auto-generated method stub
		panel_1 = new JPanel();
		panel_1.setBounds(30, 23, 805, 457);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(9, 10, 0, 0));
		
		
		
		for (int x=1;x<=90;x++) {
			JButton boton = new JButton(""+ x);
			panel_1.add(boton);
			buttons.add(boton);
			
		}
		
		btnGenerarNumero = new JButton("Generar Numero");
		btnGenerarNumero.setBounds(549, 547, 184, 39);
		panel.add(btnGenerarNumero);
		
		btnNuevoCarton = new JButton("Nuevo Carton");
		
		btnNuevoCarton.setBounds(549, 596, 184, 39);
		panel.add(btnNuevoCarton);
		
		lblNumero = new JLabel("_ _");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNumero.setBounds(205, 519, 215, 126);
		panel.add(lblNumero);
		
		
	}
	
	private int generarAleatoriosSinRepeticion(int cantidad, int menor, int mayor) {
		// TODO Auto-generated method stub
		
		int num = 0;
		
				do {
					num = (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
				} while (repetido(num, numerosBingo));
				numerosBingo[count++] = num;
			
		return num;
	}
	
	private boolean repetido(int num, int[] aleatorio) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		for (int x = 0; x < aleatorio.length; x++) {
			if (num == aleatorio[x]) {
				bandera = true;
				break;
			}

		}
		return bandera;
	}
}