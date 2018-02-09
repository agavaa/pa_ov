package com.pong.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pong.game.MyPongGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MyPongGame(), config);
		config.height = MyPongGame.HEIGHT;
		config.width = MyPongGame.WIDTH;
		config.title = MyPongGame.TITLE;
	}
}
