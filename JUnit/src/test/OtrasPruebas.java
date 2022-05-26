package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import modelo.Calculadora;

public class OtrasPruebas {

	@Disabled("De esta forma podemos deshabilitar un test temporalmente")
	@Test
	void testSuma() {
		Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(10, 15);
		int esperado=25;
		assertEquals(esperado, suma);
	}
	
	@Test
	@EnabledOnOs(OS.LINUX) //Ejecutamos si el sistema operativo es Linux
	void testSuma2() {
		Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(10, 15);
		int esperado=25;
		assertEquals(esperado, suma);
	}
	
	@Test
	@DisabledOnOs({OS.LINUX,OS.MAC})
	void testSuma3() {
		Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(10, 15);
		int esperado=25;
		assertEquals(esperado, suma);
	}
	
	@Test
	@EnabledForJreRange(min=JRE.JAVA_8)
	void testSuma4() {
		Calculadora calculadora=new Calculadora();
		int suma=calculadora.suma(10, 15);
		int esperado=25;
		assertEquals(esperado, suma);
	}
}
