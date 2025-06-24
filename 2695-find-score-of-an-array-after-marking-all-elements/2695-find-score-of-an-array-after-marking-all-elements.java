class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n]; // To track marked elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // Add all elements with their indices to the heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        long score = 0; // Use long to prevent overflow

        while (!minHeap.isEmpty()) {
            // Get the smallest unmarked element
            int[] entry = minHeap.poll();
            int value = entry[0];
            int idx = entry[1];

            // Skip if already marked
            if (marked[idx]) {
                continue;
            } 
            score += value;

            // Mark this element and its adjacent elements
            marked[idx] = true;
            if (idx > 0) {
                marked[idx - 1] = true;
            }
            if (idx < n - 1) {
                marked[idx + 1] = true;
            }
        }

        return score;
    }
}