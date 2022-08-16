package org.game.herogameengine.game.world.map;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.game.herogameengine.game.world.map.cell.Cell;

import java.util.List;

@Data
@RequiredArgsConstructor
public class WorldMap {
    private final List<Cell> cells;

}
