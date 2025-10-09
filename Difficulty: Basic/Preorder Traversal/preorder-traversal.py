'''
# Node Class:
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def preOrder(self, root):
    # code here
        if root is None:
            return []
        left = self.preOrder(root.left)
        ryt = self.preOrder(root.right)
        return [root.data] + left + ryt