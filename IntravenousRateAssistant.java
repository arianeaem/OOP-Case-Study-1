import java.util.Scanner;

public class IntravenousRateAssistant {
    public static int get_problem(Scanner scan) {
        int choice;

        while (true) {
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
                if (choice >= 1 && choice <= 5) {
                    return choice; // Valid input, return choice
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }
    }

    public static double[] get_rate_drop_factor(Scanner scan) {
        double[] rateDropFactor = new double[2];

        while (true) {
            System.out.print("Enter rate in ml/hr => ");
            if (scan.hasNextDouble()) {
                rateDropFactor[0] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        while (true) {
            System.out.print("Enter tubing's drop factor in drops/ml => ");
            if (scan.hasNextDouble()) {
                rateDropFactor[1] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        return rateDropFactor;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int problem = get_problem(scan);

        switch (problem) {
            case 1:
                double[] rateDropFactor = get_rate_drop_factor(scan);
                double dropRatePerMinute = rateDropFactor[0] * rateDropFactor[1] / 60;
                System.out.println("The drop rate per minute is " + Math.round(dropRatePerMinute) + ".");
                break;
            default:
                System.out.println("Feature not implemented.");
        }

        scan.close(); // Closing Scanner after all inputs
    }
}
