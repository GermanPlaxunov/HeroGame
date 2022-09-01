package org.imperium.game.core.gameObject.movable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import dto.CellDto;
import lombok.Getter;
import org.imperium.game.core.gameObject.material.MaterialObject;
import org.imperium.game.core.map.MapProvider;

@Getter
public class MovableObject extends MaterialObject implements Movable {
    private final MapProvider mapProvider;
    private CellDto currentCell;
    private float moveSpeed;
    private float delta;

    public MovableObject(MapProvider mapProvider, Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(mapProvider, texture, position, size);
        this.moveSpeed = moveSpeed;
        this.mapProvider = mapProvider;
        currentCell = mapProvider.getCellByScreenCoordinates(position.x, position.y);
    }

    @Override
    public void checkMove() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            moveDown();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft();
        }
    }

    @Override
    public void moveUp() {
        delta = Gdx.graphics.getDeltaTime() * moveSpeed;
        if (allowMotionUp(currentCell, delta)) {
            position.add(0, delta);
            center.add(0, delta);
            currentCell = mapProvider.getCellByScreenCoordinates(center.x, center.y);
        }
    }

    @Override
    public void moveRight() {
        delta = Gdx.graphics.getDeltaTime() * moveSpeed;
        if (allowMotionRight(currentCell, delta)) {
            position.add(delta, 0);
            center.add(delta, 0);
            currentCell = mapProvider.getCellByScreenCoordinates(center.x, center.y);
        }
    }

    @Override
    public void moveDown() {
        delta = Gdx.graphics.getDeltaTime() * (-1) * moveSpeed;
        if (allowMotionDown(currentCell, delta)) {
            position.add(0, delta);
            center.add(0, delta);
            currentCell = mapProvider.getCellByScreenCoordinates(center.x, center.y);
        }
    }

    @Override
    public void moveLeft() {
        delta = Gdx.graphics.getDeltaTime() * (-1) * moveSpeed;
        if (allowMotionLeft(currentCell, delta)) {
            position.add(delta, 0);
            center.add(delta, 0);
            currentCell = mapProvider.getCellByScreenCoordinates(center.x, center.y);
        }
    }
}
