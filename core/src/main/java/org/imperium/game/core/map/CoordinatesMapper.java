package org.imperium.game.core.map;

import dto.CellDto;

public interface CoordinatesMapper {
    CellDto getCellByScreenCoordinates(float x, float y);
}
