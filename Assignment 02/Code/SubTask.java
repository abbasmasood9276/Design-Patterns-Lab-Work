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
import java.util.concurrent.Callable;

public class SubTask implements Callable<Integer> {
    private final int[] array;

    public SubTask(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() {
        // Simulate processing - compute the sum of elements in the array
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}

