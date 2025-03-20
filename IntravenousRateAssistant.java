import java.util.Scanner;

// Intravenous Rate Assistant helps medical professionals calculate IV drip rates based in user input.
public class IntravenousRateAssistant {

    /**Function to get the problem number from the user.
     * 
     * @param scan Scanner object to read user input.
     * @return The problem number selected by the user.
     */
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
    
    /**Function to get the rate and drop factor from the user.
     * Ensures that valid numerical inputs are entered.
     * 
     * @param scan Scanner object to read user input.
     * @return An array containing the rate and drop factor entered by the user.
     */
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

    // Function to get the mg/kg/hr rate, patient weight, and concentration from the user
    public static double[] get_kg_rate_conc(Scanner scan) {
        double[] kgRate = new double[3];

        while (true) {
            System.out.print("Enter rate in mg/kg/hr => ");
            if (scan.hasNextDouble()) {
                kgRate [0] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        while (true) {
            System.out.print("Enter patient weight in kg => ");
            if (scan.hasNextDouble()) {
                kgRate [1] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        while (true) {
            System.out.print("Enter concentration in mg/ml => ");
            if (scan.hasNextDouble()) {
                kgRate [2] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        return kgRate;
    }


    // Function to get the units/hr rate and concentration from the user
    public static double[] get_units_conc(Scanner scan) {
        double[] unitsRate = new double[2];

        while (true) {
            System.out.print("Enter rate in units/hr => ");
            if (scan.hasNextDouble()) {
                unitsRate[0] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        while (true) {
            System.out.print("Enter concentration in units/ml => ");
            if (scan.hasNextDouble()) {
                unitsRate[1] = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume invalid input
            }
        }

        return unitsRate;
    }

    public static int fig_drops_min(double rate, double dropFactor) {
        return (int) Math.round((rate * dropFactor) / 60);
    }

    public static int fig_ml_hr(double hours) {
        return (int) Math.round(1000 / hours);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("INTRAVENOUS RATE ASSISTANT\n");
        int problem;
        do{
            problem = get_problem(scan);
            switch (problem) {
                case 1:
                    double[] rateDropFactor = get_rate_drop_factor(scan);
                    int dropRatePerMinute = fig_drops_min(rateDropFactor[0], rateDropFactor[1]);
                    System.out.println("The drop rate per minute is " + Math.round(dropRatePerMinute) + ".\n");
                    break;
                case 2:
                    System.out.print("Enter number of hours => ");
                    double hours = scan.nextDouble();
                    int mlPerHour = fig_ml_hr(hours);
                    System.out.println("The rate in milliliters per hour is " + mlPerHour + ".\n");
                    break;
                case 3:
                    double[] kgRate = get_kg_rate_conc(scan);
                    double mlPerHour2 = (kgRate[0] * kgRate[1]) / kgRate[2];
                    System.out.println("The rate in ml/hr is " + Math.round(mlPerHour2) + ".\n");
                    break;
                case 4:
                    double[] rateDropFactor_by_weight = get_units_conc(scan);
                    double dropRatePerMilliliters = rateDropFactor_by_weight[0] / rateDropFactor_by_weight [1];
                    System.out.println("The rate in milliliters per hour " + Math.round(dropRatePerMilliliters) + ".\n");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Feature not implemented.");
            }
        }while (problem != 5); // Exit loop when user selects 5
        scan.close(); // Closing Scanner after all inputs
    }
}
