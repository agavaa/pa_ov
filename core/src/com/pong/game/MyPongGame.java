package com.pong.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.game.states.GameStateManager;
import com.pong.game.states.PlayState;

public class MyPongGame extends ApplicationAdapter {
	public final static String TITLE = "pong";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	private SpriteBatch batch;
	private GameStateManager gsm;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
