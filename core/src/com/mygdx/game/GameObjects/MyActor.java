package com.mygdx.game.GameObjects;

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
    TextureRegion[] actor_images = {actor1,actor2,actor3};
    Animation actor_animation = new Animation(5,actor_images);
    TextureRegion current_frame;
    float runTime = 0;

    float actorX     = 0, actorY = 0;
    public boolean started = false;

    public MyActor() {
        setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                ((MyActor)event.getTarget()).started = true;
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
            actorX += 5;
        }
        runTime = runTime + delta;
        current_frame = actor_animation.getKeyFrame(runTime);
    }
}