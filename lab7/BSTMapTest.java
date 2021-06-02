import org.junit.Test;

public class BSTMapTest {
    @Test
    public void testInit(){
        BSTMap<Integer,Integer> map = new BSTMap<>();
        for(int i = 0; i < 20000; i++){
            map.put(i,i);
        }

//        map.print();
    }
}
