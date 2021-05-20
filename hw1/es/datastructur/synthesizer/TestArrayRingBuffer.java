package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

//    static ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
    @Test
    public void isEmptyTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
    }

    @Test
    public void emptyDequeExceptionTest(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        try{
            arb.dequeue();
        }catch (RuntimeException ex){
            assertTrue(true);
        }
    }

    @Test
    public void isFullTest(){
        int capacity = 10;
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(capacity);
        for(int i = 0; i < capacity;i++){
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
    }

    @Test
    public void FullEnqueueExceptionTest(){
        int capacity = 10;
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(capacity);
        for(int i = 0; i < capacity;i++){
            arb.enqueue(i);
        }
        try{
            arb.enqueue(11);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    public void testIterator(){
        int capacity = 15;
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(capacity);
        for(int i = 0; i < capacity-5;i++){
            arb.enqueue(i);
        }
        for(int i : arb){
            System.out.println(i);
        }
    }

    @Test
    public void testEquals(){
        int capacity1 = 10;
        ArrayRingBuffer<Integer> arb1 = new ArrayRingBuffer<>(capacity1);
        for(int i = 0; i < capacity1;i++){
            arb1.enqueue(i);
        }

        int capacity2 = 15;
        ArrayRingBuffer<Integer> arb2 = new ArrayRingBuffer<>(capacity2);
        for(int i = -5; i < capacity2-5;i++){
            arb2.enqueue(i);
        }
        for(int i = 0; i < 5; i++)
        arb2.dequeue();

        boolean passed = arb1.equals(arb2);
        assertTrue(passed);


    }
}
