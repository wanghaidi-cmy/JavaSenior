package com.whd.domain;

import com.whd.pojo.Ticket;

/**
 * @ClassName TicketTest
 * @Author WangHaiDi
 * @Date 2022年02月18日 22:24
 * @description 多线程测试卖票
 * @Version 1.0
 */
public class TicketTest {
    public static void main(String[] args) {
        //创建Ticket对象
        Ticket ticket = new Ticket();
        //创建线程传入ticket对象
        Thread t1 = new Thread(ticket);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(ticket);
        t2.setName("窗口2");
        t2.start();
    }
}
