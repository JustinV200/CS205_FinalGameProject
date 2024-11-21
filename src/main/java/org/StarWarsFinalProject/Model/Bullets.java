package org.StarWarsFinalProject.Model;

import com.almasb.fxgl.entity.Entity;


public class Bullets {
    private Entity bulletEntity;


    public Bullets(Entity bulletEntity) {
        this.bulletEntity = bulletEntity;
    }


    public void move(int moveBy) {
        bulletEntity.translateX(moveBy);
    }


    public boolean checkCollision(Entity target) {
        return bulletEntity.isColliding(target);
    }


    public Entity getEntity() {
        return bulletEntity;
    }
}
