package cn.yipingnai.base.communication;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 13:52
 */
// 生产者消费者 信号灯处理
public class LightDemo {

    public static void main(String[] args) {
        TV tv = new TV();
        new Actor(tv).start();
        new Audience(tv).start();
    }
}

// 生产者 演员
class Actor extends Thread{
    TV tv;
    public Actor(TV tv){
        this.tv = tv;
    }

    // 表演节目

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 == 0){
                this.tv.play("向往的生活");
            }else {
                this.tv.play("局中人");
            }
        }
    }
}

// 消费者 观众
class Audience extends Thread{
    TV tv;
    public Audience(TV tv){
        this.tv = tv;
    }
    // 观看节目
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

// 产品 TV
class  TV{
    // 节目
    String voice;
    // 标记 true 表演   false 观看
    boolean flag = true;

    // 表演
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 表演
        System.out.println("表演了" +voice);
        // 通知观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    // 观看节目
    public synchronized void watch(){
        if(flag){
            // 没有节目就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 观看节目
        System.out.println("观看了节目：" + this.voice);
        // 通知表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}