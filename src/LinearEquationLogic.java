import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String coord1;
    private String coord2;
    private LinearEquation coordinates;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
        coordinates = null;
    }
    public void start() {
        userCoords();
        equationInfo();
        xValue();
    }

    // methods
    private void userCoords() {
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
        System.out.println();
    }

    private void accessCoordinates(String coord1, String coord2) {
        x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.length() - 1));
        x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.length() - 1));
    }

    private void equationInfo() {
        System.out.println("The two points are: " + coord1 + " and " + coord2);
        accessCoordinates(coord1, coord2);
        coordinates = new LinearEquation(x1, y1, x2, y2);
        System.out.println(coordinates.lineInfo());
        System.out.println();
    }

    private void xValue() {
        System.out.print("Enter a value for x: ");
        double xValue = scan.nextDouble();
        System.out.println();
        System.out.println("The point on the line is " + coordinates.coordinateForX(xValue));
    }

}
