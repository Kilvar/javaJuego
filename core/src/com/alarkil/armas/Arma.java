package com.alarkil.armas;

import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Arma {

	private String nombre;
	private int daño;
	private int municion;

	protected Texture textura;
	protected Sprite sprite;

	public void actualizar(float x, float y) {
		sprite.setPosition(x,y);
		System.out.println(sprite.getX() + " " + sprite.getY());
	}

	public Arma(String nombre, int daño, int capacidadMunicion, String rutaTex) {
		this.nombre=nombre;
		this.daño=daño;
		this.municion=capacidadMunicion;
		
		this.textura = new Texture(rutaTex);
		this.sprite = new Sprite(textura);
	}

	public String getNombre() {
		return nombre;
	}

	public int getDaño() {
		return daño;
	}

	public int getCapacidadMunicion() {
		return municion;
	}
	
	public void render() {
		sprite.draw(Utiles.batch);
	}



}
