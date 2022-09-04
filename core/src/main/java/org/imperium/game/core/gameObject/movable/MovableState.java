package org.imperium.game.core.gameObject.movable;

import dto.CellDto;
import lombok.Data;

@Data
public class MovableState {

    private CellDto currentCell;
    private boolean isScreenBorderCrossedOver;

}
