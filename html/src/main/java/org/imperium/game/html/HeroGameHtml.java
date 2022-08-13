package org.imperium.game.html;

import org.imperium.game.core.HeroGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class HeroGameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new HeroGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
