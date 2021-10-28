package com.alarkil.armas;

import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Arma {

	private String nombre;
	private int da�o;
	private int municion;

	protected Texture textura;
	protected Sprite sprite;

	public void actualizar(float x, float y) {
		sprite.setPosition(x,y);
		System.out.println(sprite.getX() + " " + sprite.getY());
	}

	public Arma(String nombre, int da�o, int capacidadMunicion, String rutaTex) {
		this.nombre=nombre;
		this.da�o=da�o;
		this.municion=capacidadMunicion;
		
		this.textura = new Texture(rutaTex);
		this.sprite = new Sprite(textura);
	}

	public String getNombre() {
		return nombre;
	}

	public int getDa�o() {
		return da�o;
	}

	public int getCapacidadMunicion() {
		return municion;
	}
	
	public void render() {
		sprite.draw(Utiles.batch);
	}



}
