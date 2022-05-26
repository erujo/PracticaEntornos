package listas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import modelo.persona;

public class Lista_1 {
	
	public Lista_1() {
		persona p1 = new persona("Pepe", "Garcia", 1);
		persona p2 = new persona("Maria", "Perez", 2);
		Collection coleccion = new ArrayList();
		coleccion.add(p1);
		coleccion.add(p2);
		for (Object object : coleccion) {
			System.out.println(object);
		}
		System.out.println();
		
		List<persona> lista = new ArrayList<persona>();
		lista.add(p1); lista.add(p2);
		for (persona persona : lista) {
			System.out.println(persona);
		}
		System.out.println();
		
		persona p4 = lista.get(0);
		System.out.println(p4);
		System.out.println();
		
		persona p = lista.remove(0);
		for (persona persona : lista) {
			System.out.println(persona);
		}
		lista.add(p1);
		System.out.println();
		
		Iterator<persona> iter = lista.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
			
		}
	}
}
