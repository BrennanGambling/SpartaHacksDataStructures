package com.brennangambling;

public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public String get(int index){
        return get(index, first).string;
    }

    private Node get(int index, Node node) {
        if (node != null) {
            if (index == 0) {
                return node;
            } else {
                return get(index - 1, node.next);
            }
        } else {
            return null;
        }
    }

    public void add(String s) {
        Node newNode = new Node(s);
        if (first == null) {
            first = newNode;
        } else {
            add(newNode, first);
        }
        size++;
    }

    private void add(Node newNode, Node currentNode) {
        if (currentNode.next == null) {
            currentNode.next = newNode;
        } else {
            add(newNode, currentNode.next);
        }
    }

    public class Node {
        public String string;
        public Node next;

        public Node(String s) {
            string = s;
        }
    }
}
