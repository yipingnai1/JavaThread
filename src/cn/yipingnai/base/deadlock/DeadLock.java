package cn.yipingnai.base.deadlock;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 9:42
 */
// 死锁 互相占有资源不释放
public class DeadLock {
    public static void main(String[] args) {
        Eat a = new Eat(0, "A");
        Eat b = new Eat(1, "B");
        a.start();
        b.start();
    }
}
// 筷子
class Chopsticks{

}
// 碗
class Bowl{

}

// 吃饭
class Eat extends Thread{

    // 一双筷子
    static Chopsticks chopsticks = new Chopsticks();
    // 一个碗
    static Bowl bowl = new Bowl();

    // 编号
    int num;
    // 姓名
    String name;

    public Eat (int num, String name){
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        // 吃饭
        try {
            eating();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eating() throws InterruptedException {
        if(num == 0){
            // 先拿筷子
            synchronized (chopsticks){
                System.out.println(this.name +"拿到了筷子");
                Thread.sleep(1000);
                // 拿碗
                synchronized (bowl){
                    System.out.println(this.name + "拿到了碗");
                }
            }
        }else {
            // 先拿碗
            synchronized (bowl){
                System.out.println(this.name + "拿到了碗");
                Thread.sleep(2000);
                // 拿筷子
                synchronized (chopsticks) {
                    System.out.println(this.name + "拿到了筷子");
                }
            }
        }
    }
}
