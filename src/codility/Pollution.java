package codility;

import java.util.*;
import java.util.stream.Collectors;

public class Pollution {

    public static void main(String[] args) {
        int[] nums = {5,19,8,1};
        int numberOfFilters = numberOfFilters(nums);
        System.out.println("numberOfFilters : " + numberOfFilters);
    }

    private static int numberOfFilters(int[] pollutions) {
        int numberOfFilters = 0;
        List<Integer> allPollutions = Arrays.stream(pollutions).boxed().sorted().collect(Collectors.toList());

        // Step 1: Calculate the initial total pollution
        int totalPollution = allPollutions.stream().reduce(0, Integer::sum);

        // Step 2: Set the target pollution level (half of the initial total)
        int expectedPollutionLimit = totalPollution / 2;

        // Step 3: Use a max heap (priority queue) to store pollution levels
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int pollution : pollutions) {
            maxHeap.add((double) pollution);
        }

        // Step 4: Apply filters until the total pollution is reduced to target level
        while (totalPollution > expectedPollutionLimit) {
            // Get the highest pollution factory and apply a filter
            double maxPollution = maxHeap.poll();
            double reducedPollution = maxPollution / 2;

            // Update the total pollution
            totalPollution -= reducedPollution;

            // Add the reduced pollution back to the heap
            maxHeap.add(reducedPollution);

            // Increment the filter count
            numberOfFilters++;
        }

        return numberOfFilters;
    }
}
