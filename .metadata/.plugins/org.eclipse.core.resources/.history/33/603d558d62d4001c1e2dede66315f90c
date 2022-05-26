package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class FrmLista extends JFrame {

	private JPanel panel;
	private JTextField textField;
	private JButton btnImagen;
	private JButton btnAgregar;
	private JButton btnAceptar;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JList listPoblacion;
	private DefaultListModel modelo;
	private JLabel lblPoblacion;

	public FrmLista() {
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
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(textField.getText());
				textField.setText("");
			}
		});
		
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(new ImageIcon("imagenes/Willyrex_1533156686_878765_1024x576.png"));
			}
		});
		
		listPoblacion.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lblPoblacion.setText(listPoblacion.getSelectedValue().toString() + " " + (listPoblacion.getSelectedIndex() + 1));
			}
		});
	}

	private void definirVentana() {
		textField = new JTextField();
		textField.setBounds(10, 180, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnImagen = new JButton("", new ImageIcon("imagenes/Willyrex_1533156686_878765_1024x576.png"));
		btnImagen.setBounds(10, 211, 79, 39);
		panel.add(btnImagen);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(106, 179, 89, 23);
		panel.add(btnAgregar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(106, 211, 89, 23);
		panel.add(btnAceptar);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 185, 158);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		modelo = new DefaultListModel();
		listPoblacion = new JList(modelo);
		listPoblacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listPoblacion);
		
		lblPoblacion = new JLabel("");
		lblPoblacion.setBounds(205, 11, 164, 14);
		panel.add(lblPoblacion);
		
		modelo.addElement("Jerez");modelo.addElement("Cadiz");modelo.addElement("Sevilla");
	}
}
