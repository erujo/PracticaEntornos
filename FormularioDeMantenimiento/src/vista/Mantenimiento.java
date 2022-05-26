package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controlador.BibliotecaController;
import exception.FechaException;
import exception.IsbnException;
import modelo.Libro;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.SystemColor;

public class Mantenimiento extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_1_1;
	private JLabel lblIdLibros;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JLabel lblFecha;
	private JTextField textIdLibros;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textIsbn;
	private JTextField textFecha;
	private JLabel lblFormato;
	private JCheckBox chckbxPrestado;
	private ImageIcon imagen;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JButton btnDeshacer;
	private JButton btnNavPri;
	private JButton btnNavIzq;
	private JButton btnNavDer;
	private JButton btnNavUlt;
	private JLabel lblErrorFecha;
	private List<JTextField> texto;
	private BibliotecaController biblioteca;
	private String dato[][];
	private int x;
	private JLabel lblEditorial;
	private JTextField textEditorial;
	private JLabel lblErrorIsbn;
	private boolean agregar;
	private boolean editar;

	public Mantenimiento() throws IOException, FechaException, IsbnException {
		setTitle("F O R M U L A R I O  D E  M A N T E N I M I E N T O");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 440);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		biblioteca = new BibliotecaController();
		dato = new String[biblioteca.getC()][];
		int c = 0;
		for (Libro libro : biblioteca.getBiblioteca()) {
			String datos[] = libro.toString().split(",");
			dato[c] = datos;
			c++;
		}
		texto = new ArrayList<JTextField>();
		x = 0;
		definirVentana();
		eventos();
		setVisible(true);
	}

	private void eventos() {
		textIsbn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter) || caracter == '-')) {
					e.consume();
				}
			}
		});
		
		textFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (!(Character.isDigit(caracter) || caracter == '-')) {
					e.consume();
				}
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar = true;
				btnAgregar.setEnabled(false);
				btnEditar.setEnabled(false);
				btnBorrar.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnDeshacer.setEnabled(true);
				btnNavPri.setEnabled(false);
				btnNavDer.setEnabled(false);
				btnNavIzq.setEnabled(false);
				btnNavUlt.setEnabled(false);
				for (JTextField texto : texto) {
					texto.setText("");
					texto.setEnabled(true);
					texto.setBackground(Color.WHITE);
				}
				textIdLibros.setText("");
				chckbxPrestado.setEnabled(true);
				chckbxPrestado.setSelected(false);
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar = true;
				btnAgregar.setEnabled(false);
				btnEditar.setEnabled(false);
				btnBorrar.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnDeshacer.setEnabled(true);
				btnNavPri.setEnabled(false);
				btnNavDer.setEnabled(false);
				btnNavIzq.setEnabled(false);
				btnNavUlt.setEnabled(false);
				for (JTextField texto : texto) {
					texto.setEnabled(true);
					texto.setBackground(Color.WHITE);
				}
				textIsbn.setEnabled(false);
				textIsbn.setBackground(new Color(240, 240, 240));
				chckbxPrestado.setEnabled(true);
				chckbxPrestado.setSelected(false);
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Libro libro = new Libro(dato[x][0], dato[x][1], dato[x][2], dato[x][3], dato[x][4], dato[x][5]);
					biblioteca.borrar(libro);
				} catch (FechaException | IsbnException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				x = 0;
				textIdLibros.setText(x+1 + "");
				dato = new String[biblioteca.getC()][];
				int c = 0;
				for (Libro libro : biblioteca.getBiblioteca()) {
					String datos2[] = libro.toString().split(",");
					dato[c] = datos2;
					c++;
				}
				int y = 0;
				for (JTextField texto : texto) {
					texto.setText(dato[x][y]);
					y++;
				}
				if (dato[x][y].equals("true")) {
					chckbxPrestado.setSelected(true);
				} else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (agregar) {
					agregar = false;
					String datos[] = new String[5];
					int x2 = 0;
					for (JTextField texto : texto) {
						datos[x2] = texto.getText();
						x2++;
					}
					String prestado = "";
					if (chckbxPrestado.isSelected()) {
						prestado = "true";
					} else {
						prestado = "false";
					}
					boolean bien = false;
					try {
						biblioteca.agregarLibro(datos, prestado);
						bien = true;
					} catch (FechaException | IOException e1) {
						lblErrorFecha.setText(e1.getMessage());
						lblErrorIsbn.setText("");
						agregar = true;
					} catch (IsbnException e1) {
						lblErrorIsbn.setText(e1.getMessage());
						agregar = true;
					}
					if (bien) {
						x = 0;
						textIdLibros.setText(x+1 + "");
						dato = new String[biblioteca.getC()][];
						int c = 0;
						for (Libro libro : biblioteca.getBiblioteca()) {
							String datos2[] = libro.toString().split(",");
							dato[c] = datos2;
							c++;
						}
						btnAgregar.setEnabled(true);
						btnEditar.setEnabled(true);
						btnBorrar.setEnabled(true);
						btnGuardar.setEnabled(false);
						btnDeshacer.setEnabled(false);
						btnNavPri.setEnabled(true);
						btnNavDer.setEnabled(true);
						btnNavIzq.setEnabled(true);
						btnNavUlt.setEnabled(true);
						for (JTextField texto : texto) {
							texto.setEnabled(false);
							texto.setBackground(new Color(240, 240, 240));
							texto.setText("");
						}
						chckbxPrestado.setEnabled(false);
						lblErrorFecha.setText("");
						lblErrorIsbn.setText("");
						int y = 0;
						for (JTextField texto : texto) {
							texto.setText(dato[x][y]);
							y++;
						}
						if (dato[x][y].equals("true")) {
							chckbxPrestado.setSelected(true);
						} else {
							chckbxPrestado.setSelected(false);
						}
					}
				}
				if (editar) {
					editar = false;
					String datos[] = new String[5];
					int x2 = 0;
					for (JTextField texto : texto) {
						datos[x2] = texto.getText();
						x2++;
					}
					String prestado = "";
					if (chckbxPrestado.isSelected()) {
						prestado = "true";
					} else {
						prestado = "false";
					}
					try {
						biblioteca.editarLibro(datos, prestado);
						x = 0;
						textIdLibros.setText(x+1 + "");
						dato = new String[biblioteca.getC()][];
						int c = 0;
						for (Libro libro : biblioteca.getBiblioteca()) {
							String datos2[] = libro.toString().split(",");
							dato[c] = datos2;
							c++;
						}
						btnAgregar.setEnabled(true);
						btnEditar.setEnabled(true);
						btnBorrar.setEnabled(true);
						btnGuardar.setEnabled(false);
						btnDeshacer.setEnabled(false);
						btnNavPri.setEnabled(true);
						btnNavDer.setEnabled(true);
						btnNavIzq.setEnabled(true);
						btnNavUlt.setEnabled(true);
						for (JTextField texto : texto) {
							texto.setEnabled(false);
							texto.setBackground(new Color(240, 240, 240));
							texto.setText("");
						}
						chckbxPrestado.setEnabled(false);
						lblErrorFecha.setText("");
						lblErrorIsbn.setText("");
						int y = 0;
						for (JTextField texto : texto) {
							texto.setText(dato[x][y]);
							y++;
						}
						if (dato[x][y].equals("true")) {
							chckbxPrestado.setSelected(true);
						} else {
							chckbxPrestado.setSelected(false);
						}
					} catch (FechaException e1) {
						lblErrorFecha.setText(e1.getMessage());
						lblErrorIsbn.setText("");
						editar = true;
					} catch (IsbnException e1) {
						lblErrorIsbn.setText(e1.getMessage());
						editar = true;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						editar = true;
					}
				}
			}
		});
		
		btnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = 0;
				textIdLibros.setText(x+1 + "");
				btnAgregar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnBorrar.setEnabled(true);
				btnGuardar.setEnabled(false);
				btnDeshacer.setEnabled(false);
				btnNavPri.setEnabled(true);
				btnNavDer.setEnabled(true);
				btnNavIzq.setEnabled(true);
				btnNavUlt.setEnabled(true);
				for (JTextField texto : texto) {
					texto.setEnabled(false);
					texto.setBackground(new Color(240, 240, 240));
					texto.setText("");
				}
				chckbxPrestado.setEnabled(false);
				lblErrorFecha.setText("");
				lblErrorIsbn.setText("");
				int y = 0;
				for (JTextField texto : texto) {
					texto.setText(dato[x][y]);
					y++;
				}
				if (dato[x][y].equals("true")) {
					chckbxPrestado.setSelected(true);
				} else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnNavDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x++;
				if (x == dato.length) {
					x = 0;
				}
				textIdLibros.setText(x+1 + "");
				int y = 0;
				for (JTextField texto : texto) {
					texto.setDisabledTextColor(new Color(51, 51, 51));
					texto.setText(dato[x][y]);
					y++;
				}
				if (dato[x][y].equals("true")) {
					chckbxPrestado.setSelected(true);
				} else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnNavIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x--;
				if (x == -1) {
					x = dato.length-1;
				}
				textIdLibros.setText(x+1 + "");
				int y = 0;
				for (JTextField texto : texto) {
					texto.setDisabledTextColor(new Color(51, 51, 51));
					texto.setText(dato[x][y]);
					y++;
				}
				if (dato[x][y].equals("true")) {
					chckbxPrestado.setSelected(true);
				} else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnNavPri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = 0;
				textIdLibros.setText(x+1 + "");
				int y = 0;
				for (JTextField texto : texto) {
					texto.setDisabledTextColor(new Color(51, 51, 51));
					texto.setText(dato[x][y]);
					y++;
				}
				if (dato[x][y].equals("true")) {
					chckbxPrestado.setSelected(true);
				} else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnNavUlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = dato.length-1;
				textIdLibros.setText(x+1 + "");
				int y = 0;
				for (JTextField texto : texto) {
					texto.setDisabledTextColor(new Color(51, 51, 51));
					texto.setText(dato[x][y]);
					y++;
				}
				if (dato[x][y].equals("true")) {
					chckbxPrestado.setSelected(true);
				} else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
	}

	private void definirVentana() {
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Mantenimiento Libros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(30, 11, 302, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		imagen = new ImageIcon("imagenes/botonAgregar.jpg");
		btnAgregar = new JButton("", imagen);
		btnAgregar.setBounds(10, 21, 48, 41);
		panel_1.add(btnAgregar);
		
		imagen = new ImageIcon("imagenes/botonEditar.jpg");
		btnEditar = new JButton("", imagen);
		btnEditar.setBounds(68, 21, 48, 41);
		panel_1.add(btnEditar);
		
		imagen = new ImageIcon("imagenes/borrar.jpg");
		btnBorrar = new JButton("", imagen);
		btnBorrar.setBounds(126, 21, 48, 41);
		panel_1.add(btnBorrar);
		
		imagen = new ImageIcon("imagenes/botonGuardar.jpg");
		btnGuardar = new JButton("", imagen);
		btnGuardar.setBounds(184, 21, 48, 41);
		panel_1.add(btnGuardar);
		btnGuardar.setEnabled(false);
		
		imagen = new ImageIcon("imagenes/botonDeshacer.jpg");
		btnDeshacer = new JButton("", imagen);
		btnDeshacer.setBounds(242, 21, 48, 41);
		panel_1.add(btnDeshacer);
		btnDeshacer.setEnabled(false);
		
		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Libros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1_1.setBounds(30, 97, 262, 204);
		panel.add(panel_1_1);
		
		lblIdLibros = new JLabel("IdLibros");
		lblIdLibros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdLibros.setBounds(10, 25, 46, 14);
		panel_1_1.add(lblIdLibros);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(10, 50, 46, 14);
		panel_1_1.add(lblTitulo);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutor.setBounds(10, 75, 46, 14);
		panel_1_1.add(lblAutor);
		
		lblIsbn = new JLabel("Isbn");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIsbn.setBounds(10, 125, 46, 14);
		panel_1_1.add(lblIsbn);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(10, 150, 46, 14);
		panel_1_1.add(lblFecha);
		
		textIdLibros = new JTextField();
		textIdLibros.setColumns(10);
		textIdLibros.setBounds(66, 22, 33, 20);
		panel_1_1.add(textIdLibros);
		textIdLibros.setBackground(new Color(240, 240, 240));
		textIdLibros.setEnabled(false);
		//texto.add(textIdLibros);
		
		textIsbn = new JTextField();
		textIsbn.setColumns(10);
		textIsbn.setBounds(66, 122, 181, 20);
		panel_1_1.add(textIsbn);
		textIsbn.setBackground(new Color(240, 240, 240));
		textIsbn.setEnabled(false);
		texto.add(textIsbn);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(66, 47, 181, 20);
		panel_1_1.add(textTitulo);
		textTitulo.setBackground(new Color(240, 240, 240));
		textTitulo.setEnabled(false);
		texto.add(textTitulo);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(66, 72, 181, 20);
		panel_1_1.add(textAutor);
		textAutor.setBackground(new Color(240, 240, 240));
		textAutor.setEnabled(false);
		texto.add(textAutor);
		
		textEditorial = new JTextField();
		textEditorial.setEnabled(false);
		textEditorial.setColumns(10);
		textEditorial.setBackground(SystemColor.menu);
		textEditorial.setBounds(66, 97, 181, 20);
		panel_1_1.add(textEditorial);
		texto.add(textEditorial);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(66, 147, 86, 20);
		panel_1_1.add(textFecha);
		textFecha.setBackground(new Color(240, 240, 240));
		textFecha.setEnabled(false);
		texto.add(textFecha);
		
		lblFormato = new JLabel("aaaa-MM-dd");
		lblFormato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFormato.setBounds(165, 150, 97, 14);
		panel_1_1.add(lblFormato);
		
		chckbxPrestado = new JCheckBox("Prestado");
		chckbxPrestado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxPrestado.setBounds(20, 171, 97, 23);
		panel_1_1.add(chckbxPrestado);
		chckbxPrestado.setEnabled(false);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEditorial.setBounds(10, 100, 46, 14);
		panel_1_1.add(lblEditorial);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Navegador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBounds(30, 312, 241, 74);
		panel.add(panel_2);
		
		btnNavPri = new JButton("", new ImageIcon("C:\\Users\\erujo\\Documents\\DAW\\Programacion\\ws2022\\FormularioDeMantenimiento\\imagenes\\navPri.jpg"));
		btnNavPri.setBounds(10, 22, 48, 41);
		panel_2.add(btnNavPri);
		
		btnNavIzq = new JButton("", new ImageIcon("C:\\Users\\erujo\\Documents\\DAW\\Programacion\\ws2022\\FormularioDeMantenimiento\\imagenes\\navIzq.jpg"));
		btnNavIzq.setBounds(68, 22, 48, 41);
		panel_2.add(btnNavIzq);
		
		btnNavDer = new JButton("", new ImageIcon("C:\\Users\\erujo\\Documents\\DAW\\Programacion\\ws2022\\FormularioDeMantenimiento\\imagenes\\navDer.jpg"));
		btnNavDer.setBounds(126, 22, 48, 41);
		panel_2.add(btnNavDer);
		
		btnNavUlt = new JButton("", new ImageIcon("C:\\Users\\erujo\\Documents\\DAW\\Programacion\\ws2022\\FormularioDeMantenimiento\\imagenes\\navUlt.jpg"));
		btnNavUlt.setBounds(184, 22, 48, 41);
		panel_2.add(btnNavUlt);
		
		lblErrorFecha = new JLabel("");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(302, 245, 141, 14);
		panel.add(lblErrorFecha);
		
		textIdLibros.setText(x+1 + "");
		textIdLibros.setDisabledTextColor(new Color(51, 51, 51));
		
		lblErrorIsbn = new JLabel("");
		lblErrorIsbn.setForeground(Color.RED);
		lblErrorIsbn.setBounds(302, 220, 141, 14);
		panel.add(lblErrorIsbn);
		int y = 0;
		for (JTextField texto : texto) {
			texto.setDisabledTextColor(new Color(51, 51, 51));
			texto.setText(dato[0][y]);
			y++;
		}
		if (dato[0][y].equals("true")) {
			chckbxPrestado.setSelected(true);
		} else {
			chckbxPrestado.setSelected(false);
		}
	}
}
