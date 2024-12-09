package org.StarWarsFinalProject.Controller;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.StarWarsFinalProject.EntityType;
import org.StarWarsFinalProject.Model.Character;

/**
 * the playerOpponentCollisionHandler class which handles the collision
 * between the player entity and the opponent entity
 */
public class PlayerOpponentCollisionHandler extends CollisionHandler {

    /**the user's character class*/
    private Character user;
    /** the opponent's character class*/
    private Character opp;

    /**
     * the initializer for the PlayerOpponentCollisionHandler
     * which extends the CollisionHandler class included in
     * JAVA FXGL
     *
     * @param user the user's character class
     * @param opp the opponent's character class
     */
    public PlayerOpponentCollisionHandler(Character user, Character opp) {
        super(EntityType.PLAYER, EntityType.OPPONENT);
        this.user = user;
        this.opp = opp;
    }

    @Override
    protected void onCollision(Entity player, Entity opponent) {
        // Print a statement when a collision is detected
        if (opponent.getX() - player.getX() < 0) {
            user.setX(player.getX() + 5);
            opp.setX(opponent.getX() - 5);
        }
        else if (opponent.getX() - player.getX() > 0) {
            user.setX(player.getX() - 5);
            opp.setX(opponent.getX() + 5);

        }
        /* Y should be unnecessary
        if (opponent.getY() - player.getY() < 0) {
            user.character.setY(player.getY() + 5);
            opp.character.setY(opponent.getY() - 5);

        }
        else if (opponent.getY() - player.getY() >= 0) {
            user.character.setY(player.getY() - 5);
            opp.character.setY(opponent.getY() + 5);
        }
         */
    }
}
