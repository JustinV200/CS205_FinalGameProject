package org.StarWarsFinalProject.Controller;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.Model.Character;
import org.StarWarsFinalProject.View.CharacterView;

public class playerOpponentCollisionHandler extends CollisionHandler {

    private  CharacterView user;

    public playerOpponentCollisionHandler(CharacterView user) {
        super(EntityType.PLAYER, EntityType.OPPONENT);
        this.user = user;
    }

    @Override
    protected void onCollision(Entity player, Entity opponent) {
        // Print a statement when a collision is detected
        if(opponent.getX() - player.getX() < 0) {
            user.character.setX(player.getX()+5);
        }
        else if(opponent.getX() - player.getX() > 0) {
            user.character.setX(player.getX()-5);
        }
        if(opponent.getY() - player.getY() < 0) {
            user.character.setY(player.getY()+5);
        }
        else if(opponent.getY() - player.getY() > 0) {
            user.character.setY(player.getY()-5);
        }

    }
}
