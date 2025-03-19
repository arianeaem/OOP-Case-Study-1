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
    
    public static void main(String[] args) {
        NonVerticalStraightLines program = new NonVerticalStraightLines();
        
        int choice = program.get_problem();
        
        if (choice == 1) {
            double[] points = new double[4];
            program.get2_pt(points);
            // Rest of the program would go here
        }
    }
}
