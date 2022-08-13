package org.imperium.game.core.gameObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.fight.FightStats;
import org.imperium.game.core.gameObject.fight.FightableObject;

public class BasicGameObject extends FightableObject {

    public BasicGameObject(Texture texture, Texture healthBar, Vector2 position, Vector2 size, FightStats stats, float moveSpeed) {
        super(texture, healthBar, position, size, stats, moveSpeed);
    }
}
