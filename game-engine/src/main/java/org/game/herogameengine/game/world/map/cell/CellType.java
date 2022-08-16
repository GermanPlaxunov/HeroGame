package org.game.herogameengine.game.world.map.cell;

public enum CellType {
    WALL("wall"),
    EARTH("earth");

    private String cellType;

    CellType(String cellType) {
        this.cellType = cellType;
    }

    public String getCellTypeName(){
        return this.cellType;
    }
}
