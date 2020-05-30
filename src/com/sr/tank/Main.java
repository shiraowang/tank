package com.sr.tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        Integer badTanks = Integer.valueOf(PropertyMgr.getProperties("badtanks").toString());
        for (int i = 0; i < badTanks; i++) {
            tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf, 2, true));
        }

        //new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }

    }

}
