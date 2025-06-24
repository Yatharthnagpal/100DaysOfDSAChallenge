class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all gifts to the max heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }
        
        // Perform the operation for k seconds
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            // Take the largest pile
            int largest = maxHeap.poll();
            // Calculate the remaining gifts (floor of the square root)
            int remaining = (int) Math.floor(Math.sqrt(largest));
            // Add the remaining gifts back to the heap
            maxHeap.add(remaining);
        }
        
        // Calculate the total remaining gifts
        long totalRemaining = 0;
        while (!maxHeap.isEmpty()) {
            totalRemaining += maxHeap.poll();
        }
        
        return totalRemaining;
    }
}