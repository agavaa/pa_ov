package com.pong.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.game.MyPongGame;

/**
 * Created by agava on 29.01.2018.
 */

public class WinState extends State {
    private BitmapFont winText;
    public WinState(GameStateManager gsm) {
        super(gsm);
        winText = new BitmapFont();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            dispose();

        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        winText.draw(sb, "You won! Click to play again", MyPongGame.WIDTH/2, MyPongGame.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        winText.dispose();
    }
}
