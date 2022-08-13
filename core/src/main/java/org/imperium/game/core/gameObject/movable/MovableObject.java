package org.imperium.game.core.gameObject.movable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import org.imperium.game.core.gameObject.drawable.DrawableObject;

@Getter
public class MovableObject extends DrawableObject implements Movable{

    private float moveSpeed;
    private float delta;

    public MovableObject(Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(texture, position, size);
        this.moveSpeed = moveSpeed;
    }

    @Override
    public void checkMove() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            moveUp();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            moveDown();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            moveLeft();
        }
    }

    @Override
    public void moveUp() {
        delta = Gdx.graphics.getDeltaTime() * moveSpeed;
        position.add(0, delta);
        center.add(0, delta);
    }

    @Override
    public void moveRight() {
        delta = Gdx.graphics.getDeltaTime() * moveSpeed;
        position.add(delta, 0);
        center.add(delta, 0);
    }

    @Override
    public void moveDown() {
        delta = Gdx.graphics.getDeltaTime() * (-1) * moveSpeed;
        position.add(0, delta);
        center.add(0, delta);
    }

    @Override
    public void moveLeft() {
        delta = Gdx.graphics.getDeltaTime() * (-1) * moveSpeed;
        position.add(delta, 0);
        center.add(delta, 0);
    }
}
