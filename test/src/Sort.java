public class Sort {
    public static void sort(String[] x){
        /*
        * find the smallest
        * move to the front
        * sort rest
        * */


//        for(int i = 0; i < x.length; i++){
//            int smallest = i;
//            for(int j = i+1; j < x.length;j++){
//                if(x[j] < x[smallest])
//                    smallest=j;
//            }
//            swap(x,i,smallest);
//        }
    }

    /*Returns the smallest string in x
    * @source got help with string compares from
    * https://stackoverflow.com/questions/5153496/how-can-i-compare-two-strings-in-java-and-define-which-of-them-is-smaller-than-t*/
    protected static int findSmallestString(String[] x){
        int smallest = 0;
        for(int i = 0; i < x.length; i++){
            int cmp = x[i].compareTo(x[smallest]);
            if (cmp < 0)
                smallest = i;
        }
        return smallest;
    }
}
