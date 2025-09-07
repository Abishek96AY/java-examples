package com.examples.datastructure.queue;

//Node class representing each element in the queue
class Node {
 int data;
 Node next;

 public Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//CircularQueue class representing the circular queue
class CircularQueueUsingLinkedList {
 private Node front, rear;

 public CircularQueueUsingLinkedList() {
     front = rear = null;
 }

 // Check if the queue is empty
 public boolean isEmpty() {
     return front == null;
 }

 // Enqueue operation: Add an element to the queue
 public void enqueue(int data) {
     Node newNode = new Node(data);

     if (isEmpty()) {
         front = rear = newNode;
         rear.next = front; // Make it circular
     } else {
         rear.next = newNode;
         rear = newNode;
         rear.next = front; // Make it circular
     }
 }

 // Dequeue operation: Remove an element from the queue
 public int dequeue() {
     if (isEmpty()) {
         System.out.println("Queue is empty");
         return -1;
     }

     int value;

     if (front == rear) { // Only one element
         value = front.data;
         front = rear = null;
     } else {
         Node temp = front;
         value = temp.data;
         front = front.next;
         rear.next = front; // Maintain circular link
     }

     return value;
 }

 // Peek operation: View the front element of the queue
 public int peek() {
     if (isEmpty()) {
         System.out.println("Queue is empty");
         return -1;
     }
     return front.data;
 }

 // Display the elements of the queue
 public void display() {
     if (isEmpty()) {
         System.out.println("Queue is empty");
         return;
     }

     Node temp = front;
     do {
         System.out.print(temp.data + " ");
         temp = temp.next;
     } while (temp != front);
     System.out.println();
 }

 public static void main(String[] args) {
     CircularQueueUsingLinkedList queue = new CircularQueueUsingLinkedList();

     queue.enqueue(10);
     queue.enqueue(20);
     queue.enqueue(30);
     queue.enqueue(40);

     System.out.print("Queue: ");
     queue.display();

     System.out.println("Dequeued: " + queue.dequeue());
     System.out.println("Dequeued: " + queue.dequeue());

     System.out.print("Queue after dequeuing: ");
     queue.display();

     System.out.println("Front element: " + queue.peek());
 }
}
