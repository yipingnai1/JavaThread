package cn.yipingnai.base.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 9:33
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
