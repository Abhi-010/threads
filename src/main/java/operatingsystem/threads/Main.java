package operatingsystem.threads;

public class Main {
    public static void main(String[] args) {

        PrintHelloWorldWithThreadClass obj = new PrintHelloWorldWithThreadClass();
        System.out.println("in main class with thread : " + Thread.currentThread().getName());
        Thread thread = new Thread(obj);
        thread.start();
        //thread.run();


//        PrintHelloWorld p = new PrintHelloWorld();
//        System.out.println("in main class with thread : " + Thread.currentThread().getName());
//        Thread t = new Thread(p);
//        t.setName("first thread");
//        t.start();
//
//        Thread thread = new Thread(p);
//        thread.setName("second thread");
//
//        thread.start();


    }
}
