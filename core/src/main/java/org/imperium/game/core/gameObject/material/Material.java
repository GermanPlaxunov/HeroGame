package org.imperium.game.core.gameObject.material;

import dto.CellDto;

public interface Material {
    boolean ifCellIsWall(CellDto cellDto);
    boolean allowMotionUp(CellDto currentCell, float delta);
    boolean allowMotionRight(CellDto currentCell, float delta);
    boolean allowMotionDown(CellDto currentCell, float delta);
    boolean allowMotionLeft(CellDto currentCell, float delta);

    boolean ifMotionUpCrossCellBorder(CellDto currentCell, float delta);
    boolean ifMotionRightCrossCellBorder(CellDto currentCell, float delta);
    boolean ifMotionDownCrossCellBorder(CellDto currentCell, float delta);
    boolean ifMotionLeftCrossCellBorder(CellDto currentCell, float delta);
}
