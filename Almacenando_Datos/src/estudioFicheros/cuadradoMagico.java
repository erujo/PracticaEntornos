package estudioFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class cuadradoMagico {

	public cuadradoMagico() throws IOException {
		File fichero = new File("matriz.txt");
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String c = br.readLine();
			int matriz[][] = new int[Integer.parseInt(c)][];
			for (int x = 0; x < matriz.length; x++) {
				linea = br.readLine();
				String lin[] = linea.split(" ");
				int num[] = new int[lin.length];
				for (int y = 0; y < lin.length; y++) {
					num[y] = Integer.parseInt(lin[y]);
				}
				matriz[x] = num;
				//System.out.println(arra);
			}
			System.out.println(Arrays.deepToString(matriz) + "\n");
		}
	}

}
