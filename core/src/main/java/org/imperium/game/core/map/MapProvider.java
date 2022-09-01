package org.imperium.game.core.map;

import dto.CellDto;
import dto.WorldMapDto;
import org.imperium.game.core.Constants;
import org.imperium.game.core.loader.MapLoader;

import java.util.HashMap;
import java.util.Map;

public class MapProvider implements CellSquare, CoordinatesMapper {

    private final MapLoader mapLoader = new MapLoader();
    private final Map<String, CellDto> cellsMap = new HashMap<>();
    private final String DIVIDER = "<::>";
    private WorldMapDto mapInstance;
    private String coordinateKey;

    public WorldMapDto provideWorldMap() {
        if (mapInstance == null) {
            this.mapInstance = mapLoader.getWorldMap();
            this.mapInstance.getCells().stream().forEach(cell -> {
                cellsMap.put(cell.getX() + DIVIDER + cell.getY(), cell);
            });
        }
        return mapInstance;
    }

    @Override
    public CellDto getCellByScreenCoordinates(float x, float y) {
        coordinateKey = ((int) (x / Constants.cellSize)) + DIVIDER + ((int) (y / Constants.cellSize));
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getTopCell(CellDto currentCell) {
        coordinateKey = currentCell.getX() + DIVIDER + (currentCell.getY() + 1);
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getTopRightCell(CellDto currentCell) {
        coordinateKey = (currentCell.getX() + 1) + DIVIDER + (currentCell.getY() + 1);
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getRightCell(CellDto currentCell) {
        coordinateKey = (currentCell.getX() + 1) + DIVIDER + currentCell.getY();
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getBottomRightCell(CellDto currentCell) {
        coordinateKey = (currentCell.getX() + 1) + DIVIDER + (currentCell.getY() - 1);
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getBottomCell(CellDto currentCell) {
        coordinateKey = currentCell.getX() + DIVIDER + (currentCell.getY() - 1);
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getBottomLeftCell(CellDto currentCell) {
        coordinateKey = (currentCell.getX() - 1) + DIVIDER + (currentCell.getY() - 1);
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getLeftCell(CellDto currentCell) {
        coordinateKey = (currentCell.getX() - 1) + DIVIDER + currentCell.getY();
        return cellsMap.get(coordinateKey);
    }

    @Override
    public CellDto getTopLeftCell(CellDto currentCell) {
        coordinateKey = (currentCell.getX() - 1) + DIVIDER + (currentCell.getY() + 1);
        return cellsMap.get(coordinateKey);
    }
}
