package org.imperium.game.core.gameObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.fight.FightStats;

public class Skeleton extends BasicGameObject {
    public Skeleton(Texture texture, Texture healthBar, Vector2 position, Vector2 size, FightStats stats, float moveSpeed) {
        super(texture, healthBar, position, size, stats, moveSpeed);
    }

    public void moveToEnemyIfCloseEnough(Hero enemy) {
        if (getDistance(enemy) <= stats.getAttackRange()) {
            if (center.x > enemy.getCenter().x) {
                moveLeft();
            }
            if (center.x < enemy.getCenter().x) {
                moveRight();
            }
            if (center.y > enemy.getCenter().y) {
                moveDown();
            }
            if (center.y < enemy.getCenter().y) {
                moveUp();
            }
        }
    }

}
