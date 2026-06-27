class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
    }
    
    HashMap<Integer, Node> map;
    int cap;
    Node head, tail;

    private void addFirst(Node node) {
        Node nbr = head.next;
        node.next = nbr;
        node.prev = head;
        head.next = node;
        nbr.prev = node;
    }

    private void removeNode(Node node) {
        Node nbrPrev = node.prev;
        Node nbrNext = node.next;
        nbrPrev.next = nbrNext;
        nbrNext.prev = nbrPrev;
        node.prev = node.next = null;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            int v1 = node.value;
            moveToFront(node);
            return v1;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if (map.size() == cap) {
                Node LRU_Cache = tail.prev;
                map.remove(LRU_Cache.key);
                removeNode(LRU_Cache);
            }
            map.put(key, newNode);
            addFirst(newNode);
        } else {
            node.value = value;
            moveToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */