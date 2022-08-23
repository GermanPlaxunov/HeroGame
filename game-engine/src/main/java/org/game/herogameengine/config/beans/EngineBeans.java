package org.game.herogameengine.config.beans;

import org.game.herogameengine.game.world.map.WorldMapGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineBeans {

    @Bean
    public WorldMapGenerator worldMapGenerator(){
        var mapWidth = 800/100;
        var mapHeight = 800/100;
        return new WorldMapGenerator(mapWidth, mapHeight);
    }

}
