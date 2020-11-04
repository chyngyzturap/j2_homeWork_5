import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4, true);
        CountDownLatch cdl = new CountDownLatch(100);

        for (int i = 1; i < 101; i++) {
            new PassengerThread(i, semaphore, cdl).start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Автобус полон и направляется в Токио");

    }
    }

