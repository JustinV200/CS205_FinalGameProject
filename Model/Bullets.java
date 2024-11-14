package org.StarWarsFinalProject.Model;
public class Bullets {

    private int x;
    private int y;

    public Bullets(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move(int moveBy){
        this.x+= moveBy;
        this.y+= moveBy;

        //entity.translateX(moveBy) - once fxgl is in place
    }
    //check for collisions
    public boolean checkCollision(){
        //TODO once we figure out fxgl
        return true;
    }
    //TODO: create entity, create hitbox for entitiy, move it.

}