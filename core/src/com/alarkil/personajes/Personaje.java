package com.alarkil.personajes;

import com.alarkil.armas.Arma;
import com.alarkil.armas.Rifle;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Personaje {

	private int vida;

	private Body cuerpo;
	private float velX;
	private float rapidez = 15;
	private float salto = 30;
	private boolean saltar;
	
	protected InputAdapter entrada;
	protected Sprite sprite;
	
	

	private Texture textura;
	
	protected Personaje(int vida, float spawnX, float spawnY, String rutaTex, World w) {

		this.vida=vida;
		
		textura = new Texture(rutaTex);
		sprite = new Sprite(textura);
		sprite.setPosition(spawnX, spawnY);
		
		entrada = new InputAdapter() {
			@Override
			public boolean keyDown(int keycode) {

				if(keycode == Input.Keys.W) {
					saltar = true;
				}

				if(keycode == Input.Keys.A) {
					velX--;
				}

				if(keycode == Input.Keys.D) {
					velX++;
				}
				return true;
			}
			
			@Override
			public boolean keyUp(int keycode) {
				if(keycode == Input.Keys.W) {

				}

				if(keycode == Input.Keys.A) {
					velX++;
				}
				
				if(keycode == Input.Keys.D) {
					velX--;
				}
				return true;
			}
		};
		
		cuerpo = Utiles.crearCuerpoBox2D(w, BodyType.DynamicBody, Utiles.crearRectangulo(sprite.getWidth() / Utiles.PPM, sprite.getHeight() / Utiles.PPM), false, 1f, spawnX / Utiles.PPM, spawnY / Utiles.PPM);
		cuerpo.setFixedRotation(true);
		velX = 0;
		
	}


	public void actualizar() {
		
		if(saltar) {
			cuerpo.setLinearVelocity(cuerpo.getLinearVelocity().x, salto);
			saltar = false;
		}
		cuerpo.setLinearVelocity(velX * rapidez, cuerpo.getLinearVelocity().y);
		sprite.setOriginBasedPosition(cuerpo.getPosition().x * Utiles.PPM, cuerpo.getPosition().y * Utiles.PPM);
		
	}

	public InputAdapter getEntrada() {
		return entrada;
	}
	
	public Body getCuerpo() {
		return cuerpo;
	}
	
	public Sprite getSprite() {
		return sprite;
	}


	public int getVida() {
		return vida;
	}
	
	public void render() {
		this.actualizar();
		sprite.draw(Utiles.batch);
	}


}
