class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function isSumTree(node) {
    if (!node) return 0;
    if (!node.left && !node.right) return node.data;

    const leftSum = isSumTree(node.left);
    const rightSum = isSumTree(node.right);

    if (leftSum === false || rightSum === false || node.data !== leftSum + rightSum) {
        return false;
    }
    return node.data + leftSum + rightSum;
}

function checkSumTree(root) {
    return isSumTree(root) !== false;
}

function main() {
    const root = new Node(26);
    root.left = new Node(10);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(6);
    root.right.right = new Node(3);

    console.log(checkSumTree(root)); 
}

main();
