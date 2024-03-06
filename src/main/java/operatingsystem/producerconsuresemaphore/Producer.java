package operatingsystem.producerconsuresemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store ;
    private int maxSizeOfStore;
    private String name;
    private Semaphore semaphoreforProducer;
    private Semaphore semaphoreforConsumer;

    public Producer(Queue<Shirt> store, int maxSizeOfStore, String name,Semaphore semaphoreforProducer, Semaphore semaphoreforConsumer) {
        this.store = store;
        this.maxSizeOfStore = maxSizeOfStore;
        this.name = name;
        this.semaphoreforProducer = semaphoreforProducer;
        this.semaphoreforConsumer = semaphoreforConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphoreforProducer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (store.size() < maxSizeOfStore) {
                    store.add(new Shirt());
                    System.out.println(name + " produced. Left shirts count = " + store.size());
                }
            semaphoreforConsumer.release();
            }
    }
}

