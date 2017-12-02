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
            if(front > queue.length-1){
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
        int newLength = this.queue.length + by;
        String[] newArr = new String[newLength];
        //copy elements to new array, copy from front to rear
        //this is used so the queue can be copied from its front to its rear instead of the elements being copied in
        //the order that they are stored in the array.
        int tmpFront = front;
        //the entire queue will have been copied once the counter reaches the currentSize of the queue.
        //this will place the entire queue from front to rear in the new array no matter how it was stored in the old array.
        for (int i = 0; i < currentSize; i++) {
            newArr[i] = this.queue[tmpFront];
            tmpFront++;
            //if the end of the old array has been reached, loop back to the front of the array.
            if(tmpFront == this.queue.length){
                tmpFront = 0;
            }
        }
        //set the new array.
        this.queue = newArr;
        //reset front and rear values
        this.front = 0;
        this.rear = currentSize;
    }
}
