package com.alarkil.pantallas;

import com.alarkil.juggernaut.Juggernaut;
import com.alarkil.personajes.Entidad;
import com.alarkil.personajes.Personaje;
import com.alarkil.personajes.Sobreviviente;
import com.alarkil.utiles.Utiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class PantallaJuego extends Pantalla {

	private int tileW, tileH, mapTileW, mapTileH, mapPixW, mapPixH;
	
	private TiledMap map;
	private AssetManager manager;
	
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera cam;
	private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
	
	private World world;
	
	private Personaje p;

	public PantallaJuego(Juggernaut juego, int personaje, int nArma) {
		super(juego);
		
		debugRenderer.setDrawBodies(true);
		world   = new World(new Vector2(0, Utiles.GRAVEDAD), true);
		
		cargarMapa();
		crearSolidos();
		
		MapLayer objLayer =  map.getLayers().get("gameObj");
		RectangleMapObject spawn = (RectangleMapObject) objLayer.getObjects().get("spawn");
		Vector2 spawnpoint = new Vector2((float) spawn.getRectangle().x,(float) spawn.getRectangle().y);
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.x = spawnpoint.x;
		cam.position.y = spawnpoint.y;

		if(personaje == 0) {
			p = new Sobreviviente(spawnpoint.x, spawnpoint.y, world, nArma);
		}
		else {
			p = new Entidad(spawnpoint.x, spawnpoint.y, world);
		}
		
	}
	
	private void cargarMapa() {

		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader());
		manager.load("mapas/mapa.tmx", TiledMap.class);
		manager.finishLoading();
		
		map = manager.get("mapas/mapa.tmx", TiledMap.class);
		MapProperties props = map.getProperties();
		
		tileW    = props.get("tilewidth", Integer.class);
		tileH    = props.get("tileheight", Integer.class);
		mapTileW = props.get("width", Integer.class);
		mapTileH = props.get("height", Integer.class);
		mapPixW  = mapTileW * tileW;
		mapPixH  = mapTileH * tileH;
		
		renderer = new OrthogonalTiledMapRenderer(map);
	}
	

	private void crearSolidos() {
		Utiles.procesarCapaObjetos(world, map.getLayers().get("col"));
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(p.getEntrada());

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		world.step(Utiles.TICK_TIEMPO, 6, 2);
		
		cam.update();
		
		Utiles.batch.setProjectionMatrix(cam.combined);
		Utiles.batch.begin();
		
			p.render();
		
		Utiles.batch.end();
		
		cam.position.x = p.getSprite().getX();
		cam.position.y = p.getSprite().getY();
		
		renderer.setView(cam);
		renderer.render();
		debugRenderer.render(world, cam.combined.scl(Utiles.PPM));
		
		
	}
	
	public void dispose() {

		manager.dispose();
		world.dispose();

	}

}
