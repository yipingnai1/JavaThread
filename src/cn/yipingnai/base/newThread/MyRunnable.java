package cn.yipingnai.base.newThread;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 13:35
 */
/**
 * 第二种方式：定义类实现Runnable接口，实现run方法
 *          创建自定义Runnable实现类，开启线程
 */

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i < 100;i++)
            System.out.println(Thread.currentThread().getName() + "-" + i);
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        // 第二个参数是给线程命名，不赋值则默认
        new Thread(myRunnable,"myRunnable").start();
    }
}
