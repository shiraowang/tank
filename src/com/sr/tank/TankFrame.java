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

    int x = 100, y = 100;

    public TankFrame() {
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        System.out.println("test01");
        g.fillRect(x, y, 50, 50);
        //x += 10;
//        x += 100;
//        y += 100;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    x -= 100;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 100;
                    break;
                case KeyEvent.VK_UP:
                    y += 100;
                    break;
                case KeyEvent.VK_DOWN:
                    y -= 100;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
