# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        i = 0
        j = 0
        tempHead = head
        while (head != None):
            i = i + 1
            head = head.next
        while (tempHead != None):
            j = j + 1
            if (j == i//2 + 1):
                return tempHead
            tempHead = tempHead.next