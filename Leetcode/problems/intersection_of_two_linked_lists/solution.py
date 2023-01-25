# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def print_list(self, head):
        while head:
            print(head.val)
            head = head.next

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB: 
            return None
        
        a, b = headA, headB

        while a != b:
            a = headB if a is None else a.next
            b = headA if b is None else b.next
        
        return a
