package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Calculadora;

class CalculadoraTest {

	@Test
	void testSumaAssert() {
		Calculadora calculadora =new Calculadora();
		int actual=calculadora.suma(15, 10);
		int esperado = 25;
		assertEquals(esperado,actual);
		actual=calculadora.suma(-15,10);
		esperado=-5;
		assertEquals(esperado,actual,"negativo-positivo");
		actual=calculadora.suma(-15,-10);
		esperado=-25;
		assertEquals(esperado,actual);
		actual=calculadora.suma(15,-10);
		esperado=5;
		assertEquals(esperado,actual, "Hemos mandado dos negativos");
	}
	
	/*@Test
	void testEstudioAssert2() {
		Calculadora calculadora=new Calculadora();
		int suma= calculadora.suma(10, 15);
		//Valoramos el resultado de una condicion
		assertTrue(suma>10);
		calculadora=null;
		//Valoramos si un objeto es null o notNull
		assertNotNull(calculadora, "La calculadora no esta instanciada");
		
		
	}
	
	*/
	
	/*
	@Test
	
	public void testSumaDouble() {
		
		Calculadora calc=new Calculadora();
		System.out.println("SumaDouble");
		double resultado = calc.suma(3.501,1.0);
		double esperado = 4.5;
		
		//assertEquals(esperado,resultado);
		assertEquals(esperado,resultado,0.001);
		//assertEquals("Error de precisión",esperado,resultado,0.0001);
	}

*/
	/*
	@Test
	
	void assertAllSumaTest() {
		
		Calculadora calc=new Calculadora();
		int suma=calc.suma(3, 2);
		int esperado=6;
		assertAll (
					() ->assertEquals(esperado, suma,"Error en la suma"),
					
					() ->assertTrue(suma>10,"Fallo de condicion")
				
					
				
				);
		//Excepciones controladas
			//En determinados casos que se lance una excepcion es lo correcto, esto hay que comprobarlo
		
	}
	
	*/
	
	@Test
	
	void testDivisionPorCero() {
		Calculadora calc=new Calculadora();
		assertThrows(ArithmeticException.class, ()->calc.div(10, 2),"Se esperaba que se lanzara AritmeticException ");
			
	}
	
}
