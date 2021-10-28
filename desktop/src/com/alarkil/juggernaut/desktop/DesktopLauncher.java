package com.alarkil.juggernaut.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.alarkil.juggernaut.Juggernaut;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "carajo mierda";
		new LwjglApplication(new Juggernaut(), config);
	}
}
