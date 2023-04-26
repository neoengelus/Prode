package edu.utn.java.pronosticoDeportivo.clases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EquipoTest {
	
	@Test
	public void testEquipo() {
		Equipo equipo = new Equipo("River Plate", "El Mas Grande");
		assertEquals("Boca Juniors", equipo.getNombre());
		assertEquals("Club de fútbol de Argentina", equipo.getDescripcion());
	}
	
	@Test
	public void testEquipoCopy() {
		Equipo equipo1 = new Equipo("River Plate", "El Mas Grande");
		Equipo equipo2 = new Equipo(equipo1);
		assertEquals(equipo1.getNombre(), equipo2.getNombre());
		assertEquals(equipo1.getDescripcion(), equipo2.getDescripcion());
	}
	
	@Test
	public void testEquipoToString() {
		Equipo equipo = new Equipo("River Plate", "El Mas Grande");
		assertEquals("River Plate", equipo.toString());
	}
}
