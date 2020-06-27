package cn.yipingnai.base.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 10:21
 */
public class TestLock {

    public static void main(String[] args) {
        Tocket target = new Tocket();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(target).start();
    }
}

class Tocket implements Runnable {
    // 票数
    int ticketNum = 10;

    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 加锁
                lock.lock();
                if (ticketNum > 0) {
                    Thread.sleep(100);
                    System.out.println(ticketNum--);
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}
