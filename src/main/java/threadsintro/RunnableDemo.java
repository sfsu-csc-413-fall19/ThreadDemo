package threadsintro;

public class RunnableDemo implements Runnable {

  private final char charToPrint;  // The character to print
  private final int times;  // The times to repeat

  public RunnableDemo(char c, int t) {
    super();
    charToPrint = c;
    times = t;
  }

  // Main method
  public static void main(String[] args) {
    // Create threads
    RunnableDemo runnableDemo = new RunnableDemo('a', 200);
    RunnableDemo runnableDemoB = new RunnableDemo('b', 200);
    Thread printA = new Thread(runnableDemo);
    Thread printB = new Thread(runnableDemoB);

    printA.start();
    printB.start();


  }

  public int something(int a, String r){
    return 0;
  }
  public void run() {
    for (int i = 1; i < times; i++) {
      System.out.print(charToPrint);
    }
  }
}