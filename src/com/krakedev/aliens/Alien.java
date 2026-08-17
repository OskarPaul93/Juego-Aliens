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
	
	
	public Alien(int tamanio, String color) {
		this.tamanio = tamanio;
		this.color = color;
		
		if (tamanio < 5) {
			tamanio = 5;
		}

		if (tamanio > 30) {
			tamanio = 30;
		}

		this.precioCuerpo = this.tamanio * 0.20;
		this.precioExtremidad = this.tamanio * 0.10;
		this.precioOjo = this.tamanio * 0.05;
		
	}
	
	
	

}
