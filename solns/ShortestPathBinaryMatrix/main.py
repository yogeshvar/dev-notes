"""
Status: Accepted
https://leetcode.com/problems/shortest-path-in-binary-matrix/
"""


def shortestPathBinaryMatrix(grid):
    # From Given: A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
    if grid[0][0] == 1 or grid[-1][-1] == 1:
        return -1
    n = len(grid)
    # From Given: All the adjacent cells of the path are 8-directionally connected
    offsets = [(-1, -1), (-1, 0), (-1, 1), (0, -1),
               (0, 1), (1, -1), (1, 0), (1, 1)]
    # Start at (0, 0)
    q = [(0, 0, 1)]
    visited = set([(0, 0)])
    while q:
        x, y, d = q.pop(0)
        if x == n - 1 and y == n - 1:
            return d
        for dx, dy in offsets:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited and grid[nx][ny] == 0:
                q.append((nx, ny, d + 1))
                visited.add((nx, ny))
    return -1


result = shortestPathBinaryMatrix([[0, 0, 0], [1, 1, 0], [1, 1, 0]])
print(result)
