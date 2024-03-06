package operatingsystem.addersubstractor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{

    private Count count;
    private Lock lock;

    public Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        lock.lock();
        for(int i = 1 ; i < 1000 ; i++){
            int currentValue = count.getValue();

//            try{
//                executor.awaitTermination(10, TimeUnit.SECONDS);
//            }
//            catch (Exception e){
//                System.out.println("Something happend..");
//            }

            int nextValue = currentValue + i;
            count.setValue(nextValue);
        }
        lock.unlock();
    }
}
