package com.dayuan;

public class TheadTest {

    public static void main(String[] args)throws Exception {
            Thread ti = new Thread(){
                @Override
                public void run() {
                    while (true){
                        if(Thread.currentThread().isInterrupted()){
                            System.out.println("线程中断");
                            break;
                        }
                        System.out.println("thread_name:"+Thread.currentThread().getName());
                        Thread.yield();
                    }

                }
            };

            ti.start();
            Thread.sleep(1000);
            ti.interrupt();
    }
}
