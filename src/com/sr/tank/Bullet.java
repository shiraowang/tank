package com.sr.tank;

import java.awt.*;

/**
 * 子弹类
 * @Author admin
 * @date 2020/5/13
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private Dir dir;
    private static final int WITED=5,HEIGHT=5;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void print(Graphics g) {
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
    }

}
