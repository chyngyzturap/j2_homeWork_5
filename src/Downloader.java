import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Downloader extends Thread{
    private int downFile = 100;
    //private CountDownLatch cdl;
    private Semaphore semaphore;
    //private int userID;

    public Downloader(int downFile, CountDownLatch cdl, Semaphore semaphore) {
        this.downFile = downFile;
        //this.cdl = cdl;
        this.semaphore = semaphore;
        //this.userID = userID;
    }

    public void run (){
        try {
            semaphore.acquire();
            System.out.println("\uD83D\uDCE9 \uD83D\uDEB6");
            sleep(1000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
