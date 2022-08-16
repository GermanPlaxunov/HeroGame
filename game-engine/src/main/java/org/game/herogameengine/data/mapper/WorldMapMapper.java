package org.game.herogameengine.data.mapper;

import dto.WorldMapDto;
import org.game.herogameengine.game.world.map.WorldMap;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface WorldMapMapper {

    @Mappings({
            @Mapping(source = "cells", target = "cells")
    })
    WorldMapDto toDto(WorldMap worldMap);

}
