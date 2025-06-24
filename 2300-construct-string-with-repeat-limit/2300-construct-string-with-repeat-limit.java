class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
         Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Use a max heap to store characters by lexicographical order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(frequencyMap.keySet());

        // Step 3: Build the result
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            // Get the largest character
            char largestChar = maxHeap.poll();
            int largestCount = frequencyMap.get(largestChar);

            // Step 4: Determine how many times we can use the largest character
            int timesToAdd = Math.min(repeatLimit, largestCount);

            // Append the largest character `timesToAdd` times
            for (int i = 0; i < timesToAdd; i++) {
                result.append(largestChar);
            }

            // Update the remaining count for the largest character
            largestCount -= timesToAdd;

            if (largestCount > 0) {
                // Step 5: If there are remaining characters, insert the next largest character
                if (maxHeap.isEmpty()) {
                    // No other characters to break the limit, so we stop
                    break;
                }

                // Get the next largest character
                char secondLargestChar = maxHeap.poll();
                int secondLargestCount = frequencyMap.get(secondLargestChar);

                // Append the second largest character once to "break" the repeat limit
                result.append(secondLargestChar);
                secondLargestCount--;

                // Update the frequency map
                frequencyMap.put(largestChar, largestCount);
                frequencyMap.put(secondLargestChar, secondLargestCount);

                // Push both characters back to the heap if they still have remaining counts
                if (largestCount > 0) {
                    maxHeap.add(largestChar);
                }
                if (secondLargestCount > 0) {
                    maxHeap.add(secondLargestChar);
                }
            }
        }

        return result.toString();
    }
}