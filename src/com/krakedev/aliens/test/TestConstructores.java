package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien a1 = new Alien(8, "Verde");
		
		a1.agregarBrazos(2);
		a1.agregarPiernas(2);
		a1.agregarOjos(4);

		System.out.println("******Caracteristica Alien 1*******");
		a1.imprimir();

		System.out.println("******Caracteristica Alien 2*******");
		Alien a2 = new Alien(15, "Azul");
		a2.agregarBrazos(8);
		a2.agregarPiernas(2);
		a2.agregarOjos(40);
		
		a2.imprimir();

	}

}
