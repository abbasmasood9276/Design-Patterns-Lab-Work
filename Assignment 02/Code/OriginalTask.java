/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author aabik
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OriginalTask {
    public List<Future<Integer>> fanOut(List<SubTask> subTasks, ExecutorService executorService) {
        // Initiates Fan-out phase
        List<Future<Integer>> futures = new ArrayList<>();
        for (SubTask subTask : subTasks) {
            Future<Integer> future = executorService.submit(subTask);
            futures.add(future);
        }
        return futures;
    }

    public int fanIn(List<Future<Integer>> futures) {
        // Initiates Fan-in phase
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                // Wait for each subtask to complete and retrieve the result
                int subtaskResult = future.get();
                totalSum += subtaskResult;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        // Example usage
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create original task
        OriginalTask originalTask = new OriginalTask();

        // Create subtasks
        List<SubTask> subTasks = List.of(
                new SubTask(new int[]{1, 2, 3}),
                new SubTask(new int[]{4, 5, 6}),
                new SubTask(new int[]{7, 8, 9})
        );

        // Fan-out phase
        List<Future<Integer>> futures = originalTask.fanOut(subTasks, executorService);

        // Fan-in phase
        int totalSum = originalTask.fanIn(futures);

        System.out.println("Total Sum: " + totalSum);

        // Shutdown the executor service
        executorService.shutdown();
    }
}
