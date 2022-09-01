package org.imperium.game.core.map;

import dto.CellDto;

public interface CellSquare {
    CellDto getTopCell(CellDto currentCell);
    CellDto getTopRightCell(CellDto currentCell);
    CellDto getRightCell(CellDto currentCell);
    CellDto getBottomRightCell(CellDto currentCell);
    CellDto getBottomCell(CellDto currentCell);
    CellDto getBottomLeftCell(CellDto currentCell);
    CellDto getLeftCell(CellDto currentCell);
    CellDto getTopLeftCell(CellDto currentCell);
}
