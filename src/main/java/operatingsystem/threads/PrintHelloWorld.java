package operatingsystem.threads;

public class PrintHelloWorld implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World from Thread : " + Thread.currentThread().getName());
    }
}
