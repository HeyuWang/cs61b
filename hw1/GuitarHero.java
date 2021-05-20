import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    public static final String keyboard = "qwertyuiop[]asdfghjkl;'zxcvbnm,.12345";

//            "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "

    public static void main(String[] args) {

        /*init*/
        int charNum = keyboard.length();
        GuitarString[] guitarStringArr = new GuitarString[charNum];
        double[] frequencyArr = new double[charNum];
        for (int i = 0; i < charNum; i++) {
            double exp = (double)(i-24) / (double)(12);
            frequencyArr[i] = 440.0 * Math.pow(2, exp);
            guitarStringArr[i] = new GuitarString(frequencyArr[i]);
        }

        while (true) {
            try{
                /* check if the user has typed a key; if so, process it */
                int idx;
                if (StdDraw.hasNextKeyTyped()) {
                    char key = StdDraw.nextKeyTyped();
                    idx = keyboard.indexOf(key);
                    if (idx < 0) {
                        System.out.println("illegal input");
                        continue;
                    } else {
                        System.out.println("idx " + idx + " is pressed it's frequency is " + frequencyArr[idx]);
                        guitarStringArr[idx].pluck();
                    }

                }

                /* compute the superposition of samples */
                double sample = 0.0;
                for (int i = 0; i < charNum; i++) {
                    sample += guitarStringArr[i].sample();
                }


                /* play the sample on standard audio */
                StdAudio.play(sample);

                /* advance the simulation of each guitar string by one step */
                for (int i = 0; i < charNum; i++)
                    guitarStringArr[i].tic();
            }catch(RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
