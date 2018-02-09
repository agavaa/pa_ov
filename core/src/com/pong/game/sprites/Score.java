package com.pong.game.sprites;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by agava on 28.01.2018.
 */

public class Score {
    private BitmapFont score;
    private Vector2 position;

    public Score(int x, int y){
        score = new BitmapFont();
        position = new Vector2(x,y);
    }

    public void setScore(BitmapFont score) {
        this.score = score;
    }

    public BitmapFont getScore() {
        return score;
    }

    public Vector2 getPosition() {
        return position;
    }
}
