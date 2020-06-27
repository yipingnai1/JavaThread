package cn.yipingnai.base.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 9:12
 */
public class UnsafaList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            // 确保线程结束后才打印
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
