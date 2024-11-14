// We are given a stack data structure with push and pop operations,
// the task is to implement a queue using instances of stack data structure and operations on them.

class QueueUsingStacks {
  constructor() {
    this.stack1 = [];
    this.stack2 = [];
  }
  enqueue(x) {
    this.stack1.push(x);
  }
  dequeue() {
    if (this.stack2.length === 0) {
      if (this.stack1.length === 0) {
        console.log("Queue is empty");
        return null;
      }
      while (this.stack1.length > 0) {
        this.stack2.push(this.stack1.pop());
      }
    }
    return this.stack2.pop();
  }
  peek() {
    if (this.stack2.length === 0) {
      if (this.stack1.length === 0) {
        console.log("Queue is empty");
        return null;
      }
      while (this.stack1.length > 0) {
        this.stack2.push(this.stack1.pop());
      }
    }
    return this.stack2[this.stack2.length - 1];
  }
  isEmpty() {
    return this.stack1.length === 0 && this.stack2.length === 0;
  }
}

function main() {
  const queue = new QueueUsingStacks();

  queue.enqueue(1);
  queue.enqueue(2);
  queue.enqueue(3);

  console.log("Dequeue Operation: " + queue.dequeue());
  console.log("Peek Operation: " + queue.peek());
  console.log("Dequeue Operation: " + queue.dequeue());
  console.log("Dequeue Operation: " + queue.dequeue());
  console.log("Dequeue Operation: " + queue.dequeue());
}

main();
