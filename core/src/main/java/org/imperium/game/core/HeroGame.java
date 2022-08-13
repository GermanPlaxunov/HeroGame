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

public class HeroGame extends ApplicationAdapter {

    private ObjectsProvider provider;
    private SpriteBatch batch;
    private Skeleton skeleton;
    private Hero hero;

    @Override
    public void create() {
        provider = new ObjectsProvider();
        batch = new SpriteBatch();
        hero = provider.getHero();
        skeleton = provider.getSkeleton();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 0.1f);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        hero.render(batch);
        hero.renderHealthBar(batch);
        skeleton.render(batch);
        skeleton.renderHealthBar(batch);
        update();
    }

    private void update() {
        hero.checkMove();
        skeleton.moveToEnemyIfCloseEnough(hero);
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
