package com.sr.tank;

import java.awt.*;

/**
 * @Author admin
 * @date 2020/5/13
 */
public class Tank {
    private int x , y;
    //tank 方向  速度
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private TankFrame tf = null;

    private boolean moving = false;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void print(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.green);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
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
       tf.bullet = new Bullet(this.x,this.y,this.dir,tf);
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
