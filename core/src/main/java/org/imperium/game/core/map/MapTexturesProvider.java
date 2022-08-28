package org.imperium.game.core.map;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class MapTexturesProvider {

    private final Map<String, Texture> textures;

    public MapTexturesProvider(){
        textures = new HashMap<>();
        textures.put("earth", new Texture("assets/ground.png"));
        textures.put("wall", new Texture("assets/brickWall.png"));
    }

    public Texture getTexture(String key){
        return textures.get(key);
    }

}
