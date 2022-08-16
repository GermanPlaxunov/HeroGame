package org.game.herogameengine.game.world.map;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.game.herogameengine.game.world.map.cell.Cell;
import org.game.herogameengine.game.world.map.cell.Coordinate;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class WorldMap {
    private final Map<Coordinate, Cell> cells;

}
