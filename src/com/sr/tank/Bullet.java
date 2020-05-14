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
    private static final int WITED = 10, HEIGHT = 10;
    TankFrame tf = null;

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
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WITED, HEIGHT);
        g.setColor(c);
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
