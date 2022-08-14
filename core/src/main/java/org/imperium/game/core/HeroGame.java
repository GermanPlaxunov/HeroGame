package org.imperium.game.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.Hero;
import org.imperium.game.core.gameObject.ObjectsProvider;
import org.imperium.game.core.gameObject.Skeleton;
import org.imperium.game.core.gameObject.fight.FightStats;
import org.imperium.game.core.map.WallBuilder;

public class HeroGame extends ApplicationAdapter {

    private ObjectsProvider provider;
    private WallBuilder wallBuilder;
    private SpriteBatch batch;
    private Skeleton skeleton;
    private Hero hero;

    @Override
    public void create() {
        provider = new ObjectsProvider();
        batch = new SpriteBatch();
        hero = provider.getHero();
        skeleton = provider.getSkeleton();
        wallBuilder = new WallBuilder();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 0.1f);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.begin();
        hero.render(batch);
        hero.renderHealthBar(batch);
        skeleton.render(batch);
        skeleton.renderHealthBar(batch);
        wallBuilder.renderWall(batch, 350, 150, 500, 150, 50);
        update();
        batch.end();
    }

    private void update() {
        if (hero.isAlive()) {
            hero.checkMove();
        }
        if (skeleton.isAlive()) {
            skeleton.moveToEnemyIfCloseEnough(hero);
        }
        if (hero.getDistance(skeleton) < hero.getStats().getAttackRange()) {
            if (hero.isAlive()) {
                hero.attack(skeleton);
            }
            if (skeleton.isAlive()) {
                skeleton.attack(hero);
            }
        }
    }

    @Override
    public void dispose() {
        hero.dispose();
        skeleton.dispose();
        batch.dispose();
    }
}
