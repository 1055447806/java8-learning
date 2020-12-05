package com.ohh.java8.lambda;

import org.junit.Test;

/**
 * 使用 lambda 表达式创建线程
 *
 * @author Gary
 */
public class HowToCreateThread {

    /**
     * 使用匿名内部类的方式
     */
    @Test
    public void createThreadWithAnonymousInnerClass() throws InterruptedException {
        @SuppressWarnings({"Convert2Lambda", "AlibabaAvoidManuallyCreateThread"})
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
        thread.join();
    }

    /**
     * 使用 lambda 表达式
     */
    @Test
    public void createThreadWithLambda() throws InterruptedException {
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.start();
        thread.join();
    }
}
