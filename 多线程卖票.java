package com.atguigu.gmall.gmallmqtest.mq;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Aaa {
    public static void main(String[] args)throws Exception {
        Ticket ticket = new Ticket();

     new Thread(()->{for(int i = 1; i<=40;i++) ticket.sale(); } ,"A").start();
     new Thread(()->{for(int i = 1; i<=40;i++) ticket.sale(); } ,"B").start();
     new Thread(()->{for(int i = 1; i<=40;i++) ticket.sale(); } ,"C").start();

    }
}
class Ticket{

    private int number = 30;

    private  Lock lock = new ReentrantLock();

    public void  sale(){
        lock.lock();
        try {
          if (number>0){
              System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
          }
        }finally {
            lock.unlock();
        }
    }



}
