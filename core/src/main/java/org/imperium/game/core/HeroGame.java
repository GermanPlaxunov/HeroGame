package org.imperium.game.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.imperium.game.core.gameObject.Hero;

public class HeroGame extends ApplicationAdapter {

	SpriteBatch batch;
	Hero hero;

	@Override
	public void create () {
		hero = new Hero(new Texture(Gdx.files.internal("assets/hero.png")), new Vector2(100, 100), new Vector2(70, 90), 150);
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.2f, 1.0f, 0.2f, 0.1f);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		hero.render(batch);
		update();
	}

	private void update(){
		hero.checkMove();
	}

	@Override
	public void dispose () {
		hero.dispose();
		batch.dispose();
	}
}
