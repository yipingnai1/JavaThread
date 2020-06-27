package cn.yipingnai.base.syn;

/**
 * @Author: 一瓶奶
 * @Url: www.yipingnai.cn
 * @Date: 2020/6/27 9:02
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100, "工资");
        Drawing a = new Drawing(account, 50, "A");
        Drawing b = new Drawing(account, 100, "B");
        a.start();
        b.start();
    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;

    public  Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        // 锁的对象应该是变化的量，这里是账户  账户修改
        synchronized (account){
            // 判断是否有钱
            if(account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            // 卡内余额
            account.money -= drawingMoney;

            // 手里的钱
            nowMoney += drawingMoney;

            System.out.println(account.name+"余额：" +account.money);
            System.out.println(this.getName()+"手里的钱" + nowMoney);
        }
    }
}