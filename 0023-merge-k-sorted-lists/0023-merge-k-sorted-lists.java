/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
           // Define a priority queue (min-heap) that orders ListNodes by their value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Initialize the heap with the head of each list
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Extract the smallest node from the heap and add it to the result
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // Get the smallest node
            current.next = node;            // Add it to the result list
            current = current.next;         // Move the pointer
            
            if (node.next != null) {        // If there is a next node, add it to the heap
                minHeap.add(node.next);
            }
        }
        
        // Return the merged list starting from the node after dummy
        return dummy.next;
    }
}