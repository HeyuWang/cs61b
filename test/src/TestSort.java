import org.junit.Test;

public class TestSort {
    /**
     * Tests the sort method of the Sort class.
     */

    @org.junit.Test
    public  void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
//        for(int i = 0; i < input.length; i+=1){
//            if(!input[i].equals(expected[i])){
//                System.out.println("Mismatch in position "+i+", expected : "+expected+", but got: "+input[i]+".");
//                break;
//            }
//        }
        org.junit.Assert.assertArrayEquals(expected, input);
    }
    @org.junit.Test
    public  void testFindSmallestString() {
        String[] input = {"holy", "shit", "the", "crep"};
        int expected = 3;
        int actual = Sort.findSmallestString(input);
        org.junit.Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testInit(){
        boolean b = true;
        org.junit.Assert.assertEquals(true,b);
    }


}
