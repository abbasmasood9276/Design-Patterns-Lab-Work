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
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ResultCollector {
    public int aggregateResults(List<Future<Integer>> futures) throws ExecutionException {
        // Initiate Fan-in phase
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
}

