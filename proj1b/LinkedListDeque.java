public class LinkedListDeque<E> implements Deque<E>{
    public class ListNode<E> {
        E value;
        ListNode<E> prev;
        ListNode<E> next;

        public ListNode(E val, ListNode<E> prev, ListNode<E> next) {
            this.value = val;
            this.prev = prev;
            this.next = next;
        }

        public ListNode(ListNode<E> prev, ListNode<E> next) {
            this.prev = prev;
            this.next = next;
        }
    }

    private ListNode<E> sentinel;     /*head sentinel*/

    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode<>(null, null);
        sentinel.prev = sentinel.next = sentinel;   /*all point to itself*/
        size = 0;
    }

    @Override
    public void addFirst(E val) {
        ListNode<E> node = new ListNode<>(val, sentinel, sentinel.next);
        ListNode<E> saveNext = sentinel.next;
        sentinel.next = node;
        saveNext.prev = node;
        size++;
    }

    @Override
    public void addLast(E val) {
        ListNode<E> tail = sentinel.prev;
        ListNode<E> node = new ListNode<>(val, tail, sentinel);
        tail.next = node;
        sentinel.prev = node;
        size++;
    }

    @Override
    public void printDeque() {
        ListNode<E> p = sentinel.next;
        int i = 1;
        System.out.println("start print the whole deque");
        while (p != sentinel) {
            System.out.println(i + "th value is " + p.value);
            p = p.next;
            i++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeFirst() {
        if (sentinel.next == sentinel)
            return null;
        else {
            E val =  sentinel.next.value;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return val;
        }
    }

    @Override
    public E removeLast() {
        if (sentinel.next == sentinel)
            return null;
        else {
            ListNode<E> tail = sentinel.prev;
            E val =  tail.value;
            ListNode<E> tail_prev = tail.prev;
            tail_prev.next = sentinel;
            sentinel.prev = tail_prev;
            size--;
            return val;
        }
    }

    @Override
    public E get(int index) {
        if (sentinel.next == sentinel)
            return null;
        else {
            ListNode<E> p = sentinel.next;
            int realIdx = index % size;
            for (int i = 0; i < realIdx; i++) {
                p = p.next;
            }
            return p.value;
        }
    }

    public E getRecursive(int index) {
        if (sentinel.next == sentinel)
            return null;
        else{
            ListNode<E> p = sentinel.next;
            return helper(index%size,p);
        }
    }

    public E helper(int index, ListNode<E> p) {
        if (index == 0)
            return  p.value;
        else{
            p = p.next;
            return helper(--index,p);
        }
    }
}
