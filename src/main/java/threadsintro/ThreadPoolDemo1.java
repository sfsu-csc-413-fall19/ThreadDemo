package threadsintro;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1{

  public static void main(String[] args) {
    ThreadPoolDemo1 threadPoolDemo1 = new ThreadPoolDemo1();
    Scanner reader = new Scanner(System.in);
    String text = "";

    ExecutorService executorService1 = Executors.newSingleThreadExecutor();

    ExecutorService executorService2 = Executors.newFixedThreadPool(10);

    ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

    while(!text.equals("exit")){
        text =reader.nextLine();
        //executorService2.submit(new Handler(text));
        new Handler(text).run();
    }
  }
}

class Handler implements Runnable{
  String text;
  public Handler(String t){
    this.text = t;
  }
  public void run(){
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.text);
  }
}