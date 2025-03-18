import java.util.Scanner;

public class IntraveniousRateAssistant {
    // Function to display the user menu, then input and return the selected problem number
    public static int get_problem() {
        Scanner scan = new Scanner(System.in);
        int choice;

        while (true) {
            // Display the problem options to the user
            System.out.println("Enter the number of the problem you wish to solve.");
            System.out.println("\tGIVEN A MEDICAL ORDER IN\t\t\tCALCULATE RATE IN");
            System.out.println("(1)\tml/hr & tubing drop factor\t\t\t   drops / min");
            System.out.println("(2)\t1 L for n hr\t\t\t\t\t     ml / hr");
            System.out.println("(3)\tmg/kg/hr & concentration in mg/ml\t\t     ml / hr");
            System.out.println("(4)\tunits/hr & concentration in units/ml\t\t     ml / hr");
            System.out.println("(5)\tQUIT");

            System.out.print("Problem => ");
            if (scan.hasNextInt()) {
                choice = scan.nextInt();

                // Validate the user's choice
                if (choice >= 1 && choice <= 5) {
                    scan.close();
                    return choice; // Valid input, return choice
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next();
            }
        }
    }
    public static void main(String[] args) {
        
    }
}