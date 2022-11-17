package com.xzy.javase.thread.redpackage;

import com.xzy.javase.thread.redpackage.entity.HongBao;

public class demo {
    public static void main(String[] args) {
        HongBao hongBao = new HongBao();
        hongBao.setTotal(10.0);

        UserThread user1 = new UserThread("tom",hongBao);
        UserThread user2 = new UserThread("jack",hongBao);
        UserThread user3 = new UserThread("marry",hongBao);
        UserThread user4 = new UserThread("小明",hongBao);
        UserThread user5 = new UserThread("小王",hongBao);
        UserThread user6 = new UserThread("小美",hongBao);
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
        user6.start();
    }
}
