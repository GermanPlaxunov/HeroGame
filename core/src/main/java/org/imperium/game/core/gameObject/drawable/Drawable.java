package org.imperium.game.core.gameObject.drawable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Drawable {
    void render(SpriteBatch batch);
    void dispose();
}
