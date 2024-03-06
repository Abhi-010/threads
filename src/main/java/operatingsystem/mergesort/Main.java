package operatingsystem.mergesort;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(1,7,-5,0,3,5,5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        Sorter sorter = new Sorter(arrayToSort,executorService);

        Future<List<Integer>> listFuture = executorService.submit(sorter);
        List<Integer> sortedArray = listFuture.get();
        for (Integer ints: sortedArray) {
            System.out.println(ints);
        }
    }
}
