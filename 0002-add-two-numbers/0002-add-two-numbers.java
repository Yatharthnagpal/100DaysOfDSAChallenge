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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify the code
        ListNode current = dummyHead; 
        int carry = 0; // To store carry during addition

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add the values from the current nodes of l1 and l2, if present
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry for next iteration
            carry = sum / 10;

            // Create a new node with the digit value and move the pointer
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummyHead.next; // Return the actual head of the result   
    }
}