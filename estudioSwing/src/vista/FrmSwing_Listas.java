package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrmSwing_Listas extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JList listPoblacion;
	private DefaultListModel modelo;

	public FrmSwing_Listas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		definirVentana();
		setVisible(true);
	}

	private void definirVentana() {
		panel_1 = new JPanel();
		panel_1.setBounds(56, 47, 143, 159);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultListModel();
		listPoblacion = new JList(modelo);
		scrollPane.setViewportView(listPoblacion);
		modelo.addElement("Jerez");
	}
}
