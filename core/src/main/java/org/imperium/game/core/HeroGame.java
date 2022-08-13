package org.imperium.game.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class HeroGame extends ApplicationAdapter {

	Texture hero;
	Texture skeleton;

	SpriteBatch batch;
	float elapsed;

	@Override
	public void create () {
		hero = new Texture(Gdx.files.internal("assets/hero.png"));
		skeleton = new Texture(Gdx.files.internal("assets/skeleton.png"));
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		elapsed += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 0.1f);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(hero, 100, 100, 70, 90);
		batch.draw(skeleton, 300, 300, 70, 90);
		batch.end();
	}

	@Override
	public void dispose () {
		hero.dispose();
		skeleton.dispose();
		batch.dispose();
	}
}
