package com.alarkil.recursos;

public enum Texturas {

	FONDO_MENU("imagenes/fondo.jpg"),
	SPRITE_ENT("imagenes/jugadorA.png"),
	SPRITE_SOB("imagenes/aventurero.png"),
	SPRITE_SOB_SELEC("imagenes/aventurero.png"),
	SPRITE_ENT_SELEC("imagenes/mushroom.png"),
	SPRITE_ARMA_RIF("imagenes/Rifle.png"),
	SPRITE_ARMA_ESP("imagenes/Espada.png"),
	SPRITE_ARMA_LAT("imagenes/Latigo.png"),
	SPRITE_ARMA_LAS("imagenes/PistolaLaser.png");

	private String rutaTex;

	private Texturas(String rutaTex) {
		this.rutaTex = rutaTex;
	}

	public String getRutaTex() {
		return rutaTex;
	}

}
