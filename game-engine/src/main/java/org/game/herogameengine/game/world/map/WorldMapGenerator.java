package org.game.herogameengine.game.world.map;

import lombok.RequiredArgsConstructor;
import org.game.herogameengine.game.world.map.cell.Cell;
import org.game.herogameengine.game.world.map.cell.CellType;
import org.game.herogameengine.game.world.map.cell.Coordinate;

import java.util.HashMap;
import java.util.Random;

@RequiredArgsConstructor
public class WorldMapGenerator {

    private final int mapWidth;
    private final int mapHeight;

    private final Random random = new Random();

    public WorldMap generateWorldMap() {
        var cells = new HashMap<Coordinate, Cell>();
        for (var x = 0; x < mapWidth; x++) {
            for (var y = 0; y < mapHeight; y++) {
                cells.put(new Coordinate(x, y), generateCell());
            }
        }
        return new WorldMap(cells);
    }

    private Cell generateCell() {
        if (random.nextInt(4) < 3) {
            return new Cell(CellType.EARTH);
        } else {
            return new Cell(CellType.WALL);
        }
    }

}
