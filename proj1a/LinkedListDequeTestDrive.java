public class LinkedListDequeTestDrive {
    public static boolean checkConstructor() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        if (deque.size() == 0) {
            System.out.println("Constructor success");
            return true;
        }
        System.out.println("Constructor success");
        return false;
    }


    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected " + expected);
            return false;
        }

        return true;
    }

    public static void printTestResults(boolean passed) {
        if (passed) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    public static void initAddEmptySizeTest() {
        System.out.println("Running init addFirst test");

        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        boolean passed = checkEmpty(true, deque.isEmpty());


        deque.addFirst(1);
        passed = checkSize(1, deque.size()) && passed;
        deque.printDeque();


        deque.addFirst(2);
        passed = checkSize(2, deque.size()) && passed;
        deque.printDeque();

        printTestResults(passed);
    }

    public static void initAddLastSizeTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();

        deque.addLast(1);
        boolean passed = checkSize(1, deque.size());

        deque.addLast(2);
        passed = checkSize(2, deque.size()) && passed;
        deque.printDeque();

        printTestResults(passed);
    }

    public static void removeTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();

        for (int i = 1; i < 21; i++) {
            deque.addLast(i);
        }
        deque.printDeque();

        for (int i = 0; i < 5; i++) {
            int temp = deque.removeFirst();
            System.out.println("returned " + temp);
        }
        boolean passed = checkSize(15, deque.size());

        for (int i = 0; i < 5; i++) {
            int temp = deque.removeLast();
            System.out.println("returned " + temp);
        }
        passed = checkSize(10, deque.size()) && passed;


        deque.printDeque();

        printTestResults(passed);
    }

    public static void getTest(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        for(int i = 10; i >= 1; i--){
            deque.addFirst(i);
        }
        for(int i = 11; i < 16; i++){
            deque.addLast(i);
        }

        boolean passed = checkSize(15, deque.size());

        for(int i = 0; i < 5; i++){
            int val = deque.get(i);
            int val2 = deque.getRecursive(i);
            System.out.println(val);
        }

        printTestResults(passed);

    }

    public static void main(String[] args) {
//        checkConstructor();
//        initAddEmptySizeTest();
//        initAddLastSizeTest();
//        removeTest();
        getTest();
    }




}

