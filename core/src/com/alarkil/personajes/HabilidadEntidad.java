package com.alarkil.personajes;

public class HabilidadEntidad {

	private String nombre;
	private int dañoMin;
	private int dañoMax;
	private int enfriamento;


	public HabilidadEntidad(String nombre, int dañoMin, int dañoMax, int enfriamento) {
		this.nombre=nombre;
		this.dañoMin=dañoMin;
		this.dañoMax=dañoMax;
		this.enfriamento=enfriamento;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDañoMin() {
		return dañoMin;
	}

	public int getDañoMax() {
		return dañoMax;
	}

	public int getEnfriamento() {
		return enfriamento;
	}

}
