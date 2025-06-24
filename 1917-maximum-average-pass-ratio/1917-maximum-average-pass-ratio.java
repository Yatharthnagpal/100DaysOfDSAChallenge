class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
         PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0]) // Compare by potential gain
        );
        
        // Initialize the heap with each class
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }
        
        // Distribute extra students
        while (extraStudents > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            
            // Add an extra student
            pass++;
            total++;
            extraStudents--;
            
            // Recompute the gain and push back into the heap
            double newGain = gain(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }
        
        // Compute the final average pass ratio
        double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }
        
        return totalRatio / classes.length;
    }private double gain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}