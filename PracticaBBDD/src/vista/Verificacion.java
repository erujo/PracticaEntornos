package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Verificacion extends JFrame {

	private JPanel panel;
	private JLabel lblSeguro;
	private JButton btnSi;
	private JButton btnNo;
	private boolean borrar;

	public Verificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		definirVentana();
		eventos();
		setVisible(true);
	}

	private void eventos() {
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar = true;
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar = false;
				System.exit(EXIT_ON_CLOSE);
			}
		});
	}

	private void definirVentana() {
		lblSeguro = new JLabel("\u00BFSeguro que quiere eliminar?");
		lblSeguro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSeguro.setBounds(62, 11, 311, 121);
		panel.add(lblSeguro);
		
		btnSi = new JButton("SI");
		btnSi.setBounds(34, 143, 108, 59);
		panel.add(btnSi);
		
		btnNo = new JButton("NO");
		btnNo.setBounds(299, 143, 108, 59);
		panel.add(btnNo);
	}

	public boolean isBorrar() {
		return borrar;
	}
	
	
}
