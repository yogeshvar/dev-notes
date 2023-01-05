# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        
        start = None    
        if list1.val < list2.val:
            start = list1
            start.next = self.mergeTwoLists(list1.next, list2)
        else:
            start = list2
            start.next = self.mergeTwoLists(list1, list2.next)
        
        return start