package org.imperium.game.core.gameObject.fight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import org.imperium.game.core.gameObject.drawable.DrawableObject;
import org.imperium.game.core.gameObject.movable.MovableObject;

@Getter
public class FightableObject extends MovableObject implements Fightable{

    protected final Texture healthBar;
    protected final FightStats stats;

    public FightableObject(Texture texture, Texture healthBar, Vector2 position, Vector2 size, FightStats stats, float moveSpeed) {
        super(texture, position, size, moveSpeed);
        this.healthBar = healthBar;
        this.stats = stats;
    }

    @Override
    public boolean isAlive() {
        return stats.getHealth() > 0;
    }

    @Override
    public void renderHealthBar(SpriteBatch batch){
        batch.begin();
        batch.draw(healthBar, position.x, position.y + size.y + 10, stats.getHealth(), 5);
        batch.end();
    }

    @Override
    public boolean checkDistance(DrawableObject drawable) {
        return Math.sqrt(
                Math.pow((drawable.getPosition().x - position.x), 2) +
                Math.pow((drawable.getPosition().y - position.y), 2)) <= stats.getAttackRange();
    }

    @Override
    public void attack(FightableObject fightable) {
        fightable.stats.acceptDamage(stats.getDamage());

    }
}
