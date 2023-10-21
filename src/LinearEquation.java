 public class LinearEquation {
    private final int X1;
    private final int X2;
    private final int Y1;
    private final int Y2;
    private double slope;
    private double yInt;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    public double getDistance() {
        double distance = Math.sqrt(Math.pow((double)X2 - X1, 2) + Math.pow((double)Y2 - Y1, 2));
        distance = roundedToHundredth(distance);
        return distance;
    }

    public double getYInt() {
        yInt = -1 * slope * X1 + Y1;
        yInt = roundedToHundredth(yInt);
        return yInt;
    }

    public String getSlope() {
        int rise = Y2 - Y1;
        int run = X2 - X1;
        slope = (double) rise / run;
        slope = roundedToHundredth(slope);
        if (rise % run == 0) {
            return (rise / run) + "";
        }
        return rise + "/" + run;
    }

    public String getEquation() {
        if (Y1 == Y2) {
            return "y = " + getYInt();
        }
        return "y = " + getSlope() + "x + " + getYInt();
    }

    public String coordinateForX(double x) {
        double y = slope * x + yInt;
        y = roundedToHundredth(y);
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo() {
        if (X1 == X2) {
            return "These points are on a vertical line: x = " + X1;
        }
        return "The equation of the line between these points is: " + getEquation() +
                "\nThe slope of this line is: " + slope +
                "\nThe y-intercept of this line is: " + getYInt() +
                "\nThe distance between these points is " + getDistance();
    }

}
