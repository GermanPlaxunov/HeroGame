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
    protected final Vector2 center;

    public DrawableObject(Texture texture, Vector2 position, Vector2 size){
        this.texture = texture;
        this.position = position;
        this.size = size;
        this.center = new Vector2(position.x + size.x/2, position.y + size.y/2);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, size.x, size.y);
    }

    @Override
    public void dispose(){
        texture.dispose();
    }
}
