package estudioFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import flujoDatos.leer;

public class tarjetaClaves {
	
	String usuarios[] = null;
	int[][] claves = null;
	int registros = 0;
	
	public tarjetaClaves() throws IOException{
		File fichero = new File("tarjetaclaves.txt");
		if (!fichero.exists()) {
			fichero.createNewFile();
		}
		registros = cuentaRegistros(fichero);
		//System.out.println(registros);
		leerFichero(fichero);
		//System.out.println(Arrays.toString(usuarios));
		//System.out.println(Arrays.deepToString(claves));
		boolean salir = false;
		do {
			try {
				System.out.println("1.- Agregar un usuario\n2.- Acceder a la cuenta\n3.- Salir");
				int a = Integer.parseInt(leer.dato());
				switch (a) {
				case 1:
					System.out.print("Usario nuevo: ");
					String usu = leer.dato();
					System.out.print("Contraseña nueva: ");
					String contraseña = leer.dato();
					if (!compruebaUsu(usu)) {
						int ale[] = generaAleatorio(25, 100, 200);
						String claveUsu = pasaCadena(ale);
						//System.out.println(claveUsu);
						salvarDatos(fichero, claveUsu, usu, contraseña);
					} else {
						System.out.println("Usuario repetido");
					}
					break;
				case 2:
					System.out.print("Introduce un usuario: ");
					String usuario = leer.dato();
					boolean esIgual = false;
					int c = 0;
					for (int x = 0; x < usuarios.length; x++) {
						String usua[] = usuarios[x].split(",");
						if (usua[0].equals(usuario)) {
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
					salir = true;
					break;

				default:
					System.out.println("Comando no valido");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Comando no valido");
			}
		} while (!salir);
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

	private void salvarDatos(File fichero, String claveUsu, String usu, String contraseña) throws IOException {
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		usu = usu + "," + contraseña;
		for (int x = 0; x < usuarios.length; x++) {
			bw.write(usuarios[x]);
			bw.newLine();
			bw.write(pasaCadena(claves[x]));
			bw.newLine();
		}
		bw.write(usu);
		bw.newLine();
		bw.write(claveUsu);
		bw.newLine();
		fw.flush();
		bw.close();
		fw.close();
		registros+=2;
		leerFichero(fichero);
	}

	private String pasaCadena(int[] ale) {
		String claveUsu = "";
		for (int x = 0; x < ale.length; x++) {
			claveUsu+=ale[x] + ", ";
		}
		return claveUsu;
	}

	private int[] generaAleatorio(int cant, int menor, int mayor) {
		int ale[] = new int[cant];
		int num = 0;
		for (int x = 0; x < ale.length; x++) {
			do {
				num = (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
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

	private boolean compruebaUsu(String usu) {
		boolean comp = false;
		for (int x = 0; x < usuarios.length; x++) {
			String usuario[] = usuarios[x].split(",");
			if (usu.equals(usuario[0])) {
					comp = true;
			}
		}
		return comp;
	}

	private void leerFichero(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		usuarios = new String[registros/2];
		claves = new int[registros/2][];
		String linea = "";
		for (int x = 0; x < claves.length; x++) {
			linea = br.readLine();
			usuarios[x] = linea;
			linea = br.readLine();
			String[] c = linea.split(", ");
			int cla[] = new int[c.length];
			for (int y = 0; y < c.length; y++) {
				cla[y] = Integer.parseInt(c[y]);
			}
			claves[x] = cla;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}

	private int cuentaRegistros(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		int reg = 0;
		String linea = "";
		while ((linea = br.readLine()) != null) {
			reg++;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
		return reg;
	}

}
