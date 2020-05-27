package com.sr.tank;

import java.awt.*;

/**
 * @Author admin
 * @date 2020/5/13
 */
public class Tank {
    private int x, y;
    //tank 方向  速度
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private TankFrame tf = null;
    public static int WIDTH = ResourcesMge.tankD.getWidth();
    public static int HEIGHT = ResourcesMge.tankD.getHeight();

    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void print(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourcesMge.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourcesMge.tankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourcesMge.tankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourcesMge.tankL, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        tf.bullet = new Bullet(bX, bY, this.dir, tf);
        tf.bulletList.add(tf.bullet);
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
