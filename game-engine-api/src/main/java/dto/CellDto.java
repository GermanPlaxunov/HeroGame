package dto;

public class CellDto {
    private int x;
    private int y;
    private String cellType;

    public CellDto(){}
    public CellDto(int x, int y, String cellType) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCellType() {
        return cellType;
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
    }
}
