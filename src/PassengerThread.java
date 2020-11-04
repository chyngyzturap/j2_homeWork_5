import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class PassengerThread extends Thread{
    private int id;
    private Semaphore semaphore;
    private CountDownLatch cdl;

    public PassengerThread(int id, Semaphore semaphore, CountDownLatch cdl) {
        this.id = id;
        this.semaphore = semaphore;
        this.cdl = cdl;
    }

    public void run (){
        try{
            semaphore.acquire();
            System.out.println("Пассажир " + id + " покупает билет на кассе");
            sleep (1000);
            System.out.println("Пассажир " + id+ " купил билет и вышел из кассы");
            semaphore.release();
            cdl.countDown();
            cdl.await();
        } catch (Exception e) {

        }
    }
}
