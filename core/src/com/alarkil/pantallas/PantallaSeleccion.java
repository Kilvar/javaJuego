package com.alarkil.pantallas;

import com.alarkil.juggernaut.Juggernaut;
import com.alarkil.recursos.Texturas;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PantallaSeleccion extends Pantalla {

	Stage uiStage;
	Juggernaut juego;
	Texture[] personajes;
	Image seleccion;
	int pSelec;
	
	public PantallaSeleccion(Juggernaut juego) {
		
		super(juego);
		FitViewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		uiStage = new Stage(viewport);
		Gdx.input.setInputProcessor(uiStage);
		this.juego = juego;
		pSelec=0;
		
		prepareUi();
	}
	public void prepareUi() {
		
		   TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		   buttonStyle.font = new BitmapFont();
		   buttonStyle.fontColor = Color.WHITE;
		   
		   TextButton startBtn = new TextButton("START", buttonStyle);
		   startBtn.setPosition((uiStage.getWidth() - startBtn.getWidth()) / 2, uiStage.getHeight() / 6);
		   startBtn.addCaptureListener(new ClickListener() {
			   public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				   dispose();
				   if(pSelec == 1) {
					   juego.setScreen(new PantallaJuego(juego, 1, 0));
				   }
				   juego.setScreen(new PantallaSeleccionArmas(juego));
		        }
		   });
		   uiStage.addActor(startBtn);
		   
		   personajes = new Texture[] { new Texture(Texturas.SPRITE_SOB_SELEC.getRutaTex()) ,
				     					new Texture(Texturas.SPRITE_ENT_SELEC.getRutaTex()) };
		   
		   seleccion = new Image(personajes[pSelec]);
		   seleccion.setPosition((uiStage.getWidth() - seleccion.getWidth()) / 2, (uiStage.getHeight() - seleccion.getHeight()) / 2);
		   uiStage.addActor(seleccion);
		   
		   TextButton nextBtn = new TextButton(">>>", buttonStyle);
		   nextBtn.setPosition(uiStage.getWidth() * 5 / 6 - nextBtn.getWidth() / 2, uiStage.getHeight() / 2);
		   nextBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				   if(pSelec == personajes.length - 1) { pSelec = 0; }
				   else { pSelec++; }
				   
				   uiStage.clear();
				   prepareUi();
			   }
		   });
		   uiStage.addActor(nextBtn);
		     
		   TextButton prevBtn = new TextButton("<<<", buttonStyle);
		   prevBtn.setPosition(uiStage.getWidth() / 6 - prevBtn.getWidth() / 2, uiStage.getHeight() / 2);
		   prevBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				   if(pSelec == 0) { pSelec = personajes.length - 1; }
				   else { pSelec--; }
				   
				   uiStage.clear();
				   prepareUi();
			   }
		   });
		   uiStage.addActor(prevBtn);
		    
		    
		}


	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();
		uiStage.act(delta);
		uiStage.draw();

		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	    uiStage.dispose();
		
	}

}
