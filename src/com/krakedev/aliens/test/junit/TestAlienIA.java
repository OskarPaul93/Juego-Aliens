package com.krakedev.aliens.test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class TestAlienIA {

	@Test
	public void probarDatosIniciales() {

		// Valida que el constructor asigne correctamente
		// el tamaño y el color recibidos.
		Alien alien = new Alien(20, "Verde");

		assertEquals(20, alien.getTamanio());
		assertEquals("Verde", alien.getColor());
	}

	@Test
	public void probarValoresInicialesExtremidades() {

		// Valida que los atributos de ojos, brazos y pies
		// comiencen con el valor 0.
		Alien alien = new Alien(20, "Verde");

		assertEquals(0, alien.getNumeroOjos());
		assertEquals(0, alien.getNumeroBrazos());
		assertEquals(0, alien.getNumeroPies());
	}

	@Test
	public void probarTamanioMenorAlMinimo() {

		// Valida que un tamaño menor al mínimo permitido
		// se ajuste automáticamente a 5 cm.
		Alien alien = new Alien(3, "Azul");

		assertEquals(5, alien.getTamanio());

		// Valida que los precios se calculen utilizando
		// el tamaño ajustado de 5 cm.
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.25, alien.getPrecioOjo(), 0.001);
	}

	@Test
	public void probarTamanioMayorAlMaximo() {

		// Valida que un tamaño mayor al máximo permitido
		// se ajuste automáticamente a 30 cm.
		Alien alien = new Alien(40, "Rojo");

		assertEquals(30, alien.getTamanio());

		// Valida que los precios se calculen utilizando
		// el tamaño ajustado de 30 cm.
		assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
		assertEquals(1.5, alien.getPrecioOjo(), 0.001);
	}

	@Test
	public void probarTamanioMinimoExacto() {

		// Valida que el tamaño exactamente igual al mínimo
		// de 5 cm sea aceptado sin modificación.
		Alien alien = new Alien(5, "Amarillo");

		assertEquals(5, alien.getTamanio());

		assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.25, alien.getPrecioOjo(), 0.001);
	}

	@Test
	public void probarTamanioMaximoExacto() {

		// Valida que el tamaño exactamente igual al máximo
		// de 30 cm sea aceptado sin modificación.
		Alien alien = new Alien(30, "Morado");

		assertEquals(30, alien.getTamanio());

		assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
		assertEquals(1.5, alien.getPrecioOjo(), 0.001);
	}

	@Test
	public void probarCalculoPreciosTamanioIntermedio() {

		// Valida el cálculo de los tres precios
		// utilizando un tamaño intermedio de 10 cm.
		Alien alien = new Alien(10, "Naranja");

		assertEquals(2.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(1.0, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.5, alien.getPrecioOjo(), 0.001);
	}

	@Test
	public void probarCalculoPreciosConTamanioNegativo() {

		// Valida que un tamaño negativo se ajuste
		// automáticamente al mínimo permitido de 5 cm.
		Alien alien = new Alien(-10, "Gris");

		assertEquals(5, alien.getTamanio());

		// Valida que los precios se calculen utilizando
		// el tamaño ajustado de 5 cm.
		assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
		assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
		assertEquals(0.25, alien.getPrecioOjo(), 0.001);
	}

	@Test
	public void probarColorDiferente() {

		// Valida que diferentes valores de color
		// sean asignados correctamente por el constructor.
		Alien alien = new Alien(15, "Rojo");

		assertEquals("Rojo", alien.getColor());
	}
}