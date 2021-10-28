package com.alarkil.elementos;


import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;


public class Texto {

	BitmapFont fuente;
	GlyphLayout layout;

	private String stringTxt="";
	private float x = 0,y = 0;

	public Texto(String texto, String rutaFuente, int tamaño, Color color) {

		this.stringTxt = texto;

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = tamaño;
        parameter.color = color;

        fuente = generator.generateFont(parameter);


        layout = new GlyphLayout();
        layout.setText(fuente, stringTxt);

	}

	public void draw() {
		fuente.draw(Utiles.batch, stringTxt, x, y);
	}

	public void setColor(Color color) {
		fuente.setColor(color);
	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void setTexto(String texto) {
		this.stringTxt = texto;
		layout.setText(fuente, stringTxt);
	}

	public float getAncho() {
		return layout.width;
	}

	public float getAlto() {
		return layout.height;
	}

	public Vector2 getDimension() {
		return new Vector2(layout.width, layout.height);

	}

}
