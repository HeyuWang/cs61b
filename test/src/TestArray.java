public class TestArray {
    public static void main(String[] args) {

        int[] x = {9, 10, 11, 12, 13};
        int[] y = new int[2];

        int i = 0;
        while (i < x.length) {
            y[i] = x[i];
            i+=1;
        }

    }
}
