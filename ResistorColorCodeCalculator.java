import java.util.Scanner;

/**Resistor Color Code Calculator decodes the colors of a resistor's bands to determine its resistance value.
 * 
 * @author BUAN, JANA SOPHIA, RODRIGO
 * @author CALAQUIAN, LOUISE JAVIER, DELOS SANTOS
 * @author EVAL, BRADLEY JAMES, FAGARANG
 * @author GUSTO, ARIANE MAE, BAUTISTA
 */
public class ResistorColorCodeCalculator {
    // Array of color codes in order of their values
    static String[] COLOR_CODES = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    
    // Corresponding digit values for each color
    static int[] DIGIT_VALUES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // Multipliers corresponding to the third band
    static int[] MULTIPLIER_VALUES = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    
    /**
     * Searches for a given color in the COLOR_CODES array and returns its index.
     *
     * @param list The array to search in.
     * @param target The color to search for.
     * @return The index of the color if found, otherwise -1.
     */
    public static int search(String[] list, String target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        return -1; // Returns -1 if the color is not found
    }
    
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in); // Scanner to take user input
        boolean continueProgram = true; // Boolean to check if the program should continue

        while(continueProgram) {
        // Prompt the user for input
        System.out.print("Enter the colors of the resistor’s three bands, beginning with the\r\n" + //
                        "band nearest the end. Type the colors in lowercase letters only,");
        System.out.print("\nNO CAPS.");

        // Read and search for the first band color
        System.out.print("\nBand 1 => ");
        String band1 = scan.next();
        int index1 = search(COLOR_CODES, band1);

        // Read and search for the second band color
        System.out.print("Band 2 => ");
        String band2 = scan.next();
        int index2 = search(COLOR_CODES, band2);

         // Read and search for the third band color 
        System.out.print("Band 3 => ");
        String band3 = scan.next();
        int index3 = search(COLOR_CODES, band3);

        // If any of the colors are not found, print an error message
        if (index1 == -1 ) {
            System.out.println("Invalid color: " + band1);
        } else if (index2 == -1) {
            System.out.println("Invalid color: " + band2);
        } else if (index3 == -1) {
            System.out.println("Invalid color: " + band3);
        } else {
            // Calculate the resistance using the formula (band1 * 10 + band2) * band3
            int resistance = (index1 * 10 + index2) * MULTIPLIER_VALUES[index3];
            // If the resistance is greater than or equal to 1000, print it in kilo-ohms
            if (resistance >= 1000) {
                System.out.println("Resistance value: " + resistance / 1000 + " kilo-ohms");
            } else {
                System.out.println("Resistance value: " + resistance + " ohms");
            }
        }
        
        System.out.print("Do you want to decode another resistor?: ");
        System.out.print("\n=> ");
        String response = scan.next().toLowerCase();
        
        if (response.equals("y") || response.equals("yes")) {
            continueProgram = true;
        } else if (response.equals("n") || response.equals("no")) {
            continueProgram = false;
        } else {
            System.out.println("Invalid response.");
            System.out.print("Do you want to decode another resistor?: ");
            System.out.print("\n=> ");
            response = scan.next().toLowerCase();

            if (response.equals("y") || response.equals("yes")) {
                continueProgram = true;
            } else {
                continueProgram = false;
            }
        }   
        }
    scan.close();
    }
}
