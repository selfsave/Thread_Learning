package com.dayuan;

public class SimpleWaitNotify {
   private User user = new User();
   private Object object = new Object();

   public static class waitThread extends Thread{

       private User user;
       public waitThread(User user){
           this.user = user;
       }
       @Override
       public void run() {
           synchronized (user){
               System.out.println(" wait start:"+Thread.currentThread().getName());
               try {
                   user.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(" wait end"+Thread.currentThread().getName()+System.nanoTime());
               System.out.println(" waitThread end"+Thread.currentThread().getName()+System.nanoTime());
           }
       }
   }

   public static class notifyThread extends Thread{
       private User user;
       public notifyThread(User user){
           this.user = user;
       }
       @Override
       public void run() {
           synchronized (user){

               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("notify start:"+Thread.currentThread().getName());
               user.notify();
               System.out.println("notify end:"+Thread.currentThread().getName()+System.nanoTime());
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("notifyThread end"+Thread.currentThread().getName()+System.nanoTime());
           }
       }
   }

    public static void main(String[] args) {
        User user = new User();
        waitThread waitThread = new waitThread(user);
        notifyThread notifyThread = new notifyThread(user);
        waitThread.start();
        notifyThread.start();
    }
}
