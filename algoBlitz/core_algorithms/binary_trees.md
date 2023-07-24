# Binary Trees
	https://coda.io/d/_dQj6eI0mP1R/Core-Algorithms_suE63#_lu1CC

## Count Elements in a Binary Tree (iterative / recursive)

## Sum Elements in a Binary Tree 

## Find Max Element in a Binary Tree 

## Find Height of a Binary Tree 
### Recursive
```java
  public static int heightBTree(TreeNode head){
    if ( head == null) return 0;

    return 1 + Math.max(heightBTree(head.left),heightBTree(head.right));
  }
```
### Iterative


## Find Element in a Binary Tree Using BFS

## Find Element in a Binary Tree Using DFS


# Binary Search Tree

## Find Element in a Binary Search Tree
### Recursive
'''java
  public static TreeNode findNodeBST(TreeNode head, int val){
    if (head == null) return null;

    if (head.val == val) return head;
    if (val > head.val){
      return findNodeBST(head.right,val);
    }else{
      return findNodeBST(head.left,val);
    }
  }
'''

## Insert Element into a Binary Search Tree 

## Validate a Binary Search Tree 

### -+ Infinity approach
'''java
class Solution {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
'''
### In-order traversal approach
'''java
class Solution {
    // We use Integer instead of int as it supports a null value.
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}
'''