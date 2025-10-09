'''
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def postOrder(self, root):
        # code here    
        if root is None:
            return []
        left =self.postOrder(root.left)
        ryt = self.postOrder(root.right)
        return left + ryt + [root.data]
        
        