package com.github.zipcodewilmington.sample;

public class Node{
    String key;
    String value;
    Node next;
    public Node(String key, String value){
        this.key = key;
        this.value = value;
        next = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}