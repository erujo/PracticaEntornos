package listas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

import modelo.persona;

public class Lista_2 {

	public Lista_2() {
		Set<persona> listaHasSet = new HashSet<persona>();
		persona p1 = new persona("Pepe", "Garcia", "123");
		persona p2 = new persona("Maria", "Perez", "1234");
		persona p3 = new persona("Luis", "Alvarez", "1235");
		persona p4 = new persona("Ana", "Rodrigez", "1236");
		System.out.println(listaHasSet.add(p1));
		System.out.println(listaHasSet.add(p2));
		System.out.println(listaHasSet.add(p1));
		for (persona persona : listaHasSet) {
			System.out.println(persona);
		}
		System.out.println();
		SortedSet<persona> listaSorted = new TreeSet<persona>();
		listaSorted.add(p1);listaSorted.add(p2);listaSorted.add(p3);listaSorted.add(p4);
		for (persona persona : listaSorted) {
			System.out.println(persona);
		}
		System.out.println();
		Map<Integer, persona> mp = new HashMap<Integer, persona>();
		mp.put(4, p4);mp.put(2, p2);mp.put(1, p1);mp.put(3, p3);
		System.out.println(mp.toString().replaceAll(",", "\n"));
		System.err.println();
		
		Stack<String> binario = new Stack<String>();
		binario.push("1");binario.push("1");binario.push("0");binario.push("1");
		Iterator<String> iter = binario.iterator();
		String bin = "";
		while (iter.hasNext()) {
			bin+=binario.pop();
		}
		System.out.println(bin);
		//String cadenaEquilibrada = "(Cadena equilibrada(((()))))";
		String cadenaEquilibrada = "(Cadena equilibrada((()))))";
		if (verificaParentesis(cadenaEquilibrada)) {
			
		} else {

		}
	}

	private boolean verificaParentesis(String cadenaEquilibrada) {
		Stack<String> cadena = new Stack<String>();
		for (int x = 0; x < cadenaEquilibrada.length(); x++) {
			String c = Character.toString(cadenaEquilibrada.charAt(x));
			cadena.push(c);
		}
		System.out.println();
		return false;
	}

}
