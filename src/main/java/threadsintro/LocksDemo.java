package threadsintro;

import java.util.concurrent.atomic.AtomicInteger;

public class LocksDemo {

  private static AtomicInteger atomicCounter = new AtomicInteger(0);
  private static int basicCounter = 0;
  private static Object lock1 = new Object();
  private static LocksDemo lock2 = new LocksDemo();


  static Runnable lockRunnable = new Runnable(){
    public void run(){
      for(int i = 0; i < 10000; i++){
        //synchronized (lock1){
          LocksDemo.basicCounter++;
          //atomicCounter.incrementAndGet();
       // }
      }
    }
  };

  public static void main(String[] args) throws InterruptedException {
    // Create threads
    Thread thread1 = new Thread(lockRunnable);
    Thread thread2 = new Thread(lockRunnable);
    Thread thread3 = new Thread(lockRunnable);
    Thread thread4 = new Thread(lockRunnable);
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    thread1.join();
    thread2.join();
    thread3.join();
    thread4.join();

    System.out.println(basicCounter);
  }
}