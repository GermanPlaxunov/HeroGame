package org.imperium.game.core.gameObject.presets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import dto.CellDto;
import org.imperium.game.core.gameObject.material.Material;
import org.imperium.game.core.gameObject.movable.MovableObject;

public class BasicMaterialMovableObject extends MovableObject implements Material {

    private final int cellSize = 100;

    public BasicMaterialMovableObject(Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(texture, position, size, moveSpeed);
    }

    @Override
    public boolean ifCellIsWall(CellDto cellDto) {
        return cellDto.getCellType().equals("wall");
    }

    @Override
    public boolean ifMotionUpInCurrentCell(CellDto currentCell, float delta) {
        return position.y + size.y + delta < (currentCell.getY() * cellSize) + cellSize;
    }

    @Override
    public boolean ifMotionRightInCurrentCell(CellDto currentCell, float delta) {
        return position.x + size.x + delta < (currentCell.getX() * cellSize) + cellSize;
    }

    @Override
    public boolean ifMotionDownInCurrentCell(CellDto currentCell, float delta) {
        return position.y - delta > (currentCell.getY() * cellSize);
    }

    @Override
    public boolean ifMotionLeftInCurrentCell(CellDto currentCell, float delta) {
        return position.x - delta > (currentCell.getX() * cellSize);
    }
}
