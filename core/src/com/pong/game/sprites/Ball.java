package com.pong.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pong.game.MyPongGame;
import com.pong.game.PositionObservable;
import com.pong.game.PositionObserver;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by agava on 26.01.2018.
 */

public class Ball extends PositionObservable{
    private static final Ball INSTANCE = new Ball();
    private int speed;
    private Texture ball;
    private Vector2 position = new Vector2(0,0);
    private Vector2 velocity;
    private boolean direction;
    private boolean up;
    private Rectangle bounds;

    private List<PositionObserver> observers = new ArrayList<PositionObserver>();

    private Ball (){
        velocity = new Vector2(0,0);
        ball = new Texture("ball1.png");
        direction = MathUtils.randomBoolean();
        up = false;
        speed = 250;
        bounds = new Rectangle(position.x,position.y,ball.getWidth(),ball.getHeight());
    }

    public void update(float dt){
        bounds.setPosition(position.x,position.y);
        if (direction){
            velocity.add(-speed,0);
            velocity.scl(dt);
            position.add(velocity.x,0);
        }
        if (!direction){
            velocity.add(speed,0);
            velocity.scl(dt);
            position.add(velocity.x,0);
        }
        if (!up){
            velocity.add(0,-speed);
            velocity.scl(dt);
            position.add(0,velocity.y);
        }
        if (up){
            velocity.add(0,speed);
            velocity.scl(dt);
            position.add(0,velocity.y);
        }

        if (position.y>= MyPongGame.HEIGHT-ball.getHeight()){
            up = false;
        }
        if (position.y<=0){
            up = true;
        }
        if (position.x <=0 || position.x >= MyPongGame.WIDTH-ball.getWidth()){
            notifyObservers();
        }

    }

    public boolean collides (Rectangle rectangle){
        return bounds.overlaps(rectangle);
    }

    public Texture getBall(){
        return ball;
    }

    public Vector2 getPosition(){
        return position;
    }

    public static Ball getInstance(){
        return INSTANCE;
    }

    public void  setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }

    public void setDirection(boolean direction){
        this.direction = direction;
    }

    public void dispose(){
        ball.dispose();
    }

    //observable-related functions

    //adds an observed to this observed
    public void addObserver(PositionObserver observer){
        observers.add(observer);
    }

    //notifies observers about relevant changes in position
    public void notifyObservers(){
            for (PositionObserver o:
                    observers) {
                o.positionChanged(INSTANCE, position);
            }
    }
    public void removeObserver(PositionObserver observer){
        observers.remove(observer);
    }
}
