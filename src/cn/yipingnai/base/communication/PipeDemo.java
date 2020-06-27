package cn.yipingnai.base.communication;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 13:00
 */
// 生产者消费者 ：管道实现  缓冲池
public class PipeDemo {

    public static void main(String[] args) {
        Pool pool = new Pool();
        new Product(pool).start();
        new Consumer(pool).start();
    }
}

// 产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}
// 生产者
class Product extends Thread{
    // 生产产品放入池
    Pool pool;

    public Product(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                pool.push(new Chicken(i));
                System.out.println("生产了第" + i + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 消费者
class Consumer extends Thread{
    Pool pool;
    public Consumer(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("消费了第" + pool.pop().id + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 缓存池
class Pool{
    // 提供存放产品的容器大小
    Chicken[] chickens = new Chicken[5];

    // 容器计数器 计算容器内产品个数
    int count = 0;

    // 生产者生产产品  将产品放入容器
    public synchronized void push(Chicken chicken) throws InterruptedException {
        // 先判断容器是否满。满了就等待消费者消费
        if(count == chickens.length){
                this.wait();
        }
        // 没满就生产
        this.chickens[count] = chicken;
        count++;
        // 通知消费
        this.notifyAll();
    }
    // 消费者消费产品 从容器获取产品消费
    public synchronized Chicken pop() throws InterruptedException {
        // 判断是否有产品消费， 没有就等待
        if(count == 0){
            this.wait();
        }
        // 有产品直接消费
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return  chicken;
    }
}
