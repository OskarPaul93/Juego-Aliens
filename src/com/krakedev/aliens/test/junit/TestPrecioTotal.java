package com.krakedev.aliens.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class TestPrecioTotal {

	@Test
	public void probarPrecioTotalInicial() {

		// Valida que el precio total se inicialice en 0
		// al crear un nuevo Alien.
		Alien alien = new Alien(10, "Verde");

		assertEquals(0, alien.getPrecioTotal(), 0.001);
	}

	@Test
	public void probarPrecioTotalConBrazos() {

		// Valida que el precio total se actualice
		// automáticamente al agregar brazos.
		Alien alien = new Alien(10, "Verde");

		boolean resultado = alien.agregarBrazos(2);

		assertTrue(resultado);

		// Precio cuerpo = 2.0
		// 2 brazos x 1.0 = 2.0
		// Total = 4.0
		assertEquals(4, alien.getPrecioTotal(), 0.001);
	}

	@Test
	public void probarPrecioTotalConPiernas() {

		// Valida que el precio total se actualice
		// automáticamente al agregar piernas.
		Alien alien = new Alien(10, "Azul");

		boolean resultado = alien.agregarPiernas(3);

		assertTrue(resultado);

		// Precio cuerpo = 2.0
		// 3 piernas x 1.0 = 3.0
		// Total = 5.0
		assertEquals(5, alien.getPrecioTotal(), 0.001);
	}

	@Test
	public void probarPrecioTotalConOjos() {

		// Valida que el precio total se actualice
		// automáticamente al agregar ojos.
		Alien alien = new Alien(10, "Rojo");

		boolean resultado = alien.agregarOjos(3);

		assertTrue(resultado);

		// Precio cuerpo = 2.0
		// 3 ojos x 0.5 = 1.5
		// Total = 3.5
		assertEquals(3.5, alien.getPrecioTotal(), 0.001);
	}

	@Test
	public void probarPrecioTotalConTodosLosElementos() {

		// Valida el cálculo completo utilizando
		// brazos, piernas y ojos.
		Alien alien = new Alien(10, "Verde");

		alien.agregarBrazos(2);
		alien.agregarPiernas(2);
		alien.agregarOjos(3);

		// Precio cuerpo = 2.0
		// 4 extremidades x 1.0 = 4.0
		// 3 ojos x 0.5 = 1.5
		// Total = 7.5
		assertEquals(7.5, alien.getPrecioTotal(), 0.001);
	}

	@Test
	public void probarPrecioActualizadoAlAgregarElementos() {

		// Valida que el precio total se vaya actualizando
		// después de cada operación.
		Alien alien = new Alien(10, "Morado");

		// Inicialmente solamente está el cuerpo.
		assertEquals(0, alien.getPrecioTotal(), 0.001);

		alien.agregarBrazos(2);

		// Ahora el precio aumenta por los brazos.
		assertEquals(4, alien.getPrecioTotal(), 0.001);

		alien.agregarPiernas(1);

		// Ahora hay 3 extremidades.
		assertEquals(5, alien.getPrecioTotal(), 0.001);

		alien.agregarOjos(2);

		// Ahora hay 3 extremidades y 2 ojos.
		assertEquals(6, alien.getPrecioTotal(), 0.001);
	}

	@Test
	public void probarRestriccionExtremidades() {

		// Valida que no se puedan superar las
		// 10 extremidades permitidas.
		Alien alien = new Alien(20, "Naranja");

		boolean resultado1 = alien.agregarBrazos(6);
		boolean resultado2 = alien.agregarPiernas(4);
		boolean resultado3 = alien.agregarPiernas(1);

		assertTrue(resultado1);
		assertTrue(resultado2);
		assertFalse(resultado3);

		assertEquals(6, alien.getNumeroBrazos());
		assertEquals(4, alien.getNumeroPies());
	}

	@Test
	public void probarRestriccionOjos() {

		// Valida que un Alien de 8 cm tenga como máximo
		// 3 ojos.
		Alien alien = new Alien(8, "Verde");

		boolean resultado1 = alien.agregarOjos(3);
		boolean resultado2 = alien.agregarOjos(1);

		assertTrue(resultado1);
		assertFalse(resultado2);

		// Valida que el intento fallido no modifique
		// la cantidad de ojos.
		assertEquals(3, alien.getNumeroOjos());
	}

	@Test
	public void probarRestriccionesYPrecioTotal() {

		// Valida que cuando una operación es rechazada
		// tampoco se modifique incorrectamente el precio total.
		Alien alien = new Alien(8, "Azul");

		alien.agregarBrazos(5);
		alien.agregarPiernas(5);
		alien.agregarOjos(3);

		double precioAntes = alien.getPrecioTotal();

		// Intenta agregar una extremidad adicional.
		// Ya existen 10, por lo tanto debe fallar.
		boolean resultado = alien.agregarBrazos(1);

		assertFalse(resultado);

		// El precio debe permanecer igual.
		assertEquals(precioAntes, alien.getPrecioTotal(), 0.001);
	}
}