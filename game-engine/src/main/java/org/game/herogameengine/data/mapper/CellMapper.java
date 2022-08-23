package org.game.herogameengine.data.mapper;

import dto.CellDto;
import org.game.herogameengine.game.world.map.cell.Cell;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CellMapper {

    @Mappings({
            @Mapping(source = "coordinate.x", target = "x"),
            @Mapping(source = "coordinate.y", target = "y"),
            @Mapping(source = "cellType", target = "cellType")
    })
    CellDto toDto(Cell cell);

    @Mappings({
            @Mapping(source = "coordinate.x", target = "x"),
            @Mapping(source = "coordinate.y", target = "y"),
            @Mapping(source = "cellType", target = "cellType")
    })
    List<CellDto> toDtos(List<Cell> cells);

}
