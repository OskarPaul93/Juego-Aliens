package com.krakedev.aliens.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class PruebasJUnit {

	@Test
	public void probarAsignacionAtributos() {

		Alien alien = new Alien(20, "Verde");

		assertEquals(20, alien.getTamanio(), 0.0001);
		assertEquals("Verde", alien.getColor());
	}

	@Test
	public void probarTamanioMinimo() {

		Alien alien = new Alien(3, "Azul");

		assertEquals(5, alien.getTamanio(), 0.0001);
	}

	@Test
	public void probarTamanioMaximo() {

		Alien alien = new Alien(40, "Rojo");

		assertEquals(30, alien.getTamanio());
	}

	@Test
	public void probarCalculoPrecios() {

		Alien alien = new Alien(20, "Verde");

		assertEquals(4.0, alien.getPrecioCuerpo(), 0.0001);
		assertEquals(2.0, alien.getPrecioExtremidad(), 0.0001);
		assertEquals(1.0, alien.getPrecioOjo(), 0.0001);
	}

}
