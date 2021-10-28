package com.alarkil.enums;

public enum InventarioPociones {

	VIDA("Pocion de vida",100,1),REUTILIZABLE("Pocion reutilizable",200,2),CORRUPCION("Pocion de corrupcion",500,3);

	private String nombre;
	private int curacion,cantidad; /*CANTIDAD SE REFIERE QUE AL COMPRARLA LE VIENE X CANTIDAD*/

	private InventarioPociones(String nombre, int curacion,int cantidad){
		this.nombre=nombre;
		this.curacion=curacion;
		this.cantidad=cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCuracion() {
		return curacion;
	}

}
