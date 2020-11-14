package com.xqc.function;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadCreate {
	public static void main(String[] args) {
		
		
		
		myExtendsThread myT = new myExtendsThread();
		myT.start();

		
		
		Runnable implRunnable = new ImplRunnableThread();
		new Thread(implRunnable).start();
		
		
		Callable implCallable = new ImplCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(implCallable);
        new Thread(futureTask).start();
        
        //使用Executors工具类中的方法创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo demo = new ThreadPoolDemo();
        //为线程池中的线程分配任务,使用submit方法，传入的参数可以是Runnable的实现类，也可以是Callable的实现类
        pool.submit(demo);
        //关闭线程池
        //shutdown ： 以一种平和的方式关闭线程池，在关闭线程池之前，会等待线程池中的所有的任务都结束，不在接受新任务
        //shutdownNow ： 立即关闭线程池
        pool.shutdown();
		
		
		
		Thread t = new  Thread(()->{
			System.out.println("lambal"+Thread.currentThread().getName());
		});
		t.start();
		
		
		System.out.println("main"+Thread.currentThread().getName());

	}

}
class myExtendsThread extends Thread{
	@Override
	public void run() {
		
		System.out.println("myExtendsThread"+Thread.currentThread().getName());
	}
}

class ImplRunnableThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ImplRunnableThread"+Thread.currentThread().getName());
	}
	
}

class ImplCallable implements Callable{

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return null;
	}
	
}

class ThreadPoolDemo implements Runnable{

    /**多线程的共享数据*/
    private int i = 0;

    @Override
    public void run() {
       System.out.println(Thread.currentThread().getName()+"---");
    }
}
