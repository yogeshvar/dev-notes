def addTwoList(l1, l2):
    res = ListNode(0)
    curr = res
    carry = 0
    while l1 != None or l2 != None or carry != 0:
        l1Val = l1.val if l1 else 0
        l2Val = l2.val if l2 else 0
        columnSum = l1Val + l2Val + carry
        carry = columnSum // 10
        newNode = ListNode(columnSum % 10)
        curr.next = newNode
        curr = newNode
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None
    return res.next