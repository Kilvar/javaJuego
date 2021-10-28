package com.alarkil.personajes;

import com.alarkil.armas.Arma;
import com.alarkil.armas.Espada;
import com.alarkil.armas.Laser;
import com.alarkil.armas.Latigo;
import com.alarkil.armas.Rifle;
import com.alarkil.recursos.Texturas;
import com.badlogic.gdx.physics.box2d.World;

public class Sobreviviente extends Personaje {

	private Arma armaEquip;

	public Sobreviviente(float spawnX, float spawnY, World w, int nArma) {
		super(600, spawnX, spawnY, Texturas.SPRITE_SOB.getRutaTex(), w);
		
		switch(nArma) {
		case 1:
			this.armaEquip = new Rifle();
			break;
		case 2:
			this.armaEquip = new Espada();
			break;
		case 3:
			this.armaEquip = new Latigo();
			break;
		case 4:
			this.armaEquip = new Laser();
			break;
		}
	}
	
	@Override
	public void actualizar() {
		super.actualizar();
		armaEquip.actualizar(sprite.getX(), sprite.getY());
	}

	@Override
	public void render() {
		super.render();
		armaEquip.render();
	}
}
