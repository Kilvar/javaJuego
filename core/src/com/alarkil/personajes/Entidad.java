package com.alarkil.personajes;

import com.alarkil.recursos.Texturas;
import com.badlogic.gdx.physics.box2d.World;

public class Entidad extends Personaje {

	// private HabilidadEntidad habilidadentidad[] = new HabilidadEntidad[3];

	public Entidad(float spawnX, float spawnY, World w) {
		super(1800, spawnX, spawnY, Texturas.SPRITE_ENT.getRutaTex(), w);
	}

	@Override
	public void render() {
		super.render();
	}


}
