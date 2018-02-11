package com.pong.game;

import com.badlogic.gdx.math.Vector2;
import com.pong.game.sprites.Ball;

/**
 * Created by agava on 11.02.2018.
 */

public interface PositionObserver {
    void positionChanged(Ball ball, Vector2 position);
}
