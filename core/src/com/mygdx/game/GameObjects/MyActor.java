package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by raghu on 6/10/14.
 */
public class MyActor extends Actor {
    int WIDTH = 280,HEIGHT =350;
    Texture texture = new Texture("sprite.png");
    TextureRegion actor1 = new TextureRegion(texture,0,0,WIDTH,HEIGHT);
    TextureRegion actor2 = new TextureRegion(texture,WIDTH,0,WIDTH,HEIGHT);
    TextureRegion actor3 = new TextureRegion(texture,2*WIDTH,0,WIDTH,HEIGHT);
    TextureRegion actor4 = new TextureRegion(texture,3*WIDTH,0,WIDTH,HEIGHT);
    TextureRegion actor5 = new TextureRegion(texture,4*WIDTH,0,WIDTH,HEIGHT);
    TextureRegion actor6 = new TextureRegion(texture,0,HEIGHT,WIDTH,HEIGHT);
    TextureRegion actor7 = new TextureRegion(texture,WIDTH,HEIGHT,WIDTH,HEIGHT);
    TextureRegion actor8 = new TextureRegion(texture,2*WIDTH,HEIGHT,WIDTH,HEIGHT);
    TextureRegion actor9 = new TextureRegion(texture,3*WIDTH,HEIGHT,WIDTH,HEIGHT);
    TextureRegion actor10 = new TextureRegion(texture,4*WIDTH,HEIGHT,WIDTH,HEIGHT);

    TextureRegion[] actor_images = {actor1,actor2,actor3,actor4,actor5,actor6,actor7,actor8,actor9,actor10};
    Animation actor_animation = new Animation(0.1f,actor_images);
    TextureRegion current_frame;
    float runTime = 0;
    int dir = 0;

    float actorX     = 0, actorY = 200;
    public boolean started = false;

    public MyActor() {
        setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(((MyActor)event.getTarget()).started == false) {
                    ((MyActor) event.getTarget()).started = true;
                }else{
                    ((MyActor) event.getTarget()).started = false;
                }
                return true;
            }
        });
        actor_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        current_frame = actor_animation.getKeyFrame(actorX);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(current_frame,actorX,actorY);

    }
    public void act(float delta){
        if(started){
            if(dir == 0){
                actorX += 5;
            }else{
                actorX -= 5;
            }
            if(actorX > Gdx.graphics.getWidth()){
                dir = 1;
            }else if(actorX < 0){
                dir = 0;
            }
            runTime = runTime + delta;
            current_frame = actor_animation.getKeyFrame(runTime);
        }

    }
}