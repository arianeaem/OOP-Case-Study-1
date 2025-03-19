import java.util.Scanner;

public class ResistorColorCodeCalculator {
    static String[] COLOR_CODES = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    static int[] DIGIT_VALUES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] MULTIPLIER_VALUES = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    
    // Searches for a color in the COLOR_CODES array and returns its index
    public static int search(String[] list, String target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        return -1; // Returns -1 if the color is not found
    }
    
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in); // Scanner to take user input

        System.out.print("Enter the colors of the resistor’s three bands, beginning with the\r\n" + //
                        "band nearest the end. Type the colors in lowercase letters only,");
        System.out.print("\nNO CAPS.");

        System.out.print("\nBand 1 => ");
        String band1 = scan.next();
        int index1 = search(COLOR_CODES, band1);
        
        System.out.print("Band 2 => ");
        String band2 = scan.next();
        int index2 = search(COLOR_CODES, band2);
        
        System.out.print("Band 3 => ");
        String band3 = scan.next();
        int index3 = search(COLOR_CODES, band3);

        scan.close(); // Closing scanner to prevent resource leaks
    }
}

