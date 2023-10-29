import java.util.Scanner;
public class LinearEquationLogic {
    private final Scanner scan;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String coord1;
    private String coord2;
    private LinearEquation coordinates;

    // Creates object
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
        coordinates = null;
    }

    // Starts the program
    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        userCoords();
        equationInfo();
        coordinateForX();
        loop();
    }

    // Asks user for coordinates and stores into variables
    private void userCoords() {
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
        System.out.println();
    }

    // Uses parsed coordinates to create an object with the points and returns info of the two coordinates
    private void equationInfo() {
        accessCoordinates(coord1, coord2);
        coordinates = new LinearEquation(x1, y1, x2, y2);
        System.out.println(coordinates.lineInfo());
        System.out.println();
    }

    // Asks the user for an X value and presents the coordinates for the value
    private void coordinateForX() {
        if (x1 != x2) {
            System.out.print("Enter a value for x: ");
            double xCoordinate = scan.nextDouble();
            scan.nextLine();
            System.out.println("The point on the line is " + coordinates.xValue(xCoordinate));
            System.out.println();
        }
    }

    // Loops the code when user would like to enter more coordinates
    private void loop() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String answer = scan.nextLine();
        if (answer.equals("y")) {
            userCoords();
            equationInfo();
            coordinateForX();
            loop();
        } else {
            System.out.println("Thank you for using the slope calculator, goodbye!");
        }
    }

    // Takes coordinate strings and parses them into integers
    private void accessCoordinates(String coord1, String coord2) {
        x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.length() - 1));
        x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.length() - 1));
    }

}
