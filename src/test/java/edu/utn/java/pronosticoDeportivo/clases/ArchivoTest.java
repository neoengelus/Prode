package edu.utn.java.pronosticoDeportivo.clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArchivoTest {
	
	private Archivo archivo;
	private Path rutaArchivo;
	
	@Before
	public void setUp() {
		rutaArchivo = Paths.get("src/test/resources/testArchivo.txt");
		archivo = new Archivo(rutaArchivo);
	}
	
	@Test
	public void testLeerArchivo() {
		List<String> expected = Arrays.asList("línea 1", "línea 2", "línea 3");
		List<String> actual = archivo.leerArchivo();
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLeerJson() {
		byte[] expected = { 123, 34, 107, 101, 121, 34, 58, 34, 118, 97, 108, 117, 101, 34, 125 };
		byte[] actual = archivo.leerJson();
		assertNotNull(actual);
		assertEquals(expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
}
