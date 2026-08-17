package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien a1 = new Alien(20, "Verde");

		System.out.println("******Caracteristica Alien 1*******");
		a1.imprimir();

		System.out.println("******Caracteristica Alien 2*******");
		Alien a2 = new Alien(2, "Azul");
		a2.imprimir();

	}

}
