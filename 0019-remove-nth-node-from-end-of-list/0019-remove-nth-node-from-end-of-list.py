# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        newnode=ListNode(0)
        newnode.next=head
        l=0
        curr = head
        while curr!=None:
            curr = curr.next
            l+=1
        curr = newnode
        for i in range(l-n):
            curr = curr.next
        curr.next = curr.next.next
        return newnode.next
    