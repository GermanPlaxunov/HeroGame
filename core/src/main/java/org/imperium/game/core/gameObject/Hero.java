package org.imperium.game.core.gameObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.fight.FightStats;

public class Hero extends BasicGameObject{

    public Hero(Texture texture, Texture healthBar, Vector2 position, Vector2 size, FightStats stats, float moveSpeed) {
        super(texture, healthBar, position, size, stats, moveSpeed);
    }
}
