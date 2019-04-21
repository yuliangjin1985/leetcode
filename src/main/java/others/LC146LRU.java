package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Use double linked list and hashmap to implement the LRU algorithm, all operations done in O(1) time.
 *
 * 1. Design this list to use two extra node, head and tail.
 * 2. Add remove node method and add node method.
 */

public class LC146LRU {


    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity = 0;
    int count = 0;

    public LC146LRU(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.get(key) != null) {
            moveToHead(map.get(key));
            return map.get(key).value;
        } else {
            return -1;
        }
    }


    /**
     * For new node, add it first and then check the capacity.
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if(map.get(key) != null) {
            map.get(key).value = value;
            moveToHead(map.get(key));//put also move the node to the head
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            map.put(key, node);
            addNode(node);
            count++;
            if(count > capacity) {
                Node n = tail.pre;
                map.remove(n.key);
                remove(n);
                count--;
            }
        }


    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    public void moveToHead(Node node) {
        remove(node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    public static void main(String[] args) {
        LC146LRU lru = new LC146LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node post;
}
