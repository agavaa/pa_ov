package com.pong.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pong.game.MyPongGame;

/**
 * Created by agava on 26.01.2018.
 */

public class Paddle {
    private  int speed;
    private Texture paddle;
    private Vector2 velocity;
    private Vector2 position;
    private Rectangle bounds;

    public Paddle(int x, int y){
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        paddle = new Texture("paddle.png");
        speed = 8;
        bounds = new Rectangle(position.x,position.y,paddle.getWidth(),paddle.getHeight());
    }


    public  void moveUp(){
        velocity.add(0,speed);
        position.add(0,velocity.y);
        if (position.y >= MyPongGame.HEIGHT-getPaddle().getHeight()){
            position.y = MyPongGame.HEIGHT-getPaddle().getHeight();
        }

    }
    public void  moveDown(){
        velocity.add(0,-speed);
        position.add(0,velocity.y);
        if (position.y<=0){
            position.y = 0;
        }
    }

    public Texture getPaddle() {
        return paddle;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt){
        bounds.setPosition(position.x,position.y);
        velocity.scl(dt);
    }

    public void dispose(){
        paddle.dispose();
    }


}
