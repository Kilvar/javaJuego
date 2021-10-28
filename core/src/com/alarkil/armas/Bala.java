package com.alarkil.armas;

import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class Bala {
	
	Body cuerpo;
	
	public Bala(World w, float x, float y) {
		cuerpo = Utiles.crearCuerpoBox2D(w, BodyType.DynamicBody, Utiles.crearCirculo(1), false, 0.5f, x, y);
		cuerpo.setBullet(true);
	}

}
