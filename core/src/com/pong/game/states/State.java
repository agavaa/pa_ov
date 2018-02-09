package com.pong.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by agava on 26.01.2018.
 */

public abstract class State {
    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
