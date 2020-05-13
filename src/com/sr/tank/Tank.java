package com.sr.tank;

import java.awt.*;

/**
 * @Author admin
 * @date 2020/5/13
 */
public class Tank {
    private int x = 400, y = 400;
    //tank 方向  速度
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void print(Graphics g) {

        g.fillRect(x, y, 50, 50);
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
