# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        value = ''
        while head != None: 
            print(head.val)
            value += str(head.val)
            head = head.next
        return int(value, 2)