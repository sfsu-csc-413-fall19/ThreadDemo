package threadsintro;

public class SynchronisedDemo {

  static int counter = 0;

  public static void main(String[] args)  {
    Thread threadA = new Thread(new Worker());
    Thread threadB = new Thread(new Worker());

    threadA.start();
    threadB.start();

    try {
      threadA.join();
      threadB.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    System.out.println(counter);
  }
  // SynchronisedDemo.class
  public synchronized static void increment() {
    SynchronisedDemo.counter++;
  }
}

class Worker implements Runnable {

  public void run() {
    for (int i = 0; i < 2000000; i++) {
      SynchronisedDemo.increment();
    }
  }
}