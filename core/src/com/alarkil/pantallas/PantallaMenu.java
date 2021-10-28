package com.alarkil.pantallas;

import com.alarkil.elementos.Texto;
import com.alarkil.enums.Menu;
import com.alarkil.juggernaut.Juggernaut;
import com.alarkil.recursos.Texturas;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class PantallaMenu extends Pantalla {
	
	private Sprite fondo;
	private Texture imagenFondo;
	private Texto[] textos = new Texto[Menu.values().length];

	private int opc = 0;

	public PantallaMenu(Juggernaut juego) {
		
		super(juego);
		imagenFondo = new Texture(Texturas.FONDO_MENU.getRutaTex());
		fondo = new Sprite(imagenFondo);
		fondo.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		crearMenu();
	}

	private void crearMenu() {			
		
		int base = Gdx.graphics.getHeight()- 150;
		int adicion = 0;
		
		for (int i = 0; i < Menu.values().length; i++) {
			textos[i] = Menu.values()[i].getTexto();
			textos[i].setPosition((Gdx.graphics.getWidth() / 2 ) - textos[i].getAncho() / 2, base - adicion);
			adicion += 50;
		}
		
		textos[0].setColor(Color.BLUE);
	}
	
	public void cambiarOpcion(int keycode) {
		
		textos[opc].setColor(Color.WHITE);
		
		if(keycode == Input.Keys.DOWN) { opc++; }
		if(keycode == Input.Keys.UP)   { opc--; }
		
		if(opc < 0)                        { opc = Menu.values().length - 1; }
		if(opc > Menu.values().length - 1) { opc = 0; }
		
		textos[opc].setColor(Color.BLUE);	
	}
	
	public void ingresarOpcion() {
		
		switch(opc) {
		case 0:
			juego.setScreen(new PantallaSeleccion(juego));
			break;
		case 1:
			juego.setScreen(new PantallaSeleccion(juego));
			break;
		case 2:
			Gdx.app.exit();
			break;	
		}	
	}

	@Override
	public void show() {
		
		super.show();
		
		Gdx.input.setInputProcessor(new InputAdapter() {
			
			@Override
			public boolean keyDown(int keycode) {
				
				if(keycode == Input.Keys.ENTER) {
					ingresarOpcion();
				}
				else {
					cambiarOpcion(keycode);
				}
				
				return true;
			}
		});	
	}

	@Override
	public void render(float delta) {
		
		super.render(delta);
		Utiles.batch.begin();
		
			fondo.draw(Utiles.batch);
			for (int i = 0; i < textos.length; i++) {
				textos[i].draw();
			}		
		Utiles.batch.end();
	}
	
	@Override
	public void dispose() {
		
		super.dispose();
		Gdx.input.setInputProcessor(null);
	}


}
