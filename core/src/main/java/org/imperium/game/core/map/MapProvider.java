package org.imperium.game.core.map;

import dto.WorldMapDto;
import org.imperium.game.core.loader.MapLoader;

public class MapProvider {

    private final MapLoader mapLoader = new MapLoader();

    private WorldMapDto mapInstance;

    public WorldMapDto provideWorldMap(){
        if(mapInstance != null){
            return mapInstance;
        } else {
            return mapLoader.getWorldMap();
        }

    }

}
