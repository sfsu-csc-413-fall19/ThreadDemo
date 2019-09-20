package threadsintro;

public class ThreadDemo extends Thread {

  private final char charToPrint;  // The character to print
  private final int times;  // The times to repeat

  public ThreadDemo(char c, int t) {
    super();
    charToPrint = c;
    times = t;
  }

  // Main method
  public static void main(String[] args) {
    // Create threads
    ThreadDemo printA = new ThreadDemo('a', 200);
    ThreadDemo printB = new ThreadDemo('b', 200);
    printB.start();
    try {
      printA.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    printA.start();
  }

  /**
   * This is the method our thread runs.
   */
  @Override
  public void run() {
    for (int i = 1; i < times; i++) {
      System.out.print(charToPrint);
    }
  }
}