public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);

        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int nBody = in.readInt();
        in.readDouble();

        Body[] bArray = new Body[nBody];

        for (int i = 0; i < nBody; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String pic = in.readString();
            bArray[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, pic);
        }
        return bArray;

    }

    public static void main(String[] args) {
        /* collecting all needed input: T dt filename and radius */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);

        /* drawing the background */
        // StdDraw.enableDoubleBuffering();
        // StdDraw.setScale(-radius,radius);
        // StdDraw.clear();
        // String imageToDraw = "./images/starfield.jpg";
        // StdDraw.picture(0, 0, imageToDraw);
        // Body[] bArray = NBody.readBodies(filename);
        // for(Body b:bArray){
        // b.draw();
        // }

        // StdDraw.show();
        // StdDraw.pause(2000);

        /* animation */
        String imageToDraw = "./images/starfield.jpg";
        Body[] bArray = NBody.readBodies(filename);
        StdDraw.enableDoubleBuffering();
        double curt = 0;
        double[] xForces = new double[bArray.length];
        double[] yForces = new double[bArray.length];
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        while (curt <= T) {
            for (int i = 0; i < xForces.length; i++) {
                xForces[i] = bArray[i].calcNetForceExertedByX(bArray);
            }
            for (int i = 0; i < yForces.length; i++) {
                yForces[i] = bArray[i].calcNetForceExertedByY(bArray);
            }
            StdDraw.picture(0, 0, imageToDraw);
            for (int i = 0; i < bArray.length; i++) {
                bArray[i].update(dt, xForces[i], yForces[i]);
                bArray[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            curt += dt;

        }

        StdOut.printf("%d\n",bArray.length);
        StdOut.printf("%.2e\n",radius);
        for(int i = 0; i < bArray.length; i++)
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bArray[i].xxPos,bArray[i].yyPos,bArray[i].xxVel,
            bArray[i].yyVel,bArray[i].mass,bArray[i].imgFileName);

    }

}
