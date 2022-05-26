package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Carton extends JFrame {

	private JPanel panel;
	private JButton btnNewButton;
	private int carton[][];
	private List<JButton> botones;

	public Carton(int c) {
		setTitle("Carton " + c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 349);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new GridLayout(3, 9, 0, 0));
		botones = new ArrayList<JButton>();
		definirCarton();
		definirVentana();
		setVisible(true);
	}
	

	public void evento(int num) {
		for (JButton boton : botones) {
			if (boton.getText().equals(Integer.toString(num))) {
				boton.setBackground(Color.GREEN);
			}
		}
		for (int x = 0; x < carton.length; x++) {
			for (int y = 0; y < carton[x].length; y++) {
				
			}
		}
	}

	private void definirCarton() {
		carton = new int[3][9];
		int num = 0;
		int menor = 1;
		int mayor = 10;
		for (int y = 0; y < carton[0].length; y++) {
			int c[] = new int[3];
			for (int x = 0; x < carton.length; x++) {
				do {
					num = (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
				} while (repe(num, c));
				c[x] = num;
			}
			Arrays.sort(c);
			for (int x = 0; x < carton.length; x++) {
				carton[x][y] = c[x];
			}
			mayor+=10;
			menor+=10;
		}
		for (int x = 0; x < carton.length; x++) {
			System.out.println(Arrays.toString(carton[x]));
		}
		System.out.println();
		int cartonHuecos[][] = new int[3][9];
		boolean repe = false;
		for (int x = 0; x < cartonHuecos.length; x++) {
			int c[] = new int[4];
			for (int y = 0; y < c.length; y++) {
				do {
					num = (int) Math.floor(Math.random() * (8 - 0 + 1) + 0);
				} while (repe(num, c));
				c[y] = num;
			}
			for (int y = 0; y < c.length; y++) {
				cartonHuecos[x][c[y]] = 1;
			}
		}
		do {
			repe = false;
			for (int y = 0; y < cartonHuecos[0].length; y++) {
				int suma = 0;
				for (int x = 0; x < cartonHuecos.length; x++) {
					suma+=cartonHuecos[x][y];
				}
				if (suma == 3) {
					repe = true;
					int x = (int) (Math.random() * 3);
					cartonHuecos[x][y] = 0;
					int y2 = 0;
					do {
						y2 = (int) (Math.random() * 9);
					} while (y2 == y || cartonHuecos[x][y2] == 1);
					cartonHuecos[x][y2] = 1;
				}
			}
		} while (repe);
		for (int x = 0; x < cartonHuecos.length; x++) {
			System.out.println(Arrays.toString(cartonHuecos[x]));
		}
		System.out.println();
		for (int x = 0; x < carton.length; x++) {
			for (int y = 0; y < carton[0].length; y++) {
				if (cartonHuecos[x][y] == 1) {
					carton[x][y] = 0;
				}
			}
		}
		for (int x = 0; x < carton.length; x++) {
			System.out.println(Arrays.toString(carton[x]));
		}
	}

	public int[][] getCarton() {
		return carton;
	}

	public void setCarton(int[][] carton) {
		this.carton = carton;
	}

	private boolean repe(int num, int[] c) {
		boolean repe = false;
		for (int x = 0; x < c.length; x++) {
			if (num == c[x]) {
				repe = true;
			}
		}
		return repe;
	}

	private void definirVentana() {
		for (int x = 0; x < carton.length; x++) {
			for (int y = 0; y < carton[x].length; y++) {
				if (carton[x][y] == 0) {
					btnNewButton = new JButton("");
					btnNewButton.setBackground(Color.GRAY);
					panel.add(btnNewButton);
					botones.add(btnNewButton);
				} else {
					btnNewButton = new JButton(carton[x][y] + "");
					btnNewButton.setBackground(Color.WHITE);
					panel.add(btnNewButton);
					botones.add(btnNewButton);
				}
			}
		}
		
	}

}
