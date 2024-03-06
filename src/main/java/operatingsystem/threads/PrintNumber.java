package operatingsystem.threads;

public class PrintNumber implements Runnable {
    private int i ;
    public PrintNumber(int i ){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i + " from " + Thread.currentThread().getName());
    }
}
