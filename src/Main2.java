import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main2 {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch cdl = new CountDownLatch(10);

        for (int i = 1; i <26; i++) {
            new Uploader(i, semaphore, cdl).start();
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nФайл загружен на сервер и готов к скачиванию");
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 10; i++) {
            new Downloader(i, cdl,semaphore).start();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Файл скачали 10 юзеров");


        System.out.println("Файл удален с сервера");
    }
}
