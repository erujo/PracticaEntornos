package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import modelo.calculadora;

class CalculadoraTest2 {
	static calculadora calculadora=null;
	//Mejorar la legibilidad de nuestros test con @DisplayName
	@Test
	@DisplayName("Probamos el metodo suma de la calculadora")
	void testSuma() {
		
		System.out.println("testSuma()");
		//Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(10,15);
		int esperado=25;
		assertEquals(esperado, suma);
		
		
	}
	
	@Test
	@DisplayName("Probamos el metodo resta de la calculadora")
	void testResta() {
		
		System.out.println("testResta()");
		//Calculadora calculadora=new Calculadora();
		int resta=calculadora.resta(10,15);
		int esperado=-5;
		assertEquals(esperado, resta);
		
		
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		calculadora=new calculadora();
		System.out.println("@beforeAll() se ejecuta antes de todos los test");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		calculadora=null;
		System.out.println("@AfterAll se ejecuta despues de todos los test");
	}

	//Antes de todos los test y despues de todos los test
	@BeforeEach
	public void setUp() {
		System.out.println("@BeforeEach se ejecuta antes de cada test");
	}

	@AfterEach
	void tearDown() {
		
		System.out.println("@AfterEach se ejecuta despues de cada test");
	}
	


}
