package cn.yipingnai.base.syn;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 8:53
 */
public class UnSafeTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"A").start();
        new Thread(buyTicket,"B").start();
        new Thread(buyTicket,"C").start();
    }
}

class BuyTicket implements Runnable{
    // 票数
    private int ticketNums = 10;
    // 标识停止
    boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            try {
                buy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 买票
    private synchronized void buy() throws Exception {
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        // 延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"买到了"+ticketNums--);
    }
}