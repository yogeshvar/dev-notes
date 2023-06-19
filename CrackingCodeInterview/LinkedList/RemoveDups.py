# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
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
        self.printList(head)
        return head

    def printList(self, head):
        while head:
            print(head.val)
            head = head.next
    
ListNode1 = ListNode(1)
ListNode2 = ListNode(1)
ListNode3 = ListNode(2)
ListNode1.next = ListNode2
ListNode2.next = ListNode3

Solution().deleteDuplicates(ListNode1)
