package org.imperium.game.core.gameObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.presets.BasicMaterialMovableObject;

public class Hero extends BasicMaterialMovableObject {

    public Hero(Texture texture, Vector2 position, Vector2 size, float moveSpeed) {
        super(texture, position, size, moveSpeed);
    }
}
