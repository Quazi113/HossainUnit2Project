 public class LinearEquation {
    private final int X1;
    private final int X2;
    private final int Y1;
    private final int Y2;

    // Constructor with all points
    public LinearEquation(int x1, int y1, int x2, int y2) {
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
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
        double yInt = -1 * slope() * X1 + Y1;
        yInt = roundedToHundredth(yInt);
        return yInt;
    }

    // Calculates and Returns the slope of the two points
    public double slope() {
        int rise = Y2 - Y1;
        int run = X2 - X1;
        double slope = (double) rise / run;
        slope = roundedToHundredth(slope);
        return slope;
    }

    // Returns the equation of the two coordinates
    public String equation() {
        String equation = "y = ";
        if (slope() == 1) {
            equation += "x";
        } else if (slope() == -1) {
            equation += "-x";
        } else if ((Y2-Y1) % (X2-X1) == 0) {
            equation += ((int)slope()) + "x";
        } else if (X2-X1 < 0) {
            equation += (Y2-Y1) * -1 + "/" + (X2-X1) * -1 + "x";
        } else {
            equation += (Y2-Y1) + "/" + (X2-X1) + "x";
        }

        if (slope() == 0 && yIntercept() == 0) {
            equation = "y = 0";
        } else if (Y1 == Y2) {
            equation = "y = " + yIntercept();
        } else if (yIntercept() == 0) {
            equation += "";
        } else if (yIntercept() < 0) {
            equation += " - " + yIntercept() * -1;
        } else {
            equation += " + " + yIntercept();
        }
        return equation;
    }

    // Does the math for the X-value entered by the user and returns the coordinates for the point
    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
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
                "\nThe slope of this line is: " + slope() +
                "\nThe y-intercept of this line is: " + yIntercept() +
                "\nThe distance between these points is " + distance();
    }

}
