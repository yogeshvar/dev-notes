# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        if not root:
            return []        
        def dfs(root, lvl, res):
            if not root:
                return
            if lvl >= len(res):
                res.append([root.val])
            else:
                res[lvl].append(root.val)
            dfs(root.left, lvl + 1, res)
            dfs(root.right, lvl + 1, res)                
        res = []
        dfs(root, 0, res)
        return [sum(x)/len(x) for x in res]