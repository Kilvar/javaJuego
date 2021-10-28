package com.alarkil.juggernaut;

import com.alarkil.pantallas.PantallaMenu;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Juggernaut extends Game {

//	private Music musica;   musica deshabilitada por que sino no puedo pasar el juego

	@Override
	public void create () {

		Utiles.batch = new SpriteBatch();

		this.setScreen(new PantallaMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {


	}
}
