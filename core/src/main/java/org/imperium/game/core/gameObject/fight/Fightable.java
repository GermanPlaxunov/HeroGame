package org.imperium.game.core.gameObject.fight;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.imperium.game.core.gameObject.drawable.DrawableObject;

public interface Fightable {
    boolean checkDistance(DrawableObject drawable);
    void attack(FightableObject fightable);
    void renderHealthBar(SpriteBatch batch);
}
