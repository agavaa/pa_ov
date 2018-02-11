package com.pong.game;

import com.pong.game.sprites.Ball;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by agava on 09.02.2018.
 */

public interface ScoreObserver {

     void update(Ball ball);
}
