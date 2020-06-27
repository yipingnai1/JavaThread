package cn.yipingnai.base.joinThread;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 14:48
 */
public class JoinTest implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println("我来插队了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinTest());
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程" + i);
            if(i == 500){
                thread.join();
            }
        }
    }
}
