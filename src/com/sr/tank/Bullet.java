package com.sr.tank;

import java.awt.*;

/**
 * 子弹类
 *
 * @Author admin
 * @date 2020/5/13
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x, y;
    private Dir dir;
    TankFrame tf = null;
    public static int WIDTH = ResourcesMge.bulletD.getWidth();
    public static int HEIGHT = ResourcesMge.bulletD.getHeight();

    private boolean live = true;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void print(Graphics g) {
        if (!live) {
            tf.bulletList.remove(this);
        }
        switch (dir) {
            case UP:
                g.drawImage(ResourcesMge.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourcesMge.bulletD,  x, y,  null);
                break;
            case RIGHT:
                g.drawImage(ResourcesMge.bulletR,  x, y,  null);
                break;
            case LEFT:
                g.drawImage(ResourcesMge.bulletL,  x, y, null);
                break;
            default:
                break;
        }
        move();


    }


    private void move() {
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

        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

}
