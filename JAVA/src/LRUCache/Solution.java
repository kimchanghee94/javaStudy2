package LRUCache;

import java.util.*;

class ListNode{
    int key,val;
    ListNode prev, next;
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class Solution {
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    int capacity;

    public Solution(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        ListNode node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));
        if(map.size() == capacity) remove(head.next);

        ListNode tmp = new ListNode(key, value);
        insert(tmp);
    }

    private void remove(ListNode node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(ListNode node){
        map.put(node.key, node);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}