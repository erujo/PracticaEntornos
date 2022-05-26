package estudioFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import flujoDatos.leer;

public class trajetaClaves2 {
		String usuarios[];
		int claves[][];
		int registros;
	public trajetaClaves2() throws IOException {
		File fichero = new File("tarjetaclaves.txt");
		if (!fichero.exists()) {
			fichero.createNewFile();
		}
		cuentaRegistros(fichero);
		leerFichero(fichero);
		boolean parar = false;
		do {
			try {
				System.out.println("1.- Agregar un usuario\n2.- Acceder a la cuenta\n3.- Salir");
				int n = leer.datoInt();
				switch (n) {
				case 1:
					System.out.print("Dime un nuevo usuario: ");
					String usuario = leer.dato();
					if (!compruebaUsuario(usuario, fichero)) {
						boolean mal = true;
						do {
							System.out.println("Escribe una contraseña. Debe tener mayusculas, minusculas, un numero y un caracter especial");
							String contraseña = leer.dato();
							if (compruebaContraseña(contraseña, fichero)) {
								System.out.println("Usuario creado");
								mal = false;
								int ale[] = generaAleatorio(25, 100, 200);
								String aleatorios = pasaCadena(ale);
								//System.out.println(aleatorios);
								guardaDatos(fichero, usuario, contraseña, aleatorios);
							} else {
								System.out.println("La contraseña no cumple con los requisitos");
							}
						} while (mal);
					} else {
						System.out.println("Usuario repetido");
					}
					break;
				case 2:
					System.out.print("Introduce un usuario: ");
					String usu = leer.dato();
					boolean esIgual = false;
					int c = 0;
					for (int x = 0; x < usuarios.length; x++) {
						String usua[] = usuarios[x].split(",");
						if (usua[0].equals(usu)) {
							esIgual = true;
							c = x;
						}
					}
					if (esIgual) {
						System.out.println("Introduce la contraseña");
						boolean bien = false;
						for (int x = 3; x > 0 && !bien; x--) {
							System.out.println("Tienes " + x + " intentos");
							String contr = leer.dato();
							esIgual = false;
							for (int y = 0; y < usuarios.length; y++) {
								String usua[] = usuarios[y].split(",");
								if (usua[1].equals(contr)) {
									esIgual = true;
								}
							}
							if (esIgual) {
								System.out.println("Contraseña correcta");
								compruebaClave(c);
								bien = true;
							} else {
								System.out.println("Congtraseña incorrecta");
							}
						}
					} else {
						System.out.println("Usuario incorrecto");
					}
					break;
				case 3:
					System.out.println("Hasta luego!");
					parar = true;
					break;

				default:
					System.out.println("Comando no valido");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Comando no valido");
			}
		} while (!parar);
	}
	private void compruebaClave(int c) throws IOException {
		int tarjeta[][] = new int[5][5];
		int z = 0;
		for (int x = 0; x < tarjeta.length; x++) {
			for (int y = 0; y < tarjeta[x].length; y++) {
				tarjeta[x][y] = claves[c][z];
				z++;
			}
		}
		//System.out.println(Arrays.deepToString(tarjeta));
		String abc = "ABCDE";
		System.out.println("\t1\t2\t3\t4\t5");
		for (int x = 0; x < tarjeta.length; x++) {
			System.out.print(abc.charAt(x) + "\t");
			for (int y = 0; y < tarjeta[x].length; y++) {
				System.out.print(tarjeta[x][y] + "\t");
			}
			System.out.println();
		}
		int alx = (int) (Math.random() * 5);
		int aly = (int) (Math.random() * 5);
		System.out.print("Dime la clave " + abc.charAt(alx) + (aly + 1) + ": ");
		int clave = leer.datoInt();
		if (clave == tarjeta[alx][aly]) {
			System.out.println("Clave correcta");
		} else {
			System.out.println("Clave incorrecta");
		}
	}
	
	private void guardaDatos(File fichero, String usuario, String contraseña, String aleatorios) throws IOException {
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		usuario = usuario + "," + contraseña;
		for (int x = 0; x < usuarios.length; x++) {
			bw.write(usuarios[x]);
			bw.newLine();
			bw.write(pasaCadena(claves[x]));
			bw.newLine();
		}
		bw.write(usuario);
		bw.newLine();
		bw.write(aleatorios);
		bw.newLine();
		fw.flush();
		bw.close();
		fw.close();
		registros+=2;
		leerFichero(fichero);
	}
	private String pasaCadena(int[] ale) {
		String aleatorio = "";
		for (int x = 0; x < ale.length; x++) {
			aleatorio+=ale[x] + ", ";
		}
		return aleatorio;
	}
	private int[] generaAleatorio(int cant, int may, int men) {
		int ale[] = new int[cant];
		int num = 0;
		for (int x = 0; x < ale.length; x++) {
			do {
				num = (int) Math.floor(Math.random() * (may - men + 1) + men);
			} while (repe(ale, num));
			ale[x] = num;
		}
		return ale;
	}
	private boolean repe(int[] ale, int num) {
		boolean repe = false;
		for (int x = 0; x < ale.length; x++) {
			if (ale[x] == num) {
				repe = true;
			}
		}
		return repe;
	}
	private boolean compruebaContraseña(String contraseña, File fichero) {
		boolean may = false;
		boolean min = false;
		boolean num = false;
		boolean sig = false;
		String mayusculas = contraseña.toUpperCase();
		String minusculas = contraseña.toLowerCase();
		for (int x = 0; x < contraseña.length(); x++) {
			if (contraseña.charAt(x) == mayusculas.charAt(x) && Character.isLetter(contraseña.charAt(x))) {
				may = true;
			}
			if (contraseña.charAt(x) == minusculas.charAt(x) && Character.isLetter(contraseña.charAt(x))) {
				min = true;
			}
			if (Character.isDigit(contraseña.charAt(x))) {
				num = true;
			}
			if (!Character.isDigit(contraseña.charAt(x)) && !Character.isLetter(contraseña.charAt(x))) {
				sig = true;
			}
		}
		if (may && min && num && sig) {
			return true;
		} else {
			return false;
		}
	}
	private boolean compruebaUsuario(String usuario, File fichero) {
		boolean repetido = false;
		for (int x = 0; x < usuarios.length; x++) {
			String usu[] = usuarios[x].split(",");
			if (usu[0].equals(usuario)) {
				repetido = true;
			}
		}
		return repetido;
	}
	private void leerFichero(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		usuarios = new String[registros/2];
		claves = new int[registros/2][];
		String linea = "";
		for (int x = 0; x < usuarios.length; x++) {
			linea = br.readLine();
			usuarios[x] = linea;
			linea = br.readLine();
			String clave[] = linea.split(", ");
			int cla[] = new int[clave.length];
			for (int y = 0; y < clave.length; y++) {
				cla[y] = Integer.parseInt(clave[y]);
			}
			claves[x] = cla;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}
	private void cuentaRegistros(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		while ((linea = br.readLine()) != null) {
			registros++;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}

}
