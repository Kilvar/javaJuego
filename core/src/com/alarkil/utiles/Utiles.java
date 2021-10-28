package com.alarkil.utiles;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public final class Utiles {

	//Numeros
	public static Random r = new Random();
	public static Scanner s = new Scanner(System.in);
	
	//Fisicas
	public static final float GRAVEDAD = -98f;
	public static final float PPM = 32f;
	public static final float TICK_TIEMPO = 1.0f / 60f;
	
	public static void procesarCapaObjetos(World world, MapLayer layer) {
		
		MapObjects objCollec = layer.getObjects();
		for (MapObject obj : objCollec) {
			
			Shape s = null;
			if(obj instanceof PolylineMapObject) {
				
				float[] vertices = ((PolylineMapObject) obj).getPolyline().getTransformedVertices();
				Vector2[] worldV = new Vector2[vertices.length / 2];
				
				for (int i = 0; i < worldV.length; i++) {
					worldV[i] = new Vector2(vertices[i * 2] / Utiles.PPM , vertices[i * 2 + 1] / Utiles.PPM);
				}
				s = crearFormaCadena(worldV);
			}
			Utiles.crearCuerpoBox2D(world, BodyType.StaticBody, s, false, 1f, 0, 0);
		}
	}
	
	public static Body crearCuerpoBox2D(World w, BodyType type, Shape s, boolean sensor, float dens, float worldX, float worldY) {
		
		BodyDef bDef = new BodyDef();
		bDef.type = type;
		
		bDef.position.set(worldX, worldY);
		
		Body b = w.createBody(bDef);
		
		FixtureDef fDef = new FixtureDef();
		fDef.shape = s;
		fDef.density = dens;
		fDef.friction = 0;
		fDef.isSensor = sensor;
		b.createFixture(fDef);
		
		return b;
	}
		
	public static Shape crearRectangulo(float w, float h) {
		
		PolygonShape p = new PolygonShape();
		p.setAsBox(w / 2, h / 2);
		return p;
	}
	
	public static Shape crearCirculo(float r) {
		
		CircleShape c = new CircleShape();
		c.setRadius(r);
		return c;
	}
	
	public static Shape crearFormaCadena(Vector2[] worldV) {
		
		ChainShape cs = new ChainShape();
		cs.createChain(worldV);
		return cs;
	}

	
	//Render
	public static SpriteBatch batch;
	
	public static void limpiarPantalla(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	//Otros metodos
	public static void delay(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int ingresarEntero(int min, int max) {
        boolean error = false;
        int valor = 0;
        do {
            error = false;
            try {
                valor = s.nextInt();
                if((valor<min)||(valor>max)) {
                    error = true;
                    System.out.println("Error. Debe ingresar un numero entre " + min + " y " + max);
                }
            }catch(InputMismatchException e) {
                System.out.println("Tipo de dato mal ingresado. Vuelva a intentar");
                error = true;
                s.nextLine();
            }catch(Exception e) {
                System.out.println("Error desconocido");
                error = true;
                s.nextLine();
            }
        }while(error);
        s.nextLine();
        return valor;
    }

	public static float ingresarDecimal(float min, float max) {
        boolean error = false;
        float valor = 0;
        do {
            error = false;
            try {
                valor = s.nextFloat();
                if((valor<min)||(valor>max)) {
                    error = true;
                    System.out.println("Error. Debe ingresar un numero entre " + min + " y " + max);
                }
            }catch(InputMismatchException e) {
                System.out.println("Tipo de dato mal ingresado. Vuelva a intentar");
                error = true;
                s.nextLine();
            }catch(Exception e) {
                System.out.println("Error desconocido");
                error = true;
                s.nextLine();
            }
        }while(error);
        s.nextLine();
        return valor;
    }


}
