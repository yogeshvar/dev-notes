a = [[1, 2, 3], [4, 5, 6], [9, 8, 9]]

"""
Just random notes: 
A different approach manipulating the indexes. 
For example, let's take a 3x3 matrix
1 2 3 
4 5 6 
9 8 9 
the sum of diagonal RL = a[0,0] + a[1,1] + a[2,len]
                         a[2,len] + a[1,1] + a[0,0] is the same
the sum of diagonal LR = a[0,len] + a[1,1] + a[2,0]
if we find common things from above
a[x, right_index] decreases by 1 from len 
For RL, left_index decreases by 1
For LR, left_index increases by 1.
"""


def diagonal_difference(arr):
    left_to_right_idx = 0
    right_to_left_idx = len(arr) - 1
    left_to_right_sum = 0
    right_to_left_sum = 0
    for i in range(0, len(arr)):
        left_to_right_sum += arr[i][left_to_right_idx]
        right_to_left_sum += arr[i][right_to_left_idx]
        left_to_right_idx += 1
        right_to_left_idx -= 1
    return abs(left_to_right_sum - right_to_left_sum)


print(diagonal_difference(a))
