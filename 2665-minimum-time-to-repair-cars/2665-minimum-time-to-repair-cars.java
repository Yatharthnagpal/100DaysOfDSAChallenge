class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks); // Sorting helps prioritize faster mechanics
        long left = 1, right = (long) ranks[0] * (long) cars * cars; // Set binary search range
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                right = mid; // Try to find a smaller feasible time
            } else {
                left = mid + 1; // Increase time limit
            }
        }
        return left;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long maxTime) {
        int totalCars = 0;
        for (int rank : ranks) {
            int carCount = (int) Math.sqrt(maxTime / rank); // Maximum cars this mechanic can repair
            totalCars += carCount;
            if (totalCars >= cars) return true; // If enough cars are repaired, return true
        }
        return false;
    }
}