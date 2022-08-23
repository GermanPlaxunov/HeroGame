package dto;

import java.util.List;

public class WorldMapDto {
    private List<CellDto> cells;

    public WorldMapDto(){}
    public WorldMapDto(List<CellDto> cells) {
        this.cells = cells;
    }

    public List<CellDto> getCells() {
        return cells;
    }

    public void setCells(List<CellDto> cells) {
        this.cells = cells;
    }
}
