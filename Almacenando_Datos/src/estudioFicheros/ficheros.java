package estudioFicheros;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ficheros {

	public ficheros() throws IOException {
		System.out.println("Estudio ficheros");
		File fichero, directorio;
		/*directorio = new File("C:\\Users\\erujo\\Desktop\\ws2022\\Almacenando_Datos\\ficheros");
		boolean exito = directorio.mkdir();
		if (exito) {
			System.out.println("Se ha creado el directorio correctamente");
		} else {
			System.err.println("No se ha podide crear el directorio o ya existe");
		}
		if (directorio.isDirectory()) {
			System.out.println("Es un directorio");
		}
		String ruta = "C:\\Users\\erujo\\Desktop\\ws2022\\Almacenando_Datos\\ficheros";
		fichero = new File(ruta + "prueba.txt");
		try {
			exito = fichero.createNewFile();
			fichero = new File("alumnos.txt");
			fichero.createNewFile();
			System.out.println("El nombre del fichero es: " + fichero.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		fichero = new File("productos.bin");
		double precios[] = {1350, 400, 890, 6200, 8730};
		int unidades[] = {5, 7, 12, 80, 30};
		String productos[] = {"paquete de papel", "lapices", "boligrafos", "carteras", "mesas"};
		FileOutputStream fos = new FileOutputStream(fichero);
		DataOutputStream dos = new DataOutputStream(fos);
		for (int x = 0; x < productos.length; x++) {
			dos.writeUTF(productos[x]);
			dos.writeInt(unidades[x]);
			dos.writeDouble(precios[x]);
		}
		dos.close();
		fichero = new File("alumnos3.txt");
		if (!fichero.exists()) {
			fichero.createNewFile();
		}
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		String nombre = "";
		int edad = 0;
		String curso = "";
		while ((linea = br.readLine()) != null) {
			String datos[] = linea.split(",");
			nombre = datos[0];
			edad = Integer.parseInt(datos[2]);
			curso = datos[1];
			System.out.println(nombre + " " + edad + " " + curso);
		}
	}

}
