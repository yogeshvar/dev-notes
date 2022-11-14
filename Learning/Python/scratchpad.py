class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

i = ListNode()
i.val = 1 
i.next = ListNode()
i.next.val = 1
i.next.next = ListNode()
i.next.next.val = 2

def print_lst(head):
    while head != None:
        print(head.val)
        head = head.next

# print_lst(i)

def delDup(head):
    scan = head
    while head and scan.next:
        if scan.next.val == scan.val:
            scan.next = scan.next.next
        else:
            scan = scan.next
    return head

h = delDup(i)    
print_lst(h)
    
