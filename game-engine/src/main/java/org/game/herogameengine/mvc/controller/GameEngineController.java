package org.game.herogameengine.mvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.game.herogameengine.game.world.map.WorldMap;
import org.game.herogameengine.game.world.map.WorldMapGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GameEngineController {

    private final WorldMapGenerator worldMapGenerator;

    @RequestMapping(method = RequestMethod.GET, path = "/get-world-map")
    public WorldMap getWorldMap(){
        return worldMapGenerator.generateWorldMap();
    }

}
