package concurrenthashmap;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapDemo {
    /**
     * Here multiple threads (total 5) trying to access traditional hashmap and since hashmap is not thread safe
     * hence it is giving inconsistent issue.
     */
    private static final int NUM_THREADS = 5;
    private static final int NUM_INSERTIONS = 100;

    private static HashMap<String,Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for(int i = 0 ; i < NUM_THREADS ; i++){
            executorService.execute(insertRecord());
        }
        if(!executorService.isTerminated()){
            Thread.sleep(1000);
        }
        executorService.shutdown();
        System.out.println("Size of HashMap : " + hashMap.size());
    }

    public static Runnable insertRecord(){
        return () -> {
            for(int i = 0 ; i < NUM_INSERTIONS ; i++){
                hashMap.put(i + Thread.currentThread().getName() , i);
            }
        };
    }

}
