package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import modelo.Calculadora;
import modelo.Persona;
//https://programmerclick.com/article/6890984812/
public class PruebaParametricaTest {

	@Test
	@DisplayName("Probamos el metodo suma de la calculadora")
	void testSuma() {
		Calculadora Calculadora=new Calculadora();
		int [][] datos= {{3,2,5},{10,5,15},{10,-20,-10}};
		System.out.println("testDiv()");
		int x=0;
		for(int[]prueba:datos) {
			int suma=Calculadora.suma(prueba[0], prueba[1]);
			int esperado=prueba[2];
			assertEquals(esperado, suma,"Prueba "+x);
			x++;
		}
		
	}
	
	@ParameterizedTest
	@DisplayName("Probamos el metodo suma parametrizado")
	@ValueSource(strings = {"3,2,5","4,5,9","-2,-3,-5"})
	void testSuma2(String datos) {
		Calculadora calculadora=new Calculadora();
		System.out.println("testDiv()");
		String []prueba=datos.split(",");
		int n=Integer.parseInt(prueba[0]);
		int m=Integer.parseInt(prueba[1]);
		int esperado=Integer.parseInt(prueba[2]);
			int suma=calculadora.suma(n,m);
			assertEquals(esperado, suma);
		
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"31123456V","31456789B","31147258Z"})
	void testDni(String dni) {
		assertTrue(Persona.compruebaDni(dni));
	}
	
	@ParameterizedTest
	@DisplayName("Probamos el metodo de suma parametrizado csv")
	@CsvSource({ 
		"3, 2, 5",
		"4, 5, 9",
		"-2, -3, -5"
		
	})
		void testSuma3(int n, int m, int esperado) {
		Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(n,m);
		assertEquals(esperado, suma);
		
		
	
	
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, Empleado1, 30000",
		"2, Empleado2, 40000",
		"3, Empleado3, 50000",
		"4, Empleado4, 50000",
		
	})
	
		void test1(long id, String name, Integer salary) {
		System.out.println("id: " + id + ", name: " + name + ", salary: " + salary);
	}
	
	@ParameterizedTest
	@MethodSource("namesProvider")
	void test4(String name) {
		System.out.println("Name: " + name);
	}
	
	private static Stream<String> namesProvider() {
		return Stream.of("Name1","Name2","Name3");
	}
	
	@ParameterizedTest
	@MethodSource("namesProvide")
	void testStream(int [] dato) {
		Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(dato[0],dato[1]);
		assertEquals(dato[2], suma);
	}

	private static Stream<int []> namesProvide() {
		int [][] parametros = {{1,2,3},{2,2,4}};
		return Arrays.stream(parametros);
	}
}
