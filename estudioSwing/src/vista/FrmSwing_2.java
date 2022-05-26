package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrmSwing_2 extends JFrame implements ActionListener {

	private JPanel panel, panel_1;
	private JButton btnAceptar, btnCancelar;
	private JLabel lblEventos;

	public FrmSwing_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		definirVentana();
		definirEventos();
		setVisible(true);
	}

	private void definirEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEventos.setText("Aceptar");
				panel_1.setBackground(Color.GREEN);
			}
		});
		
		btnCancelar.addActionListener(this);
	}

	private void definirVentana() {
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(50, 57, 89, 23);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 57, 89, 23);
		panel.add(btnCancelar);
		
		lblEventos = new JLabel("Eventos");
		lblEventos.setBounds(151, 112, 111, 14);
		panel.add(lblEventos);
		
		panel_1 = new JPanel();
		panel_1.setBounds(136, 153, 94, 69);
		panel.add(panel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lblEventos.setText("Cancelar");
		panel_1.setBackground(Color.RED);
	}
}
