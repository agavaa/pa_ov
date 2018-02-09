package com.pong.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.game.MyPongGame;
import com.pong.game.sprites.Ball;
import com.pong.game.sprites.Paddle;

/**
 * Created by agava on 26.01.2018.
 */

public class PlayState extends State {
    private Ball ball;
    private Paddle paddle1;
    private Paddle paddle2;
    private BitmapFont score1Drawn;
    private BitmapFont score2Drawn;
    private int score1;
    private int score2;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        ball = Ball.getInstance();
        ball.setPosition(MyPongGame.WIDTH/2,MyPongGame.HEIGHT/2-10);
        paddle1 = new Paddle(5,50);
        paddle2 = new Paddle(MyPongGame.WIDTH-30,50);
        score1 = 0;
        score2 = 0;
        score1Drawn = new BitmapFont();
        score2Drawn = new BitmapFont();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            paddle1.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            paddle1.moveDown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            paddle2.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            paddle2.moveDown();
        }
    }

    @Override
    public void update(float dt) {
        ball.update(dt);
        paddle1.update(dt);
        paddle2.update(dt);
        handleInput();
        if (ball.collides(paddle1.getBounds())){
            ball.setDirection(false);
        }
        if (ball.collides(paddle2.getBounds())){
            ball.setDirection(true);
        }

        if (ball.getPosition().x <=0){
            score2++;
            ball.setPosition(MyPongGame.WIDTH/2, MyPongGame.HEIGHT/2);
        }

        if (ball.getPosition().x >= MyPongGame.WIDTH-ball.getBall().getWidth()){
            score1++;
            ball.setPosition(MyPongGame.WIDTH/2, MyPongGame.HEIGHT/2);
        }
        if(score1==21 || score2==21){
            gsm.set(new WinState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(ball.getBall(), ball.getPosition().x, ball.getPosition().y);
        sb.draw(paddle1.getPaddle(), paddle1.getPosition().x, paddle1.getPosition().y);
        sb.draw(paddle2.getPaddle(), paddle2.getPosition().x, paddle2.getPosition().y);
        score1Drawn.draw(sb, Integer.toString(score1), 80, MyPongGame.HEIGHT - 50);
        score2Drawn.draw(sb, Integer.toString(score2), 400, MyPongGame.HEIGHT - 50);
        sb.end();
    }

    @Override
    public void dispose() {
        ball.dispose();
        paddle2.dispose();
        paddle1.dispose();
        score2Drawn.dispose();
        score1Drawn.dispose();
    }
}
