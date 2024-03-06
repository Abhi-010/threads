package operatingsystem.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0 ; i < 100 ; i++){
            if (i == 4 || i == 8 || i == 15 || i == 50) {
                System.out.println("Wait");
            }
            PrintNumber printNumber = new PrintNumber(i);
            executor.execute(printNumber);
        }
    }
}
