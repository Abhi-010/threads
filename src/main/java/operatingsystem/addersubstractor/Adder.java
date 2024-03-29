package operatingsystem.addersubstractor;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{

    private Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
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
    }
}
