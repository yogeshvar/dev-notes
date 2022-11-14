# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        scan = head
        while head and scan.next:
            if scan.next.val == scan.val:
                scan.next = scan.next.next
            else:
                scan = scan.next
        return head