package com.alarkil.pantallas;

import com.alarkil.juggernaut.Juggernaut;
import com.alarkil.recursos.Texturas;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PantallaSeleccionArmas extends Pantalla {
	
	Stage uiStage;
	Texture[] armas;
	Image seleccion;
	int aSelec;
	
	public PantallaSeleccionArmas(Juggernaut juego) {
		super(juego);
		FitViewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		uiStage = new Stage(viewport);
		Gdx.input.setInputProcessor(uiStage);
		this.juego = juego;
		aSelec=0;
		
		prepareUi();
	}
	
	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();
		uiStage.act(delta);
		uiStage.draw();
		
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
				   juego.setScreen(new PantallaJuego(juego, 0, aSelec + 1));
		        }
		   });
		   uiStage.addActor(startBtn);
		   
		   armas = new Texture[] { new Texture(Texturas.SPRITE_ARMA_RIF.getRutaTex()),
				   				   new Texture(Texturas.SPRITE_ARMA_ESP.getRutaTex()),
				   				   new Texture(Texturas.SPRITE_ARMA_LAT.getRutaTex()),
				   				   new Texture(Texturas.SPRITE_ARMA_LAS.getRutaTex())
		   };
		   
		   seleccion = new Image(armas[aSelec]);
		   seleccion.setPosition((uiStage.getWidth() - seleccion.getWidth()) / 2, (uiStage.getHeight() - seleccion.getHeight()) / 2);
		   uiStage.addActor(seleccion);
		   
		   TextButton nextBtn = new TextButton(">>>", buttonStyle);
		   nextBtn.setPosition(uiStage.getWidth() * 5 / 6 - nextBtn.getWidth() / 2, uiStage.getHeight() / 2);
		   nextBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) { 
				   if(aSelec == armas.length - 1) { aSelec = 0; }
				   else { aSelec++; }
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
				   
				   if(aSelec == 0) { aSelec = armas.length - 1; }
				   else { aSelec--; }
				   
				   uiStage.clear();
				   prepareUi();
			   }
		   });
		   uiStage.addActor(prevBtn);
		    
		    
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	    uiStage.dispose();
		
	}
	
	

}
