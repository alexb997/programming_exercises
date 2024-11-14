// Given the root of a binary tree.
//  Check whether it is a Binary Search Tree or not.

// A Binary Search Tree (BST) is a node-based binary tree data structure with the following properties:
// All keys in the left subtree are smaller than the root and all keys in the right subtree are greater.
// Both the left and right subtrees must also be binary search trees.
// Each key must be distinct.

function isBST(root, min = -Infinity, max = Infinity) {
    if (root === null) return true;
    if (root.value <= min || root.value >= max) return false;
    return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
}

function main() {
    const root = {
        value: 10,
        left: {
            value: 5,
            left: { value: 3, left: null, right: null },
            right: { value: 7, left: null, right: null }
        },
        right: {
            value: 15,
            left: { value: 12, left: null, right: null },
            right: { value: 18, left: null, right: null }
        }
    };

    const result = isBST(root);
    console.log("Is the tree a BST?", result);
}

main();
