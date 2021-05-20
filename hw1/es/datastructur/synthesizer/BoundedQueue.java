package es.datastructur.synthesizer;
import java.util.Iterator;

/*  enqueue at back
    dequeue at front
    fixed capacity*/

public interface BoundedQueue <T> extends Iterable<T>{
    int capacity();         /*return the size of the buffer*/
    int fillCount();        /*return usage of the buffer*/
    void enqueue(T x);      /*if full fail*/
    T dequeue();              /*delete and return the item from the front*/
    T peek();               /*return the item from the front*/

    default boolean isEmpty(){
        return fillCount() == 0;
    }

    default boolean isFull(){
        return fillCount() == capacity();
    }
}
