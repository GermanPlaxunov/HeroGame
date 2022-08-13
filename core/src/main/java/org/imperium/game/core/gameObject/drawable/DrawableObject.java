package org.imperium.game.core.gameObject.drawable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;

@Getter
public class DrawableObject implements Drawable{

    protected final Texture texture;
    protected final Vector2 position;
    protected final Vector2 size;

    public DrawableObject(Texture texture, Vector2 position, Vector2 size){
        this.texture = texture;
        this.position = position;
        this.size = size;

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(texture, position.x, position.y, size.x, size.y);
        batch.end();
    }

    @Override
    public void dispose(){
        texture.dispose();
    }
}
