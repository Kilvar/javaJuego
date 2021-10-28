package com.alarkil.enums;

public enum InventarioArmas {
	
	ESPADA("Espada",100,0),PISTOLALASER("Pistola Laser",225,20),LATIGO("Latigo",90,0),RIFLE("Rifle",110,40);

	private String nombre;
	private int da�o,capacidadMunicion; /*CANTIDAD SE REFIERE QUE AL COMPRARLA LE VIENE X CANTIDAD*/

	private InventarioArmas(String nombre, int da�o,int capacidadMunicion){
		this.nombre=nombre;
		this.da�o=da�o;
		this.capacidadMunicion=capacidadMunicion;
	}
	
	public int getDa�o() {
		return da�o;
	}

	public int getCapacidadMunicion() {
		return capacidadMunicion;
	}

	public String getNombre() {
		return nombre;
	}


	

}
