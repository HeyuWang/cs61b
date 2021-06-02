import java.util.Iterator;
import java.util.Set;

public class BSTMap <K extends Comparable<K>,V> implements Map61B<K,V>{

    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left,right;
        private int N;

        Node(K key, V val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public void clear() {
        clear(root);
    }

    private void clear(Node n){
        if(n == null)
            return;
        clear(n.left);
        clear(n.right);
        n.val = null;
    }

    @Override
    public boolean containsKey(K key) {
        if(key == null)
            throw new IllegalArgumentException();
        return get(key) != null;
    }

    @Override
    public V get(K key) {
//        Node n = search(root,key);
//        if(n == null)
//            return null;
//        return n.val;
        return get(root,key);
    }

    private V get(Node n, K key){
        if(key == null)
            throw new IllegalArgumentException("empty pointer");
        if(n == null)
            return null;
        if(key.compareTo(n.key) < 0)
            return get(n.left,key);
        else if (key.compareTo(n.key) > 0) {
            return get(n.right, key);
        } else {
            return n.val;
        }
    }

    private Node search(Node n, K key){
        if(n == null)
            return null;
        /*key > n.val*/
        if(key.compareTo(n.key) > 0){
            return search(n.right,key);
        }
        else if(key.compareTo(n.key) < 0){
            return search(n.left,key);
        }
        else{
            return n;
        }
    }

    @Override
    public int size() {
        return size(root);
    }
    private int size(Node x){
        if (x == null)
            return 0;
        return x.N;
    }

    @Override
    public void put(K key, V value) {
        if(key == null)
            throw new IllegalArgumentException();
//        if(value == null){
//            delete(key);
//            return;
//        }
        root = put(root,key,value);
    }

    private Node put(Node n, K key, V value){
        if(n == null)
            return new Node(key,value,1);
        int cmp = key.compareTo(n.key);
        if(cmp < 0){
            n.left = put(n.left,key,value);
        } else if (cmp > 0) {
            n.right = put(n.right, key, value);
        } else {
            n.val = value;
        }
        n.N = 1 + size(n.left) + size(n.right);
        return n;
    }


    public void print(){
        printInOrder(root);
    }
    private void printInOrder(Node n){
        if(n == null)
            return;
        printInOrder(n.left);
        System.out.print(n.val+" ");
        printInOrder(n.right);
    }
//    public void delete(K key){
//
//    }
//
//    private Node delete(Node n, K key){
//        if(n == null)
//            return null;
//        int cmp = key.compareTo(n.key);
//        if (cmp < 0) {
//
//        } else if () {
//        } else {
//
//        }
//    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
