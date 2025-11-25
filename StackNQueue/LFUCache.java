package StackNQueue;
import java.util.*;

class Node{
    int key, value, cnt;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key=key;
        this.value=value;
        cnt=1;
    }
}

class List {
    int size;
    Node head;
    Node tail;


    List(){
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size=0;
    }

    // Function to add node in front
    void addFront(Node node){
        Node temp=head.next;
        node.next=temp;
        node.prev=head;
        head.next=node;
        temp.prev=node;
        size++;
    }

    // Function to remove node from the list
    void removeNode(Node delNode){
        Node prevNode= delNode.prev;
        Node nextNode= delNode.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        size--;
    }
}

//TC:O(N) SC:O(cap)
public class LFUCache{
    private Map<Integer, Node> keyNode; // Hashmap to store the key-nodes pairs
    private Map<Integer, List> freqListMap; // Hashmap to maintain the lists with different frequencies
    private int maxSizeCache;
    private int minFreq;
    private int curSize;

    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
        minFreq = 0;
        curSize = 0;
    }

    // Method to update frequency of data-items
    private void updateFreqListMap(Node node){
        // Remove from Hashmap
        keyNode.remove(node.key);
        // Update the frequency list hashmap
        freqListMap.get(node.cnt).removeNode(node);
        // If node was the last node having its frequency
        if(node.cnt==minFreq && freqListMap.get(node.cnt).size==0){
            // Update the minimum frequency
            minFreq++;
        }

        // Creating a dummy list for next higher frequency
        List nextHigherFreqList=new List();

        // If the next higher frequency list already exists
        if(freqListMap.containsKey(node.cnt+1)){
            // Update pointer to already existing list
            nextHigherFreqList=freqListMap.get(node.cnt+1);
        }

        // Increment the count of data-item
        node.cnt+=1;
        // Add the node in front of higher frequency list
        nextHigherFreqList.addFront(node);

        // Update the frequency list map
        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    // Method to get the value of key from LFU cache
    public int get(int key){
        // Return the value if key exists
        if(keyNode.containsKey(key)){
            Node node=keyNode.get(key);
            int val= node.value;
            updateFreqListMap(node);
            return val;
        }
        return -1;
    }

    // Method to insert key-value pair in LFU cache
    public void put(int key, int value){
        /* If the size of Cache is 0, 
        no data-items can be inserted */
        if(maxSizeCache==0){
            return;
        }
        // If key already exists
        if(keyNode.containsKey(key)){
            Node node= keyNode.get(key);
            node.value=value;
            updateFreqListMap(node); // Update the frequency
        }else{
            // If cache limit is reached
            if(curSize==maxSizeCache){
                // Remove the least frequently used data-item
                List list=freqListMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);

                freqListMap.get(minFreq).removeNode(list.tail.prev);
                curSize--;
            }
            // Increment the current cache size
            curSize++;
            // Adding new value to the cache
            minFreq=1;  // Set its frequency to 1

            List listFreq=new List();

            // If the list already exists
            if(freqListMap.containsKey(minFreq)){
                // Update the pointer to already present list
                listFreq=freqListMap.get(minFreq);
            }
            Node node=new Node(key, value);
            listFreq.addFront(node);
            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        System.out.print(cache.get(3) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }
}


