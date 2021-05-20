import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFindTest {

    @Test
    //1
    public void testSmallQuickFind() {
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("tinyUF.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int N = sc2.nextInt();
        UnionFind uf = new UnionFind(N);

        long start = System.currentTimeMillis();
        while (sc2.hasNext()) {
            int p = sc2.nextInt();
            int q = sc2.nextInt();

            if (uf.isConnected(p, q))
                continue;
            uf.connect(p, q);
//            System.out.println(p + " "+ q);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(uf.count() + " components total processing time is " + elapsedTime);
    }

    @Test
    //16
    public void testMediumQuickFind() {
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("mediumUF.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int N = sc2.nextInt();
        UnionFind uf = new UnionFind(N);

        long start = System.currentTimeMillis();
        while (sc2.hasNext()) {
            int p = sc2.nextInt();
            int q = sc2.nextInt();

            if (uf.isConnected(p, q))
                continue;
            uf.connect(p, q);
//            System.out.println(p + " "+ q);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(uf.count() + " components total processing time is " + elapsedTime);
    }

    @Test
    // 1992
    public void testLargeQuickFind() {
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("largeUF.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int N = sc2.nextInt();
        UnionFind uf = new UnionFind(N);

        long start = System.currentTimeMillis();
        while (sc2.hasNext()) {
            int p = sc2.nextInt();
            int q = sc2.nextInt();

            if (uf.isConnected(p, q))
                continue;
            uf.connect(p, q);
//            System.out.println(p + " "+ q);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(uf.count() + " components total processing time is " + elapsedTime);
    }
}
