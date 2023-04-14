package com.github.zipcodewilmington;

import com.github.zipcodewilmington.sample.Node;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap implements HashMapX{
    Node[] array = new Node[26];
    private int hashFunctionOne(String input) {
        if (input.length() > 0) {
//            return String.toLowerCase(String.valueOf(input.charAt(0)));
            return input.toLowerCase().charAt(0) - 97;
        }
        return -1;
    }

    @Override
    public void set(String key, String value) {
        int index = hashFunctionOne(key);
        Node current = array[index];
        if (current == null){
            array[index] = new Node(key,value);
            return;
        }
        while (current.getNext() != null){
            current = current.getNext();
        } current.setNext(new Node(key, value));
    }

    @Override
    public String delete(String key) {
        if (bucketSize(key) < 2){
            array[hashFunctionOne(key)] = null;
            return "";
        }
        Node current = array[hashFunctionOne(key)].getNext();
        Node prev = array[hashFunctionOne(key)];
        if(bucketSize(key) < 2){
            array[hashFunctionOne(key)] = null;
        }
        while (current != null){
            if (current.getKey().equals(key)){
                String s = current.getValue();
                prev.setNext(current.getNext());
                return s;
            }
            prev = current;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public String get(String key) {
        int index = hashFunctionOne(key);
        Node current = array[index];
        while(current != null){
            if (current.getKey().equals(key)){
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public long size() {
        long count = 0;
        for (int i = 0; i < array.length; i++) {
            Node current = array[i];

            while (current != null){
                count++;
                current = current.getNext();
            }
        }
        return count;
    }
    @Override
    public long bucketSize(String key) {
        long size = 0;
        Node current = array[hashFunctionOne(key)];
        while (current != null){
            size++;
            current = current.getNext();
        }
        return size;
    }
}
