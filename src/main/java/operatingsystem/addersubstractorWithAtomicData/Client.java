package operatingsystem.addersubstractorWithAtomicData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);

        executor.shutdown();
        try{
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (Exception e){
            System.out.println("Something happend..");
        }

        System.out.println(count.value);
    }
}
