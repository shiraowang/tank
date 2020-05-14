package com.sr.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author admin
 * @date 2020/5/13
 */
public class TankFrame extends Frame {

//    int x = 400, y = 400;
//    //tank 方向  速度
//    Dir dir = Dir.DOWN;
//    private static final int SPEED = 10;

    Tank myTank = new Tank(100, 100, Dir.DOWN);
    Bullet bullet = new Bullet(20, 20, Dir.DOWN);
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        myTank.print(g);
        bullet.print(g);
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            serMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            serMainTankDir();
        }

        private void serMainTankDir() {
            if (!bD && !bR && !bU && !bL) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bD) {
                    myTank.setDir(Dir.DOWN);
                }
                if (bR) {
                    myTank.setDir(Dir.RIGHT);
                }
                if (bU) {
                    myTank.setDir(Dir.UP);
                }
                if (bL) {
                    myTank.setDir(Dir.LEFT);
                }
            }


        }
    }
}
