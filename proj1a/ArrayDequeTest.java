public class ArrayDequeTest {
    public static boolean initTest() {
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        return checkSize(0, aDeque.size());

    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed ) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    public static boolean initAddPrintTest() {
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        for (int i = 5; i >= 1; i--) {
            aDeque.addFirst(i);
        }
        for (int i = 6; i <= 8; i++) {
            aDeque.addLast(i);
        }
        boolean passed = checkSize(8, aDeque.size());
//        aDeque.printDeque();

        aDeque.addFirst(0);
        aDeque.printDeque();
        return passed;
    }

    public static boolean initAddRemoveTest() {
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        for (int i = 1; i < 34; i++) {
            aDeque.addLast(i);
        }

        aDeque.printDeque();


        boolean passed = checkSize(64, aDeque.capacity());
        passed = checkSize(33, aDeque.size()) && passed;

//        int a1 = aDeque.removeFirst();
//        int a2 = aDeque.removeLast();
//        System.out.println("first = " + a1 + " last = " + a2);

        for(int i = 0; i < 17; i++){
            int removed = aDeque.removeLast();
            System.out.println("removed = "+removed);
        }
        passed = checkSize(32, aDeque.capacity()) && passed;

        aDeque.printDeque();
        for(int i = 0; i < 2;i++){
            int get = aDeque.get(i);
            System.out.println(i+"th get is "+get);
        }

        return passed;
    }

    public static void main(String[] args) {

//        boolean initRes = initTest();
//        printTestStatus(initRes);

//        initAddPrintTest();

        printTestStatus(initAddRemoveTest());
    }
}
