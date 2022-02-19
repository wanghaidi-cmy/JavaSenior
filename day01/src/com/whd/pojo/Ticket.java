package com.whd.pojo;

/**
 * 例子：创建两个窗口卖票，总票数为100，实现Runnable接口的方式
 * 1.问题：出现重票，错票 --->出现了线程安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，操作车票导致。
 * 3.如何解决：当一个线程a操作ticket时其他线程不可以进行操作，知道线程a操作结束，才可以操作，即使线程a出现阻塞也要等待其操作结束
 * 4.在Java中，可以通过同步机制解决线程安全问题
 * 一、同步代码块
 *     synchronized(同步监视器){
 *     //需要被同步的代码
 *     }
 *     说明：操作共享数据的代码，即为需要被同步的代码
 *     共享数据：多个线程共同操作的变量
 *     同步监视器：俗称 锁 任何一个类的对象，都可以充当锁
 *       要求：多个线程必须共用同一把锁
 *
 * 二、同步方法
 * 卖票实体类
 * @ClassName Ticket
 * @Author WangHaiDi
 * @Date 2022年02月18日 22:20
 * @description 卖票类
 * @Version 1.0
 */
public class Ticket implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + "卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
