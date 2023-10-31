 public class LinearEquation {
    private final int X1;
    private final int X2;
    private final int Y1;
    private final int Y2;
    private double slope;
    private double yInt;
    private int rise;
    private int run;

    // Constructor with all points
    public LinearEquation(int x1, int y1, int x2, int y2) {
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
        yInt = 0;
        slope = 0;
    }

    // Takes values and rounds them to the hundredth place
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    // Calculates the distance and the returns the distance of the two coordinates
    public double distance() {
        double distance = Math.sqrt(Math.pow((double)X2 - X1, 2) + Math.pow((double)Y2 - Y1, 2));
        distance = roundedToHundredth(distance);
        return distance;
    }

    // Calculate and Returns the y-intercept of the coordinates
    public double yIntercept() {
        yInt = -1 * slope * X1 + Y1;
        yInt = roundedToHundredth(yInt);
        return yInt;
    }

    // Returns the slope of the two points
    public double slope() {
        rise = Y2 - Y1;
        run = X2 - X1;
        slope = (double) rise / run;
        slope = roundedToHundredth(slope);
        return slope;
    }

    // Returns the equation of the two coordinates
    public String equation() {
        slope();
        yIntercept();

        String equation = "";
        if ((double) rise / run == 1) {
            equation += "y = x";
        }else if ((double) rise / run == -1) {
            equation += "y = -x";
        }else if ((rise / run > 1 && rise % run == 0) || (rise / run < 1 && rise % run == 0)) {
            equation += "y = " + rise / run + "x";
        }else if (run < 0) {
            equation += "y = " + rise * -1 + "/" + run * -1;
        } else {
            equation += "y = " + rise + "/" + run;
        }

        if (yInt == 0 && slope == 0) {
            equation = "y = 0";
        } else if (yInt == 0) {
            equation += "";
        } else if (Y1 == Y2) {
            equation = "y = " + yInt;
        } else if (yInt < 0) {
            equation += " - " + yInt * -1;
        } else {
            equation += " + " + yInt;
        }
        return equation;
    }

    // Does the math for the X-value entered by the user and returns the coordinates for the point
    public String xValue(double x) {
        double y = slope * x + yInt;
        y = roundedToHundredth(y);
        return "(" + x + ", " + y + ")";
    }

    // Returns the info of the two coordinates
    public String lineInfo() {
        if (X1 == X2) {
            return "These points are on a vertical line: x = " + X1;
        }
        return "The two points are: (" + X1 + ", " + Y1 + ") and (" + X2 + ", " + Y2 + ")" +
                "\nThe equation of the line between these points is: " + equation() +
                "\nThe slope of this line is: " + slope +
                "\nThe y-intercept of this line is: " + yInt +
                "\nThe distance between these points is " + distance();
    }

}
