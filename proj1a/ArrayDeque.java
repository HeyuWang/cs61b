public class ArrayDeque<E> {
    private E[] deque;

    private int size;       /*count added element*/
    private int capacity;   /*count capacity*/

    private int nextFirst;  /*where to put when call addFirst*/
    private int nextLast;   /*where to put when call addLast*/

    private int refactor;   /*refact the array when array is full*/
//    private double usageRatio;/*when remove too much shrink the array*/

    /*
    void dataStructureInvariants(){
      assert(size == 0 || size == capacity)
             ?(nextFirst+1)%capacity == nextLast
            :(nextFirst+size+1)%capacity == nextLast;
    }
    * */
    public ArrayDeque() {
        deque = (E[]) new Object[8];
        capacity = 8;
        nextFirst = capacity / 2 - 1;
        nextLast = capacity / 2;
        refactor = 2;

        size = 0;

    }

    public void addFirst(E val) {
        if (size < capacity) {
            deque[nextFirst] = val;
            nextFirst = (nextFirst + capacity - 1) % capacity;
            size++;
        } else {
            resize(refactor * capacity);
            addFirst(val);
        }
    }

    public void addLast(E val) {
        if (size < capacity) {
            deque[nextLast] = val;
            nextLast = (nextLast + 1) % capacity;
            size++;
        } else {
            resize(refactor * capacity);
            addLast(val);
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void resize(int newSize) {
        if (size == capacity) {
            /*resize when array is full*/
            E[] newDeque = (E[]) new Object[newSize];
            int first = (nextFirst + 1) % capacity;
//        int last = (nextLast-1+capacity)%capacity;
            System.arraycopy(deque, first, newDeque, 0, capacity - first);
            System.arraycopy(deque, 0, newDeque, capacity - first, first);
            deque = newDeque;
            nextLast = capacity;
            capacity = refactor * capacity;
            nextFirst = capacity - 1;
        } else {
            int first = (nextFirst + 1) % capacity;
            int last = (nextLast - 1 + capacity) % capacity;
            E[] newDeque = (E[]) new Object[newSize];

            if (first <= last) {
                System.arraycopy(deque, first, newDeque, 0, size);

            } else {
                System.arraycopy(deque, first, newDeque, 0, capacity - first);
                System.arraycopy(deque, 0, newDeque, capacity - first, size - capacity + first);
            }
            deque = newDeque;
            nextLast = size;
            capacity = newSize;
            nextFirst = capacity - 1;
            /*resize when usageRatio is under 0.25*/
        }
    }

    public void printDeque() {
        int idx = (nextFirst + 1) % capacity;
        for (int i = 0; i < size; i++) {
            System.out.println(i + "th element is " + deque[idx]);
            idx = (idx + 1) % capacity;
        }
    }

    public E removeFirst() {
        if (size > 0) {
            int first = (nextFirst + 1) % capacity;
            nextFirst = first;
            E removed = deque[first];
            deque[first] = null;
            size--;
            double usageRatio = (double) size / capacity;
            if (usageRatio <= 0.25) {
                resize(capacity / 2);
            }
            return removed;
        } else {
            return null;
        }
    }


    public E removeLast() {
        if (size > 0) {
            int last = (nextLast - 1 + capacity) % capacity;
            nextLast = last;
            E removed = deque[last];
            deque[last] = null;
            size--;
            double usageRatio = (double) size / capacity;
            if (usageRatio <= 0.25) {
                resize(capacity / 2);
            }
            return removed;
        } else {
            return null;
        }
    }

    public int capacity() {
        return capacity;
    }

    public E get(int index) {
        int first = (nextFirst + 1) % capacity;
        int last = (nextLast - 1 + capacity) % capacity;
        int idx;
        if (first <= last) {
            idx = first + index;
        } else {
            int rightPart = capacity - first;
            if (index < rightPart) {
                idx = first + index;
            } else {
                idx = last + index - rightPart;
            }
        }
        return deque[idx];
    }
}
