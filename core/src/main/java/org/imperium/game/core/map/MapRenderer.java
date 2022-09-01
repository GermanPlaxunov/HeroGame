package org.imperium.game.core.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dto.WorldMapDto;
import org.imperium.game.core.Constants;

public class MapRenderer {

    private final MapTexturesProvider texturesProvider = new MapTexturesProvider();
    private boolean isMapRendered = false;


    public void renderMap(WorldMapDto worldMapDto, SpriteBatch batch) {
        Texture texture;
        for (var cell : worldMapDto.getCells()) {
            texture = texturesProvider.getTexture(cell.getCellType());
            batch.draw(texture, cell.getX() * Constants.cellSize, cell.getY() * Constants.cellSize, Constants.cellSize, Constants.cellSize);
        }
        isMapRendered = true;
    }

    public boolean isMapRendered(){
        return isMapRendered;
    }
}
