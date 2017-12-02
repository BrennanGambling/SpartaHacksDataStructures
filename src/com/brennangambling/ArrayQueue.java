package com.brennangambling;

public class ArrayQueue {

    //the array holding the queue of objects.
    private String queue[];
    //the front index of the queue in the array.
    private int front;
    //the last/end index of the queue in the array.
    private int rear;
    //the current number of items in the queue.
    private int currentSize;

    /**
     * Creates an ArrayQueue with the array length of startSize.
     * @param startSize
     */
    public ArrayQueue(int startSize){
        this.queue = new String[startSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    /**
     * Adds/enqueues a String to the queue.
     * @param item the String to be enqueued.
     */
    public void enqueue(String item) {
        //if the currentSize of the queue is equal to the size of the array.
        if (currentSize == queue.length) {
            //grow the array that is holding the queue.
            growQueue(queue.length);
        }
        //move the rear position back one/increment by one.
        rear++;
        //if the rear end of the queue has passed the bounds of the array wrap around to the front of the array.
        if(rear >= queue.length){
            rear = 0;
        }
        //add the new String at the rear of the queue.
        queue[rear] = item;
        //increment the current size by 1.
        currentSize++;
    }

    /**
     * Removes/dequeues a String from the queue
     * @return the String at the front of the queue.
     */
    public String dequeue() {
        if (isEmpty()) {
            //if there is nothing in the queue there is nothing to return.
            return null;
        } else {
            //get the String at the front of the queue.
            String returnString = queue[front];
            //move the front position back one/increment by one.
            front++;
            //if the front end of the queue has passed the bounds of the array wrap around to the front of the array.
            if(front >= queue.length){
                front = 0;
            }
            //decrement the current size by 1.
            currentSize--;
            return returnString;
        }
    }

    /**
     * Indicates whether or not any items are stored in the queue.
     * @return true if the queue has elements, false if it does not.
     */
    public boolean isEmpty(){
        return currentSize == 0;
    }

    /**
     * Grows the length of the array used to store the queue by the specified value.
     * @param by the amount to increase the queue by.
     */
    private void growQueue(int by){
        //create new array with double size as the current one.
        int newLength = queue.length + by;
        String[] oldQueue = queue;
        queue = new String[newLength];
        int tempRear = rear;
        for (int i = 0; i <= currentSize; i++) {
            System.out.println("" + tempRear);
            queue[i] = oldQueue[tempRear];
            tempRear++;
            if (tempRear >= oldQueue.length) {
                tempRear = 0;
            }
        }
        this.rear = currentSize;
        this.front = 0;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = front; i <= rear; i++) {
            output += "\n" + queue[i];
        }
        return output;
    }
}
