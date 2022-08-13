package org.imperium.game.core.gameObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Hero extends BasicGameObject{

    public Hero(Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(texture, position, size, moveSpeed);
    }

}
