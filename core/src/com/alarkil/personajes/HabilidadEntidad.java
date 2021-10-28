package com.alarkil.personajes;

public class HabilidadEntidad {

	private String nombre;
	private int da�oMin;
	private int da�oMax;
	private int enfriamento;


	public HabilidadEntidad(String nombre, int da�oMin, int da�oMax, int enfriamento) {
		this.nombre=nombre;
		this.da�oMin=da�oMin;
		this.da�oMax=da�oMax;
		this.enfriamento=enfriamento;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDa�oMin() {
		return da�oMin;
	}

	public int getDa�oMax() {
		return da�oMax;
	}

	public int getEnfriamento() {
		return enfriamento;
	}

}
