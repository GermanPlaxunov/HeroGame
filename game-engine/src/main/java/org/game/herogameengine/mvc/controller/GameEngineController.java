package org.game.herogameengine.mvc.controller;

import dto.WorldMapDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.game.herogameengine.data.mapper.CellMapper;
import org.game.herogameengine.data.mapper.WorldMapMapper;
import org.game.herogameengine.game.world.map.WorldMapGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GameEngineController {

    private final WorldMapGenerator worldMapGenerator;
    private final WorldMapMapper worldMapMapper;
    private final CellMapper cellMapper;

    @RequestMapping(method = RequestMethod.GET, path = "/get-world-map")
    public WorldMapDto getWorldMap(){
        var worldMap = worldMapGenerator.generateWorldMap();
        var cellsDto = cellMapper.toDtos(worldMap.getCells());
        var worldMapDto = worldMapMapper.toDto(worldMap);
        worldMapDto.setCells(cellsDto);
        return worldMapDto;
    }

}
