package org.imperium.game.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.imperium.game.core.gameObject.Hero;
import org.imperium.game.core.gameObject.ObjectsProvider;
import org.imperium.game.core.gameObject.Skeleton;
import org.imperium.game.core.map.MapProvider;
import org.imperium.game.core.map.MapRenderer;

public class HeroGame extends ApplicationAdapter {

    private final MapProvider mapProvider = new MapProvider();
    private ObjectsProvider objectsProvider;
    private MapRenderer mapRenderer;
    private SpriteBatch batch;
    private Skeleton skeleton;
    private Hero hero;

    @Override
    public void create() {
        mapProvider.provideWorldMap();
        mapRenderer = new MapRenderer();
        objectsProvider = new ObjectsProvider(mapProvider);
        batch = new SpriteBatch();
        hero = objectsProvider.getHero();
        skeleton = objectsProvider.getSkeleton();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 0.1f);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.begin();
        mapRenderer.renderMap(mapProvider.provideWorldMap(), batch);
        update();
        hero.render(batch);
        skeleton.render(batch);
        batch.end();
    }

    private void update() {
        hero.checkMove();
        if(hero.ifScreenBorderCrossedOver()){
            System.out.println("Cross screen");
            mapProvider.updateWorldMap();
            hero.getPosition().set(200, 200);
            hero.getCenter().set(200 + hero.getSize().x, 200 + hero.getSize().y);
        }
    }

    @Override
    public void dispose() {
        hero.dispose();
        skeleton.dispose();
        batch.dispose();
    }
}