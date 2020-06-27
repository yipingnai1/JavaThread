package cn.yipingnai.base.sleepThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/26 14:33
 */
// 每秒打印时间
public class SleepTest {
    public void tenDown() throws InterruptedException {

        while (true){
            // 打印时间
            System.out.println(new SimpleDateFormat("mm:ss").format(new Date()));
            // 休眠1秒
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new SleepTest().tenDown();
    }
}
