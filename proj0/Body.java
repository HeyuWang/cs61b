public class Body {
    public double xxPos; /* current x position */
    public double yyPos; /* current y position */
    public double xxVel; /* current velocity in x direction */
    public double yyVel; /* current velocity in y direction */
    public double mass; /* mass */
    public String imgFileName; /* file depict the body */

    public static double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        double dSquare = dx * dx + dy * dy;
        return Math.sqrt(dSquare);
    }

    private double calcDistanceSquare(Body b) {
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        double dSquare = dx * dx + dy * dy;
        return dSquare;
    }

    public double calcForceExertedBy(Body b) {
        if (this.equals(b)) {
            return 0;
        } else {
            double d = this.calcDistanceSquare(b);
            double f = this.mass * b.mass * Body.G / d;
            return f;
        }
    }

    public double calcForceExertedByX(Body b) {
        double r = this.calcDistance(b);
        double f = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double fx = f * dx / r;
        return fx;
    }

    public double calcForceExertedByY(Body b) {
        double r = this.calcDistance(b);
        double f = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double fy = f * dy / r;
        return fy;
    }

    public double calcNetForceExertedByX(Body[] bArray) {
        double fnetx = 0.0;
        for (Body b : bArray) {
            if (!this.equals(b))
                fnetx += calcForceExertedByX(b);
        }
        return fnetx;
    }

    public double calcNetForceExertedByY(Body[] bArray) {
        double fnety = 0.0;
        for (Body b : bArray) {
            if (!this.equals(b))
                fnety += calcForceExertedByY(b);
        }
        return fnety;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;

        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }

    public void draw(){
        String pic = "./images/"+this.imgFileName;
        
        StdDraw.picture(xxPos, yyPos, pic);
    }
}