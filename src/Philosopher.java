import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {

    public int number;
    public Fork leftFork;
    public Fork rightFork;

    Philosopher(int num, Fork left, Fork right) {
      number = num;
      leftFork = left;
      rightFork = right;
    }

    public void run(){
      System.out.println("Oi! Eu sou filósofo: " + number);

      while (true) {
        leftFork.grab();
        System.out.println("Filósofo #" + number + " agarra garfo esquerdo.");
        rightFork.grab();
        System.out.println("Filósofo #" + number + " agarra garfo direto.");
        eat();
        leftFork.release();
        System.out.println("Filósofo #" + number + " libera garfo esquerdo.");
        rightFork.release();
        System.out.println("Filósofo #" + number + " libera garfo direto.");
      }
    }

    void eat() {
      try {
        int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Filósofo #" + number + " come em " + sleepTime);
        Thread.sleep(sleepTime);
      }
      catch (Exception e) {
        e.printStackTrace(System.out);
      }
    }

  }