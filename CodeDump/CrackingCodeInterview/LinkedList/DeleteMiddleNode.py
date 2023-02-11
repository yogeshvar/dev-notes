# delete the middle node of a linked list

def deleteMiddle(head):
    if head == None:
        return None
    if head.next == None:
        return None
    slow = head
    fast = head
    prev = None
    while fast != None and fast.next != None:
        prev = slow
        slow = slow.next
        fast = fast.next.next
    prev.next = slow.next
    return head
