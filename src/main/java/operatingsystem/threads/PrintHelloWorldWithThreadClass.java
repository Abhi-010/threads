package operatingsystem.threads;

public class PrintHelloWorldWithThreadClass extends Thread{


    @Override
    public void run() {
        System.out.println("in thread class with thread : " + Thread.currentThread().getName());
        System.out.println("Printing hello word from Thread class");
    }
}
