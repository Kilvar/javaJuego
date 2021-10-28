package com.alarkil.enums;

import com.alarkil.elementos.Texto;
import com.alarkil.recursos.Fuentes;
import com.badlogic.gdx.graphics.Color;

public enum MenuPersonajes {
	
	SOBREVIVIENTE("Sobreviviente"),ENTIDAD("Entidad");
	
	private String contenido;
	private Texto textoObj;
	
	private MenuPersonajes(String nombre) {
		this.contenido=nombre;
		textoObj = new Texto(contenido, Fuentes.FUENTE_MENU.getRutaFuente(), 20, Color.WHITE);
	}
	
	public String getContenido() {
		return contenido;
	}

    public Texto getTexto() {
		return textoObj;
	}
	

}
