package datastructures;

import java.util.LinkedList;

class CustomQueue {
    private LinkedList<Integer> queueList;

    public CustomQueue() {
        queueList = new LinkedList<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        queueList.addLast(data);
    }

    //Dequeue operation
    public void dequeue() {
        if (!isEmpty()) {
            queueList.removeFirst();
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }
    }

    //Display the elements in the queue
    public void display() {
        for (int data : queueList) {
            System.out.println(data);
        }
    }

    //Check if the queue is empty
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    //Get the size of the queue
    public int size() {
        return queueList.size();
    }
}

public class QueueImp{

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.display();
        
        System.out.println();

        queue.dequeue();

        queue.display();
    }
}