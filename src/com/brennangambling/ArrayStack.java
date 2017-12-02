package com.brennangambling;

public class ArrayStack {

    //the current position in the array.
    private int position;
    //the stack of objects.
    private Object[] stack;

    /**
     * Creates a ArrayStack with an array length of startSize.
     * @param startSize the starting size of the array.
     */
    public ArrayStack(int startSize) {
        this.position = -1;
        this.stack = new Object[startSize];
    }

    /**
     * Adds an object to the top of the stack.
     * @param object the object to be added.
     */
    public void push(Object object) {
        //increment the position value by 1.
        position++;
        //if the position value is greater than the last index in the stack array.
        if (position > stack.length - 1) {
            //double the size of the stack array.
            /*This could be any number but it is best to minimize the number of times you have to grow the
            array while also conserving memory.*/
            growStack(stack.length);
        }
        //add the object to the current position in the stack array.
        stack[position] = object;
    }

    /**
     * Extends the length of the stack array by
     * @param by the amount to extend the array by.
     */
    private void growStack(int by) {
        //calculate the new length of the array.
        int newLength = stack.length + by;
        //keep a reference to the old array.
        Object[] oldStack = stack;
        //create a new array with the new length.
        stack = new Object[newLength];
        //copy the contents of the old array into the new array.
        System.arraycopy(oldStack, 0, stack, 0, oldStack.length);
    }

    /**
     * Removes an object from the top of the stack.
     * @return the object at the top of the stack.
     */
    public Object pop() {
        if (isEmpty()) {
            //Because there are no objects to pop off the stack return null. You could also throw an exception here.
            return null;
        } else {
            //return the object at the current position in the stack array.
            //this position in the array will later be over written when push is called.
            Object returnObject = stack[position];
            //decrement the position value by 1.
            position--;
            return returnObject;
        }
    }

    /**
     * @return the number of elements in the stack.
     */
    public int size() {
        return position + 1;
    }

    /**
     * Indicates where any elements are stored.
     * @return true if the Stack has any elements, false if it does not.
     */
    public boolean isEmpty() {
        //if the position is less than 0 push has not yet been called and there is therefore nothing in the Stack.
        return position < 0;
    }
}
