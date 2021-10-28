package com.alarkil.recursos;

public enum Fuentes {

	FUENTE_MENU("fuentes/FuenteMenu.ttf");

	private String rutaFuente;

	private Fuentes(String ruta) {
		this.rutaFuente = ruta;
	}

	public String getRutaFuente() {
		return rutaFuente;
	}

}
