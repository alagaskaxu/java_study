package com.xzy.javase.thread.redpackage.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 红包
 */
public class HongBao {
    /**
     * 红包总钱数
     */
    private Double total;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 得到一份钱的同步方法
     * @return
     */
    public synchronized Double getMoney(){
        if (0.0 == total){
            return 0.0;
        }
        Random rd = new Random();
        Double money = rd.nextDouble()*total;
        BigDecimal bigDecimal = new BigDecimal(money);
        //四舍五入,保留两位
        BigDecimal bigMoney = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        //转double,再自动装箱
        money = bigMoney.doubleValue();
        total = total - money;  //剩余的钱total
        return money;
    }
}
