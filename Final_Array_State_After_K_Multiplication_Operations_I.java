
class Solution {
    // Custom class to store both the value and index of an element
    class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Priority queue that sorts based on the values in nums
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add each element of nums along with its index to the priority queue
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }

        // Perform k operations
        while (k > 0) {
            // Get the pair with the smallest value
            Pair minPair = pq.poll();

            // Multiply the value by the multiplier
            minPair.value *= multiplier;

            // Update the value in the original array at the corresponding index
            nums[minPair.index] = minPair.value;

            // Rebuild the priority queue with updated values
            pq = new PriorityQueue<>((a, b) -> a.value - b.value);
            for (int i = 0; i < nums.length; i++) {
                pq.add(new Pair(nums[i], i));
            }

            // Decrement k
            k--;
        }

        return nums;  // Return the final state of nums
    }
}
