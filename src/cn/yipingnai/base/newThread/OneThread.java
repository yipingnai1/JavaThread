package cn.yipingnai.base.newThread;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 13:28
 */
/**
 * 第一种方式：定义类继承Thread类，重写run()方法
 *
 */

public class OneThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i < 10;i++)
            System.out.println(i);
    }

    // 主线程
    public static void main(String[] args) {
        // 开启自定义线程
        new OneThread().start();
    }

}
