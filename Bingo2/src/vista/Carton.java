package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JButton;

public class Carton extends JFrame {

	private JPanel panel;
	private int carton[][];
	private JButton btnNewButton;

	public Carton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 328);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new GridLayout(3, 9, 0, 0));
		definirCarton();
		definiVentana();
		setVisible(true);
	}

	private void definiVentana() {
		for (int x = 0; x < carton.length; x++) {
			for (int y = 0; y < carton[x].length; y++) {
				if (carton[x][y] == 0) {
					btnNewButton = new JButton("");
					panel.add(btnNewButton);
					btnNewButton.setBackground(Color.GRAY);
				} else {
					btnNewButton = new JButton(carton[x][y] + "");
					panel.add(btnNewButton);
					btnNewButton.setBackground(Color.WHITE);
				}
			}
		}
	}

	private void definirCarton() {
		carton = new int[3][9];
		int num = 0;
		int min = 1;
		int max = 10;
		for (int y = 0; y < carton[0].length; y++) {
			int c[] = new int[3];
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
			min+=10;
			max+=10;
		}
		for (int x = 0; x < carton.length; x++) {
			System.out.println(Arrays.toString(carton[x]));
		}
		System.out.println();
		int cartonHuecos[][] = new int[3][9];
		for (int x = 0; x < cartonHuecos.length; x++) {
			int nums[] = new int[4];
			for (int y = 0; y < nums.length; y++) {
				do {
					num = (int) (Math.random() * 9);
				} while (repe(num, nums));
				nums[y] = num;
			}
			for (int y = 0; y < nums.length; y++) {
				cartonHuecos[x][nums[y]] = 1;
			}
		}
		boolean repe;
		do {
			repe = false;
			for (int y = 0; y < cartonHuecos[0].length; y++) {
				int suma = 0;
				for (int x = 0; x < cartonHuecos.length; x++) {
					suma+=cartonHuecos[x][y];
				}
				if (suma == 3) {
					repe = true;
					num = (int) (Math.random() * 3);
					cartonHuecos[num][y] = 0;
					int y2 = 0;
					do {
						y2 = (int) (Math.random() * 3);
					} while (cartonHuecos[num][y2] == 1);
					cartonHuecos[num][y2] = 1;
				}
			}
		} while (repe);
		for (int x = 0; x < carton.length; x++) {
			System.out.println(Arrays.toString(cartonHuecos[x]));
		}
		System.out.println();
		for (int x = 0; x < cartonHuecos.length; x++) {
			for (int y = 0; y < cartonHuecos[x].length; y++) {
				if (cartonHuecos[x][y] == 1) {
					carton[x][y] = 0;
				}
			}
		}
		for (int x = 0; x < carton.length; x++) {
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
