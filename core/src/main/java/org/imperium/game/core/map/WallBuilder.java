package org.imperium.game.core.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WallBuilder {

    private final Texture texture = new Texture(Gdx.files.internal("assets/brickWall.png"));

    public void renderWall(SpriteBatch batch, float startX, float startY, float endX, float endY, float cellSize) {
        if ((startX != endX) && (startY == endY)) {
            for (var x = startX; x <= endX; x += cellSize) {
                batch.draw(texture, x, startY, cellSize, cellSize);
            }
        }
        if ((startX == endX) && (startY != endY)) {
            for (var y = startY; y <= endY; y += cellSize){
                batch.draw(texture, startX, y, cellSize, cellSize);
            }
        }
    }

}
