package com.alarkil.pantallas;

import com.alarkil.juggernaut.Juggernaut;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Screen;

public class Pantalla implements Screen {

	Juggernaut juego;
	
	public Pantalla(Juggernaut juego) {
		this.juego = juego;
	}
	
	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
