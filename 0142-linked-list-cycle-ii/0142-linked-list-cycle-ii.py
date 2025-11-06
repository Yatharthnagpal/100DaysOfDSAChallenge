# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast= head
        slow = head
        Hascycle=False
        while fast!=None and fast.next!=None:
            fast=fast.next.next
            slow=slow.next
            if fast==slow:
                Hascycle=True
                break
        if not Hascycle:
            return None
        l=0
        while slow.next!=fast:
            slow=slow.next
            l+=1
        l+=1
        slow=head
        fast=head    
        for i in range(l):
            fast=fast.next
        while slow!=fast:
            slow=slow.next
            fast=fast.next
        return slow
