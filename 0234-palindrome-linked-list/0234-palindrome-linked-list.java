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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a single-node list is a palindrome
        }
        
        // Step 1: Find the middle of the list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        // Move slow to the middle and fast to the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        
        // Step 3: Compare the two halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; // If values don't match, it's not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true; // If all values matched, it's a palindrome
    }
    
    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
