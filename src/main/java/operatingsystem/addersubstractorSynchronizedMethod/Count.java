package operatingsystem.addersubstractorSynchronizedMethod;

public class Count {
     int value = 0;

    public synchronized void incrementValue(int offset){
        this.value += offset;
    }

    public int getValue(){
        return this.value;
    }
}
