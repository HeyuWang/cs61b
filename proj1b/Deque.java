public interface Deque <E>{
     void addFirst(E item);
     void addLast(E item);
     boolean isEmpty();

     int size();
     void printDeque();
     E removeFirst();
     E removeLast();
     E get(int index);
}
