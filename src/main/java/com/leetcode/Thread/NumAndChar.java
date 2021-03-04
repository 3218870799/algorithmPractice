package com.leetcode.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class NumAndChar {
    //可以保证先让线程1执行
    public void NumAndByCondition(){
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        //相当于t1的等待队列
        Condition conditionT1 = lock.newCondition();
        //相当于t2的等待队列
        Condition conditionT2 = lock.newCondition();

        new Thread(()->{
            //尝试获取锁
            lock.lock();
            try {
                //doSomeThing();
                conditionT2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t1").start();

        new Thread(()->{
            lock.lock();
            try {
                //doSomeThing();
                conditionT1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t2").start();
    }





    //可以保证先让线程1执行
    public void NumAndByCountDown(){
        //相当于栓门栓，栓了一个门栓
        CountDownLatch latch = new CountDownLatch(1);
        //显示定义一把锁
        final Object o = new Object();
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        new Thread(()->{

            try {
                //等待latch为0
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //加锁
            synchronized (o) {
                for (char c : num){
                    System.out.print(c);
                    try {
                        //叫醒等待队列里的线程，让出锁
                        o.notify();
                        //自己阻塞
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //必须，否则无法停止程序
                o.notify();
            }
        },"t1").start();

        new Thread(()->{

            //加锁
            synchronized (o) {
                for (char c : ac){
                    System.out.print(c);
                    //计数减1
                    latch.countDown();
                    try {
                        //叫醒等待队列里的线程，让出锁
                        o.notify();
                        //自己阻塞
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //必须，否则无法停止程序
                o.notify();
            }
        },"t2").start();
    }

    public void NumAndBySyncWaitNotify(){
        //显示定义一把锁
        final Object o = new Object();
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        new Thread(()->{
            //加锁
            synchronized (o) {
                for (char c : num){
                    System.out.print(c);
                    try {
                        //叫醒等待队列里的线程，让出锁
                        o.notify();
                        //自己阻塞
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //必须，否则无法停止程序
                o.notify();
            }
        },"t1").start();

        new Thread(()->{
            //加锁
            synchronized (o) {
                for (char c : ac){
                    System.out.print(c);
                    try {
                        //叫醒等待队列里的线程，让出锁
                        o.notify();
                        //自己阻塞
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //必须，否则无法停止程序
                o.notify();
            }
        },"t2").start();
    }



    public  void NumAndCharByLockSupport() {
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        t1 = new Thread(()->{
            for (char c : num ){
                System.out.println(c);
                //叫醒t2
                LockSupport.unpark(t2);
                //T1阻塞 当前线程阻塞
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(()->{
            for (char c : ac ){
                //t2阻塞
                LockSupport.park();
                System.out.println(c);
                //叫醒t2
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
