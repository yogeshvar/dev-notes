def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
    left_head, right_head = ListNode(), ListNode()
    l, r = left_head, right_head
    while head:
        if head.val < x:
            l.next = head
            l = l.next
        else:
            r.next = head
            r = r.next
        head = head.next
    l.next = right_head.next
    r.next = None
    return left_head.next