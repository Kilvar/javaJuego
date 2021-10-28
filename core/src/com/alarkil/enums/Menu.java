package com.alarkil.enums;

import com.alarkil.elementos.Texto;
import com.alarkil.recursos.Fuentes;
import com.badlogic.gdx.graphics.Color;


public enum Menu {

	UNJUGADOR("Un jugador"),MULTIJUGADOR("Multijugador"),SALIR("Salir");

	private String contenido;
	private Texto textoObj;


	private Menu(String nombre) {
		this.contenido=nombre;
		textoObj = new Texto(contenido, Fuentes.FUENTE_MENU.getRutaFuente(), 25, Color.WHITE);
	}
	
	public String getContenido() {
		return contenido;
	}

    public Texto getTexto() {
		return textoObj;
	}

}
