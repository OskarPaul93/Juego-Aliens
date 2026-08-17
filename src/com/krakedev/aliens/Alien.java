package com.krakedev.aliens;

public class Alien {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;
	private double precioTotal = 0;

	public Alien(int tamanio, String color) {
		
		if (tamanio < 5) {
			tamanio = 5;
		}

		if (tamanio > 30) {
			tamanio = 30;
		}
		
		this.tamanio = tamanio;
		this.color = color;

		this.precioCuerpo = this.tamanio * 0.20;
		this.precioExtremidad = this.tamanio * 0.10;
		this.precioOjo = this.tamanio * 0.05;
	}
	
	
	public boolean agregarBrazos(int cantidad) {

		if (numeroBrazos + numeroPies + cantidad <= 10) {
			numeroBrazos += cantidad;
			calcularPrecioTotal();
			return true;
		}

		return false;
	}
	
	public boolean agregarPiernas(int cantidad) {

		if (numeroBrazos + numeroPies + cantidad <= 10) {
			numeroPies += cantidad;
			calcularPrecioTotal();
			return true;
		}

		return false;
	}
	
	
	public boolean agregarOjos(int cantidad) {

		int maximoOjos;

		if (tamanio <= 10) {
			maximoOjos = 3;
		} else if (tamanio <= 20) {
			maximoOjos = 5;
		} else {
			maximoOjos = 7;
		}

		if (numeroOjos + cantidad <= maximoOjos) {
			numeroOjos += cantidad;
			calcularPrecioTotal();
			return true;
			
		}

		return false;
	}
	
	public void calcularPrecioTotal() {

		int totalExtremidades = numeroBrazos + numeroPies;

		precioTotal = precioCuerpo
				+ (totalExtremidades * precioExtremidad)
				+ (numeroOjos * precioOjo);
	}
		
		
		public int getTamanio() {
			return tamanio;
		}

		public String getColor() {
			return color;
		}

		public int getNumeroOjos() {
			return numeroOjos;
		}

		public int getNumeroBrazos() {
			return numeroBrazos;
		}

		public int getNumeroPies() {
			return numeroPies;
		}

		public double getPrecioExtremidad() {
			return precioExtremidad;
		}

		public double getPrecioOjo() {
			return precioOjo;
		}

		public double getPrecioCuerpo() {
			return precioCuerpo;
		}
		
		public double getPrecioTotal() {
			return precioTotal;
		}
		
		public void imprimir() {
			System.out.println("Tamaño: " + tamanio);
			System.out.println("Color: " + color);
			System.out.println("Número de ojos: " + numeroOjos);
			System.out.println("Número de brazos: " + numeroBrazos);
			System.out.println("Número de pies: " + numeroPies);
			System.out.println("Precio extremidad: " + precioExtremidad);
			System.out.println("Precio ojo: " + precioOjo);
			System.out.println("Precio cuerpo: " + precioCuerpo);
			System.out.println("Precio total: " + precioTotal);
		}
	

}
