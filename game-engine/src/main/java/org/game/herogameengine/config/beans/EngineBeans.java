package org.game.herogameengine.config.beans;

import org.game.herogameengine.game.world.map.WorldMapGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineBeans {

    @Bean
    public WorldMapGenerator worldMapGenerator(){
        return new WorldMapGenerator(1000, 1000);
    }

}
