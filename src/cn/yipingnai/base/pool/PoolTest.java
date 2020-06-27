package cn.yipingnai.base.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 14:20
 */
public class PoolTest {
    public static void main(String[] args) {

        // 创建服务，创建线程池    参数代表线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 执行线程
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        service.execute(new MyRunnable());
        // 关闭连接
        service.shutdown();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
