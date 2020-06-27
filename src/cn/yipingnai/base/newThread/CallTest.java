package cn.yipingnai.base.newThread;

import java.util.concurrent.*;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 13:43
 */

/**
 * 第三种方式：定义一个类实现Callable接口，重写call()方法，有返回值
 *            创建Callable实现类，开启一个服务
 *            提交执行
 *            关闭服务
 */
public class CallTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int count = 0;
        for(int i = 0;i < 100;i++)
            count += i;
        return count;
    }

    public static void main(String[] args) throws Exception {
        CallTest callTest = new CallTest();
        // 创建服务
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 提交执行
        Future submit = executorService.submit(callTest);
        // 获取结果
        Integer o = (Integer) submit.get();
        System.out.println(o);
        // 关闭服务
        executorService.shutdown();
    }
}
