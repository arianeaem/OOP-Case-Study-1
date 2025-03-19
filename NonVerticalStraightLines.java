import java.util.Scanner;

public class NonVerticalStraightLines {
    Scanner input = new Scanner(System.in);
    
    public int get_problem() {
        int choice;
        
        System.out.println("Select the form that you would like to convert to slope-intercept form:");
        System.out.println("1) Two-point form (you know the points on the line)");
        System.out.println("2) Point-slope form (you know the line's slope and one point)");
        System.out.print("=> ");
        
        choice = input.nextInt();
        System.out.println();
        
        return choice;
    }

    public void get2_pt(double[] points) {
        System.out.print("Enter the x-y coordinates of the first point separated by a space=> ");
        points[0] = input.nextDouble();
        points[1] = input.nextDouble();
        
        System.out.print("Enter the x-y coordinates of the second point separated by a space=> ");
        points[2] = input.nextDouble();
        points[3] = input.nextDouble();
        
        System.out.println();
    }
    
    // Function to convert two-point form to slope-intercept form
    public double intcpt_from_pt_slope(double x, double y, double slope) {
        return y - slope * x;
    }
    
    // Function to display the two-point form and slope-intercept form of a line
    public void display2_pt(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            System.out.println("The line is vertical and cannot be represented in slope-intercept form.");
            return;
            
        } 

        // Calculate the slope and y-intercept of the line
        double slope = (y2 - y1) / (x2 - x1);

        double yIntcpt = intcpt_from_pt_slope(x1, y1, slope);
        yIntcpt = Math.floor(yIntcpt * 100) / 100.0;

        // Display the two-point form and slope-intercept form of the line
        System.out.println("Two-point form");
        System.out.println("\t" + "(" + String.format("%.2f", y2) + " - " + String.format("%.2f", y1) + ")");
        System.out.println("m = -------------------");
        System.out.println("\t" + "(" + String.format("%.2f", x2) + " - " + String.format("%.2f", x1) + ")");

        System.out.println("\nSlope-intercept form");
        System.out.println(String.format("y = %.2fx + %.2f", slope, yIntcpt));
    }
    
    public static void main(String[] args) {
        NonVerticalStraightLines program = new NonVerticalStraightLines();
        
        int choice = program.get_problem();
        
        if (choice == 1) {
            double[] points = new double[4];
            program.get2_pt(points);
            program.display2_pt(points[0], points[1], points[2], points[3]);
        }
    }
}
