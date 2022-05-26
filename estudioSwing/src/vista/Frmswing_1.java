package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frmswing_1 extends JFrame {

	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JButton btnAceptar;
	private JLabel lblSaludo;

	public Frmswing_1() {
		setTitle("Hola mundo desde swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 309);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		definirVentana();
		definirEventos();
		setVisible(true);
	}

	private void definirEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				lblSaludo.setText("Hola, " + nombre);
			}
		});
	}

	private void definirVentana() {
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 53, 73, 14);
		panel.add(lblNombre);
		textNombre = new JTextField();
		textNombre.setBounds(81, 50, 86, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(177, 49, 89, 23);
		panel.add(btnAceptar);
		lblSaludo = new JLabel("");
		lblSaludo.setBounds(148, 111, 118, 14);
		panel.add(lblSaludo);
	}
}
