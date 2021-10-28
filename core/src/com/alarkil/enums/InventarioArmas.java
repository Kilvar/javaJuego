package com.alarkil.enums;

public enum InventarioArmas {
	
	ESPADA("Espada",100,0),PISTOLALASER("Pistola Laser",225,20),LATIGO("Latigo",90,0),RIFLE("Rifle",110,40);

	private String nombre;
	private int daño,capacidadMunicion; /*CANTIDAD SE REFIERE QUE AL COMPRARLA LE VIENE X CANTIDAD*/

	private InventarioArmas(String nombre, int daño,int capacidadMunicion){
		this.nombre=nombre;
		this.daño=daño;
		this.capacidadMunicion=capacidadMunicion;
	}
	
	public int getDaño() {
		return daño;
	}

	public int getCapacidadMunicion() {
		return capacidadMunicion;
	}

	public String getNombre() {
		return nombre;
	}


	

}
