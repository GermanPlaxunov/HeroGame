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
import org.imperium.game.core.gameObject.fight.FightStats;

public class HeroGame extends ApplicationAdapter {

    private ObjectsProvider provider;
    private SpriteBatch batch;

    @Override
    public void create() {
        provider = new ObjectsProvider();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 0.1f);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        provider.getHero().render(batch);
        provider.getHero().renderHealthBar(batch);
        provider.getSkeleton().render(batch);
        provider.getSkeleton().renderHealthBar(batch);
        update();
    }

    private void update() {
        provider.getHero().checkMove();
        if (provider.getHero().checkDistance(provider.getSkeleton())) {
            if (provider.getHero().isAlive()) {
                provider.getHero().attack(provider.getSkeleton());
            }
            if (provider.getSkeleton().isAlive()) {
                provider.getSkeleton().attack(provider.getHero());
            }
        }
    }

    @Override
    public void dispose() {
        provider.getHero().dispose();
        batch.dispose();
    }
}
