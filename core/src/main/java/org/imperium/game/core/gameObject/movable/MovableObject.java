package org.imperium.game.core.gameObject.movable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import org.imperium.game.core.Constants;
import org.imperium.game.core.gameObject.material.MaterialObject;
import org.imperium.game.core.map.MapProvider;

@Getter
public class MovableObject extends MaterialObject implements Movable {
    private final MapProvider mapProvider;
    private final MovableState state;
    private float moveSpeed;
    private float delta;

    public MovableObject(MapProvider mapProvider, Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(mapProvider, texture, position, size);
        this.moveSpeed = moveSpeed;
        this.mapProvider = mapProvider;
        state = new MovableState();
        state.setCurrentCell(mapProvider.getCellByScreenCoordinates(position.x, position.y));
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
        if(!ifScreenBorderCrossedOver()) {
            if (allowMotionUp(state.getCurrentCell(), delta)) {
                position.add(0, delta);
                center.add(0, delta);
                if (ifMotionUpCrossCellBorder(state.getCurrentCell(), delta)) {
                    state.setCurrentCell(mapProvider.getCellByScreenCoordinates(center.x, center.y));
                }
            }
        }
    }

    @Override
    public void moveRight() {
        delta = Gdx.graphics.getDeltaTime() * moveSpeed;
        if(!ifScreenBorderCrossedOver()) {
            if (allowMotionRight(state.getCurrentCell(), delta)) {
                position.add(delta, 0);
                center.add(delta, 0);
                if (ifMotionRightCrossCellBorder(state.getCurrentCell(), delta)) {
                    state.setCurrentCell(mapProvider.getCellByScreenCoordinates(center.x, center.y));
                }
            }
        }
    }

    @Override
    public void moveDown() {
        delta = Gdx.graphics.getDeltaTime() * (-1) * moveSpeed;
        if(!ifScreenBorderCrossedOver()) {
            if (allowMotionDown(state.getCurrentCell(), delta)) {
                position.add(0, delta);
                center.add(0, delta);
                if (ifMotionDownCrossCellBorder(state.getCurrentCell(), delta)) {
                    state.setCurrentCell(mapProvider.getCellByScreenCoordinates(center.x, center.y));
                }
            }
        }
    }

    @Override
    public void moveLeft() {
        delta = Gdx.graphics.getDeltaTime() * (-1) * moveSpeed;
        if(!ifScreenBorderCrossedOver()) {
            if (allowMotionLeft(state.getCurrentCell(), delta)) {
                position.add(delta, 0);
                center.add(delta, 0);
                if (ifMotionLeftCrossCellBorder(state.getCurrentCell(), delta)) {
                    state.setCurrentCell(mapProvider.getCellByScreenCoordinates(center.x, center.y));
                }
            }
        }
    }

    @Override
    public boolean ifScreenBorderCrossedOver() {
        return !((position.y >= 0) &&
                (position.x >= 0) &&
                (position.x + size.x < Constants.screenWidth - 20) &&
                (position.y + size.y < Constants.screenHeight - 20));
    }
}
