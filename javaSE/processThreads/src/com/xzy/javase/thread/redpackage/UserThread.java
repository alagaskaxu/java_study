package com.xzy.javase.thread.redpackage;

import com.xzy.javase.thread.redpackage.entity.HongBao;

import java.text.DecimalFormat;

/**
 * 用户线程
 */
public class UserThread extends Thread{
    /**
     * 红包总数
     */
    private HongBao hongBao;

    public UserThread() {
    }

    public UserThread(HongBao hongBao) {
        this.hongBao = hongBao;
    }

    public UserThread(Runnable target, HongBao hongBao) {
        super(target);
        this.hongBao = hongBao;
    }

    public UserThread(ThreadGroup group, Runnable target, HongBao hongBao) {
        super(group, target);
        this.hongBao = hongBao;
    }

    public UserThread(String name, HongBao hongBao) {
        super(name);
        this.hongBao = hongBao;
    }

    public UserThread(ThreadGroup group, String name, HongBao hongBao) {
        super(group, name);
        this.hongBao = hongBao;
    }

    public UserThread(Runnable target, String name, HongBao hongBao) {
        super(target, name);
        this.hongBao = hongBao;
    }

    public HongBao getHongBao() {
        return hongBao;
    }

    public void setHongBao(HongBao hongBao) {
        this.hongBao = hongBao;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (hongBao){
            if (null == hongBao)
            {
                System.out.println("红包不存在");
                return;
            }
            //从红包抢钱,同步方法
            Double money = hongBao.getMoney();
            //DecimalFormat decimalFormat = new DecimalFormat("0.00");
            //String moneyStr = decimalFormat.format(money);
            if (0.0 == money)
            {
                System.out.println(name+",未抢到红包!");
            }else{
                System.out.println(name+"用户抢到["+money+"]元");
            }
        }
    }
}
