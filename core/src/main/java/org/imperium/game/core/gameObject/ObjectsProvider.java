package org.imperium.game.core.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import org.imperium.game.core.gameObject.fight.FightStats;

@Getter
public class ObjectsProvider {

    private final Skeleton skeleton = createSkeleton();
    private final Hero hero = createHero();

    private Hero createHero(){
        var heroTexture = new Texture(Gdx.files.internal("assets/hero.png"));
        var healthBar = new Texture(Gdx.files.internal("assets/healthBar.png"));
        var position = new Vector2(360, 355);
        var size = new Vector2(80, 90);
        var fightStats = new FightStats(350, 2.7f, 200, 2.0f);
        return new Hero(heroTexture, position, size, 150);
    }

    private Skeleton createSkeleton(){
        var skeletonTexture = new Texture(Gdx.files.internal("assets/skeleton.png"));
        var healthBar = new Texture(Gdx.files.internal("assets/healthBar.png"));
        var position = new Vector2(500, 400);
        var size = new Vector2(70, 90);
        var fightStats = new FightStats(300, 2.5f, 180, 2.0f);
        return new Skeleton(skeletonTexture, position, size, 100);
    }

}
