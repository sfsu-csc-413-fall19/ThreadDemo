package threadsintro;


public class ThreadsSync {

  public static void main(String[] args) throws InterruptedException{
    MyWorker worker1 = new MyWorker(4000000);
    MyWorker worker2 = new MyWorker(4000000);
    Thread threadA = new Thread(worker1);
    Thread threadB = new Thread(worker2);

    int total = worker1.getCount() + worker2.getCount();
    System.out.println("Pre total now is: " + total);

    threadB.start();
    threadA.start();

    Thread.sleep(1);

    total = worker1.getCount() + worker2.getCount();
    System.out.println("Final total now is: " + total);

  }
}

class MyWorker implements Runnable {

  private int iterations;
  private int counter = 0;

  public MyWorker(int i) {
    this.iterations = i;
  }

  public int getCount() {
    return this.counter;
  }

  public void run() {
    for (int i = 0; i < this.iterations; i++) {
      this.counter++;
    }
    System.out.println("Thread done!");
  }
}