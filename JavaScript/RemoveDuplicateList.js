// Given a linked list sorted in non-decreasing order. Return the list by deleting
//  the duplicate nodes from the list. The returned list should also be in non-decreasing order.

class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

function removeDuplicates(head) {
  if (!head) return null;
  let current = head;
  while (current && current.next) {
    if (current.data === current.next.data) {
      current.next = current.next.next;
    } else {
      current = current.next;
    }
  }
  return head;
}

function printList(head) {
  let current = head;
  while (current) {
    console.log(current.data);
    current = current.next;
  }
}

function main() {
  let head = new Node(1);
  head.next = new Node(1);
  head.next.next = new Node(2);
  head.next.next.next = new Node(3);
  head.next.next.next.next = new Node(3);
  printList(head);
  head = removeDuplicates(head);
  console.log("Modified List:");
  printList(head);
}

main();
