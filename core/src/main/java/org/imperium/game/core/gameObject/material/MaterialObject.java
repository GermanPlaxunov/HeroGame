package org.imperium.game.core.gameObject.material;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import dto.CellDto;
import org.imperium.game.core.Constants;
import org.imperium.game.core.gameObject.drawable.DrawableObject;
import org.imperium.game.core.map.MapProvider;

public class MaterialObject extends DrawableObject implements Material{
    private final MapProvider mapProvider;
    public MaterialObject(MapProvider mapProvider, Texture texture, Vector2 position, Vector2 size) {
        super(texture, position, size);
        this.mapProvider = mapProvider;
    }

    @Override
    public boolean ifCellIsWall(CellDto cellDto) {
        return cellDto.getCellType().equals("wall");
    }

    @Override
    public boolean allowMotionUp(CellDto currentCell, float delta) {
        if(ifMotionUpCrossCellBorder(currentCell, delta)){
            return !ifCellIsWall(mapProvider.getTopCell(currentCell));
        }
        return true;
    }

    @Override
    public boolean allowMotionRight(CellDto currentCell, float delta) {
        if(ifMotionRightCrossCellBorder(currentCell, delta)){
            return !ifCellIsWall(mapProvider.getRightCell(currentCell));
        }
        return true;
    }

    @Override
    public boolean allowMotionDown(CellDto currentCell, float delta) {
        if(ifMotionDownCrossCellBorder(currentCell, delta)){
            return !ifCellIsWall(mapProvider.getBottomCell(currentCell));
        }
        return true;
    }

    @Override
    public boolean allowMotionLeft(CellDto currentCell, float delta) {
        if(ifMotionLeftCrossCellBorder(currentCell, delta)){
            return !ifCellIsWall(mapProvider.getLeftCell(currentCell));
        }
        return true;
    }

    @Override
    public boolean ifMotionUpCrossCellBorder(CellDto currentCell, float delta) {
        return position.y + size.y + delta > (currentCell.getY() + 1) * Constants.cellSize;
    }

    @Override
    public boolean ifMotionRightCrossCellBorder(CellDto currentCell, float delta) {
        return position.x + size.x + delta > (currentCell.getX() + 1) * Constants.cellSize;
    }

    @Override
    public boolean ifMotionDownCrossCellBorder(CellDto currentCell, float delta) {
        return position.y - delta < currentCell.getY() * Constants.cellSize;
    }

    @Override
    public boolean ifMotionLeftCrossCellBorder(CellDto currentCell, float delta) {
        return position.x - delta < currentCell.getX() * Constants.cellSize;
    }
}
