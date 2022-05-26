package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Bingo extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	private JButton numeros;
	private JButton btnNuevaPapelata, btnNuevoNumero;
	private List<JButton> botones;
	private List<Carton> cartones;
	private int nums[];
	private int c;
	private int c2;
	private JLabel lblNumeros;

	public Bingo() {
		setTitle("Bingo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 490);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		botones = new ArrayList<JButton>();
		cartones = new ArrayList<Carton>();
		nums = new int[90];
		c = 0;
		c2 = 0;
		definirVentana();
		definirEventos();
		setVisible(true);
	}

	private void definirEventos() {
		btnNuevaPapelata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c++;
				Carton carton = new Carton(c);
				cartones.add(carton);
			}
		});
		
		btnNuevoNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevaPapelata.setEnabled(false);
				int num = 0;
				do {
					num = (int) (Math.random() * 90 + 1);
				} while (repe(num));
				nums[c2] = num;
				c2++;
				lblNumeros.setText(num + "");
				for (JButton boton : botones) {
					if (Integer.parseInt(boton.getText()) == num) {
						boton.setBackground(Color.GREEN);
					}
				}
				for (Carton carton : cartones) {
					int numero[][] = carton.getCarton();
					for (int x = 0; x < numero.length; x++) {
						for (int y = 0; y < numero[x].length; y++) {
							if (numero[x][y] == num) {
								carton.evento(num);
							}
						}
					}
				}
				if (c2 == 90) {
					btnNuevoNumero.setEnabled(false);
				}
			}

			private boolean repe(int num) {
				boolean repe = false;
				for (int x = 0; x < nums.length; x++) {
					if (nums[x] == num) {
						repe = true;
					}
				}
				return repe;
			}
		});
	}

	private void definirVentana() {
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 637, 337);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 9, 0, 0));
		
		btnNuevaPapelata = new JButton("Nueva Papeleta");
		btnNuevaPapelata.setBounds(54, 371, 128, 40);
		panel.add(btnNuevaPapelata);
		
		btnNuevoNumero = new JButton("Nuevo Numero");
		btnNuevoNumero.setBounds(223, 371, 128, 40);
		panel.add(btnNuevoNumero);
		
		lblNumeros = new JLabel("");
		lblNumeros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNumeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeros.setBounds(417, 359, 136, 69);
		panel.add(lblNumeros);
		
		for (int x = 1; x <= 90; x++) {
			numeros = new JButton(x + "");
			numeros.setBackground(Color.WHITE);
			panel_1.add(numeros);
			botones.add(numeros);
		}
	}
}
