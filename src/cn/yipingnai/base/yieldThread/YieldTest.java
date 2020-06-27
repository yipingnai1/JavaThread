package cn.yipingnai.base.yieldThread;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 14:44
 */
public class YieldTest implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        // 礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止");
    }

    public static void main(String[] args) {
        new Thread(new YieldTest(),"A").start();
        new Thread(new YieldTest(),"B").start();

    }
}

