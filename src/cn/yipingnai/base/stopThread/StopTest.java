package cn.yipingnai.base.stopThread;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 14:21
 */
// 停止线程方式：
// 1.线程正常停止
// 2.标志位停止
public class StopTest implements Runnable {

    // 标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag)
            System.out.println(i++);
    }

    public void stop() {
        this.flag = false;
        System.out.println(Thread.currentThread().getName()+"线程停止了");
    }
    public static void main(String[] args) {
        StopTest stopTest = new StopTest();
        new Thread(stopTest).start();
        for(int i = 0;i < 10000000;i++)
            if(i == 900000){
                // 调用方法改变标志位，停止线程
                stopTest.stop();
            }
    }
}
