import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Uploader extends Thread{
    private int upFile = 20;
    //private Semaphore semaphore;
    private CountDownLatch cdl;

    public Uploader(int upFile, Semaphore semaphore, CountDownLatch cdl) {
        this.upFile = upFile;
        //this.semaphore = semaphore;
        this.cdl = cdl;
    }

    public void run(){
        try{
            //semaphore.acquire();
            System.out.print("\uD83D\uDFE9");
            sleep(1000);
            //semaphore.release();
            cdl.countDown();
            cdl.await();

        } catch (Exception e) {

        }
    }
}
