package com.pong.game;

/**
 * Created by agava on 12.02.2018.
 */

public abstract class PositionObservable {

    public abstract void addObserver(PositionObserver observer);
    public abstract void notifyObservers();
    public abstract void removeObserver(PositionObserver observer);
}
