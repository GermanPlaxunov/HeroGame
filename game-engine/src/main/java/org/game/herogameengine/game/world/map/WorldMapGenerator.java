package org.game.herogameengine.game.world.map;

import lombok.RequiredArgsConstructor;
import org.game.herogameengine.game.world.map.cell.Cell;
import org.game.herogameengine.game.world.map.cell.CellType;
import org.game.herogameengine.game.world.map.cell.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RequiredArgsConstructor
public class WorldMapGenerator {

    private final int mapWidth;
    private final int mapHeight;

    private final Random random = new Random();

    public WorldMap generateWorldMap() {
        var cells = new ArrayList<Cell>();
        for (var x = 0; x < mapWidth; x++) {
            for (var y = 0; y < mapHeight; y++) {
                cells.add(generateCell(x, y));
            }
        }
        return new WorldMap(cells);
    }

    private Cell generateCell(int x, int y) {
        var cellType = random.nextInt(4) < 3 ? CellType.EARTH : CellType.WALL;
        return new Cell(new Coordinate(x, y), cellType);
    }

}
