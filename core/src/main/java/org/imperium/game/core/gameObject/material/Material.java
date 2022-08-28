package org.imperium.game.core.gameObject.material;

import dto.CellDto;

public interface Material {
    boolean ifCellIsWall(CellDto cellDto);
    boolean ifMotionUpInCurrentCell(CellDto currentCell, float delta);
    boolean ifMotionRightInCurrentCell(CellDto currentCell, float delta);
    boolean ifMotionDownInCurrentCell(CellDto currentCell, float delta);
    boolean ifMotionLeftInCurrentCell(CellDto currentCell, float delta);

}
