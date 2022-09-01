package org.imperium.game.core.gameObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.movable.MovableObject;
import org.imperium.game.core.map.MapProvider;

public class Skeleton extends MovableObject {

    public Skeleton(MapProvider mapProvider, Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(mapProvider, texture, position, size, moveSpeed);
    }
}
