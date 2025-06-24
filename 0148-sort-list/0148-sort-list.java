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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list into two halves

        // Recursively sort each half
        left = sortList(left);
        right = sortList(right);

        // Merge the two sorted halves
        return merge(left, right);
    }

    // Function to find the middle node of the list
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // Start fast one step ahead

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify the merge
        ListNode current = dummy;

        // Merge nodes from both lists in ascending order
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}