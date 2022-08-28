package org.imperium.game.core.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dto.WorldMapDto;

public class MapRenderer {

    private final MapTexturesProvider texturesProvider = new MapTexturesProvider();
    private final int cellSize = 100;
    private boolean isMapRendered = false;


    public void renderMap(WorldMapDto worldMapDto, SpriteBatch batch) {
        Texture texture;
        for (var cell : worldMapDto.getCells()) {
            texture = texturesProvider.getTexture(cell.getCellType());
            batch.draw(texture, cell.getX() * cellSize, cell.getY() * cellSize, cellSize, cellSize);
        }
        isMapRendered = true;
    }

    public boolean isMapRendered(){
        return isMapRendered;
    }
}
