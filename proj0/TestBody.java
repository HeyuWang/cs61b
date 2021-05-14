public class TestBody {
    public static void main(String[] args) {
        System.out.println(new TestBody().calForce());
    }

    private double calForce(){
        Body b1 = new Body(0,0,1,1,10e10,"test.gif");
        Body b2 = new Body(11,12,2,2,9e10,"test.gif");
        return b1.calcForceExertedBy(b2);
    }
}
