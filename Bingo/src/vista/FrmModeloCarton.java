package vista;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.border.BevelBorder;

public class FrmModeloCarton extends JFrame {

	private JPanel panel;
	List<JTextPane> listaPaneles=new ArrayList<JTextPane>();
	JTextPane text00,text01,text02,text03,text04,text05,text06,text07,text08,text10,text11,text12,text13,text14,text15,text16,text17,text18,text20,text21,text22,text23,text24,text25,text26,text27,text28;
	int[]contarLinea=new int[3];
	

	
	public FrmModeloCarton(int contarCartones) {
		setTitle("Carton " + (contarCartones+1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 257);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		definirVentana();
		definirEventos();
		setContentPane(panel);
		panel.setLayout(new GridLayout(3, 9, 0, 0));
		setVisible(true);
	}


	private void definirEventos() {
		// TODO Auto-generated method stub
		int[][] cartonRellenoEntero = new int[3][9];
	int min = 1;
	int max = 9;
	int count = 0;
	do {

		int[] column = generarAleatoriosSinRepeticion(3, min, max);
		Arrays.sort(column);
		if (min == 1) {
			min += 9;
		} else {
			min += 10;
		}
		if (max == 79) {
			max += 11;
		} else {
			max += 10;
		}

		cartonRellenoEntero[0][count] = column[0];
		cartonRellenoEntero[1][count] = column[1];
		cartonRellenoEntero[2][count] = column[2];
		count++;

	} while (count != 9);

	/*for (int x = 0; x < cartonRellenoEntero.length; x++) {
		for (int y = 0; y < cartonRellenoEntero[x].length; y++) {
			System.out.print(cartonRellenoEntero[x][y] + " - ");

		}
		System.out.println();

	}*/
	int[][] cartonBlanco = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	boolean bandera = false;
	do {
		bandera = false;
		cartonBlanco = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		for (int x = 0; x < 3; x++) {
			int[] fila = generarAleatoriosSinRepeticion(5, 1, 9);
			Arrays.sort(fila);
			for (int y = 0; y < fila.length; y++) {
				cartonBlanco[x][fila[y] - 1] = 1;

			}

		}
		for (int y = 0; y < cartonBlanco[0].length; y++) {
			if ((cartonBlanco[0][y] + cartonBlanco[1][y] + cartonBlanco[2][y]) == 0) {
				bandera = true;

			}

		}

	} while (bandera);
	/*for (int x = 0; x < cartonBlanco.length; x++) {
		for (int y = 0; y < cartonBlanco[x].length; y++) {
			System.out.print(cartonBlanco[x][y] + " - ");

		}
		System.out.println();

	}
	*/
	int[][] cartonFinal = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	for (int x=0;x<cartonFinal.length;x++) {
		for (int y=0;y<cartonFinal[x].length;y++) {
			if (cartonBlanco[x][y]==1) {
				cartonFinal[x][y]=cartonRellenoEntero[x][y];
			}
			
		}
		
	}
	/*for (int x = 0; x < cartonFinal.length; x++) {
		for (int y = 0; y < cartonFinal[x].length; y++) {
			System.out.print(cartonFinal[x][y] + " - ");

		}
		System.out.println();

	}*/
	int contador=0;
	for (int x=0;x<cartonFinal.length;x++) {
		for (int y=0;y<cartonFinal[x].length;y++) {
			
			if (cartonFinal[x][y]==0) {
				listaPaneles.get(contador).setBackground(Color.BLACK);
			}else {
				String pasarNumero=String.valueOf(cartonFinal[x][y]);
				listaPaneles.get(contador).setText(pasarNumero);
				StyledDocument doc = listaPaneles.get(contador).getStyledDocument();
				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);
			}
			contador++;
		}
		
	}
	}


	private void definirVentana() {
		// TODO Auto-generated method stub
		text00 = new JTextPane();
		panel.add(text00);
		listaPaneles.add(text00);
		
		text01 = new JTextPane();
		panel.add(text01);
		listaPaneles.add(text01);
		
		text02 = new JTextPane();
		panel.add(text02);
		listaPaneles.add(text02);
		
		text03 = new JTextPane();
		panel.add(text03);
		listaPaneles.add(text03);
		
		text04 = new JTextPane();
		panel.add(text04);
		listaPaneles.add(text04);
		
		text05 = new JTextPane();
		panel.add(text05);
		listaPaneles.add(text05);
		
		text06 = new JTextPane();
		panel.add(text06);
		listaPaneles.add(text06);
		
		text07 = new JTextPane();
		panel.add(text07);
		listaPaneles.add(text07);
		
		text08 = new JTextPane();
		panel.add(text08);
		listaPaneles.add(text08);
		
		text10 = new JTextPane();
		panel.add(text10);
		listaPaneles.add(text10);
		
		text11 = new JTextPane();
		panel.add(text11);
		listaPaneles.add(text11); 
		
		text12 = new JTextPane();
		panel.add(text12);
		listaPaneles.add(text12);
		
		text13 = new JTextPane();
		panel.add(text13);
		listaPaneles.add(text13);
		
		text14 = new JTextPane();
		panel.add(text14);
		listaPaneles.add(text14);
		
		text15 = new JTextPane();
		panel.add(text15);
		listaPaneles.add(text15);
		
		text16 = new JTextPane();
		panel.add(text16);
		listaPaneles.add(text16);
		
		text17 = new JTextPane();
		panel.add(text17);
		listaPaneles.add(text17);
		
		text18 = new JTextPane();
		panel.add(text18);
		listaPaneles.add(text18);
		
		text20 = new JTextPane();
		panel.add(text20);
		listaPaneles.add(text20);
		
		text21 = new JTextPane();
		panel.add(text21);
		listaPaneles.add(text21);
		
		text22 = new JTextPane();
		panel.add(text22);
		listaPaneles.add(text22);
		
		text23 = new JTextPane();
		panel.add(text23);
		listaPaneles.add(text23);
		
		text24 = new JTextPane();
		panel.add(text24);
		listaPaneles.add(text24);
		
		text25 = new JTextPane();
		panel.add(text25);
		listaPaneles.add(text25);
		
		text26 = new JTextPane();
		panel.add(text26);
		listaPaneles.add(text26);
		
		text27 = new JTextPane();
		panel.add(text27);
		listaPaneles.add(text27);
		
		text28 = new JTextPane();
		panel.add(text28);
		listaPaneles.add(text28);
		
	}
	
	private int[] generarAleatoriosSinRepeticion(int cantidad, int menor, int mayor) {
		// TODO Auto-generated method stub
		int[] aleatorio = new int[cantidad];
		int num = 0;
		for (int x = 0; x < aleatorio.length; x++) {
			do {
				num = (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
			} while (repetido(num, aleatorio));
			aleatorio[x] = num;
		}
		return aleatorio;
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