package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JButton;

public class Carton2 extends JFrame {

	private JPanel panel;
	private int carton[][];
	private JButton btnNewButton;

	public Carton2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 327);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new GridLayout(3, 9, 0, 0));
		definirCarton();
		definitEventos();
		setVisible(true);
	}

	private void definitEventos() {
		for (int x = 0; x < carton.length; x++) {
			for (int y = 0; y < carton[x].length; y++) {
				if (carton[x][y] == 0) {
					btnNewButton = new JButton("");
					btnNewButton.setBackground(Color.GRAY);
					panel.add(btnNewButton);
				} else {
					btnNewButton = new JButton(carton[x][y] + "");
					btnNewButton.setBackground(Color.WHITE);
					panel.add(btnNewButton);
				}
			}
		}
	}

	private void definirCarton() {
		carton = new int[3][9];
		int c[] = new int[3];
		int num = 0;
		int max = 10;
		int min = 1;
		for (int y = 0; y < carton[0].length; y++) {
			for (int x = 0; x < carton.length; x++) {
				do {
					num = (int) Math.floor(Math.random() * (max - min + 1) + min);
				} while (repe(num, c));
				c[x] = num;
			}
			Arrays.sort(c);
			for (int x = 0; x < c.length; x++) {
				carton[x][y] = c[x];
			}
			max+=10;
			min+=10;
		}
		for (int x = 0; x < carton.length; x++) {
			System.out.println(Arrays.toString(carton[x]));
		}
		System.out.println();
		int cartonHuecos[][] = new int[3][9];
		c = new int[4];
		for (int x = 0; x < cartonHuecos.length; x++) {
			for (int y = 0; y < c.length; y++) {
				do {
					num = (int) Math.floor(Math.random() * 9);
				} while (repe(num, c));
				c[y] = num;
			}
			for (int y = 0; y < c.length; y++) {
				cartonHuecos[x][c[y]] = 1;
			}
		}
		boolean repe = false;
		do {
			for (int y = 0; y < cartonHuecos[0].length; y++) {
				int suma = 0;
				for (int x = 0; x < cartonHuecos.length; x++) {
					suma+=cartonHuecos[x][y];
				}
				if (suma == 3) {
					repe = true;
					num = (int) Math.floor(Math.random() * 3);
					cartonHuecos[num][y] = 0;
					int num2 = (int) Math.floor(Math.random() * 9);
					cartonHuecos[num][num2] = 1;
				}
			}
		} while (repe);
		for (int x = 0; x < cartonHuecos.length; x++) {
			System.out.println(Arrays.toString(cartonHuecos[x]));
		}
		System.out.println();
		for (int x = 0; x < cartonHuecos.length; x++) {
			for (int y = 0; y < cartonHuecos[x].length; y++) {
				if (cartonHuecos[x][y] == 1) {
					carton[x][y] = 0;
				}
			}
			System.out.println(Arrays.toString(carton[x]));
		}
	}

	private boolean repe(int num, int[] c) {
		boolean repe = false;
		for (int x = 0; x < c.length; x++) {
			if (c[x] == num) {
				repe = true;
			}
		}
		return repe;
	}

}
