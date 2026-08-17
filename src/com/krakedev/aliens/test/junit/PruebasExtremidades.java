package com.krakedev.aliens.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class PruebasExtremidades {

	@Test
	public void probarAgregarBrazos() {

		// Valida que se puedan agregar brazos cuando
		// no se supera el límite de 10 extremidades.
		Alien alien = new Alien(20, "Verde");

		boolean resultado = alien.agregarBrazos(3);

		assertTrue(resultado);
		assertEquals(3, alien.getNumeroBrazos());
	}

	@Test
	public void probarAgregarPiernas() {

		// Valida que se puedan agregar piernas cuando
		// no se supera el límite de 10 extremidades.
		Alien alien = new Alien(20, "Azul");

		boolean resultado = alien.agregarPiernas(4);

		assertTrue(resultado);
		assertEquals(4, alien.getNumeroPies());
	}

	@Test
	public void probarLimiteExactoExtremidades() {

		// Valida que se puedan agregar exactamente 10
		// extremidades sin superar el límite.
		Alien alien = new Alien(20, "Rojo");

		boolean resultado = alien.agregarBrazos(10);

		assertTrue(resultado);
		assertEquals(10, alien.getNumeroBrazos());
	}

	@Test
	public void probarExcesoDeBrazos() {

		// Primero se agregan 8 brazos.
		Alien alien = new Alien(20, "Verde");
		alien.agregarBrazos(8);

		// Intenta agregar 3 brazos adicionales.
		// El total sería 11, por lo que debe rechazarse.
		boolean resultado = alien.agregarBrazos(3);

		assertFalse(resultado);

		// Valida que no se haya agregado ninguna de las
		// extremidades del segundo intento.
		assertEquals(8, alien.getNumeroBrazos());
	}

	@Test
	public void probarCasoCombinadoBrazosYPiernas() {

		// Valida un caso combinado: primero se agregan brazos
		// y después piernas.
		Alien alien = new Alien(20, "Amarillo");

		boolean resultadoBrazos = alien.agregarBrazos(4);
		boolean resultadoPiernas = alien.agregarPiernas(5);

		assertTrue(resultadoBrazos);
		assertTrue(resultadoPiernas);

		assertEquals(4, alien.getNumeroBrazos());
		assertEquals(5, alien.getNumeroPies());

		// El total acumulado es 9 extremidades.
		assertEquals(9, alien.getNumeroBrazos() + alien.getNumeroPies());
	}

	@Test
	public void probarCasoCombinadoPiernasYBrazos() {

		// Valida el caso contrario: primero se agregan piernas
		// y después brazos.
		Alien alien = new Alien(20, "Morado");

		boolean resultadoPiernas = alien.agregarPiernas(6);
		boolean resultadoBrazos = alien.agregarBrazos(4);

		assertTrue(resultadoPiernas);
		assertTrue(resultadoBrazos);

		assertEquals(6, alien.getNumeroPies());
		assertEquals(4, alien.getNumeroBrazos());

		// El total llega exactamente al límite permitido.
		assertEquals(10, alien.getNumeroBrazos() + alien.getNumeroPies());
	}

	@Test
	public void probarExcesoEnCasoCombinado() {

		// Primero se agregan 6 brazos y 3 piernas.
		Alien alien = new Alien(20, "Naranja");

		alien.agregarBrazos(6);
		alien.agregarPiernas(3);

		// Actualmente existen 9 extremidades.
		// Se intenta agregar 2 brazos, lo que daría 11.
		boolean resultado = alien.agregarBrazos(2);

		assertFalse(resultado);

		// Valida que el intento fallido no haya modificado
		// la cantidad de brazos.
		assertEquals(6, alien.getNumeroBrazos());
		assertEquals(3, alien.getNumeroPies());

		// El total continúa siendo 9.
		assertEquals(9, alien.getNumeroBrazos() + alien.getNumeroPies());
	}
}
