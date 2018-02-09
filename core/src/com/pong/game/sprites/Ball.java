package com.pong.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pong.game.MyPongGame;

/**
 * Created by agava on 26.01.2018.
 */

public class Ball {
    private static final Ball INSTANCE = new Ball();
    private int speed;
    private Texture ball;
    private Vector2 position = new Vector2(0,0);
    private Vector2 velocity;
    private boolean direction;
    private boolean up;
    private Rectangle bounds;

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
}
