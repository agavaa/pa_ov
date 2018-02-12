package com.pong.game;

import com.badlogic.gdx.math.Vector2;
import com.pong.game.sprites.Ball;

/**
 * Created by agava on 11.02.2018.
 */

public interface PositionObserver {
    void positionChanged(PositionObservable positionObservable, Vector2 position);
}
