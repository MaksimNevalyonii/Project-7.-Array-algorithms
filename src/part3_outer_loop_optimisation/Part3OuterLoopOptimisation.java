package part3_outer_loop_optimisation;

import java.util.Random;
import java.util.Scanner;

/**
 * Part 3. Bubble sort with outer loop optimisation.
 * If a whole pass of the inner loop makes no swap, the array is already
 * sorted and the outer loop stops early.
 */
public class Part3OuterLoopOptimisation {

    // Array output
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    // Creation of an array of given length with random values
    public static int[] createRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    // Creation of an array of given length with values from user input
    public static int[] createArrayFromInput(Scanner scanner, int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = readInt(scanner);
        }
        return array;
    }

    // Part 3. Bubble sort with outer loop optimisation
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // did this pass change anything?
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // No swaps in a full pass: the array is sorted, stop the outer loop
            if (!swapped) {
                break;
            }
        }
    }

    // Helper: reads an integer, repeats until the input is valid
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Not a number, try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Main flow (same as Part 1)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;
        do {
            System.out.print("Enter number of elements: ");
            int length = readInt(scanner);
            while (length <= 0) {
                System.out.print("Number must be positive, try again: ");
                length = readInt(scanner);
            }

            System.out.print("Generate values randomly? (y - generate, n - input manually): ");
            String choice = scanner.next();

            int[] array;
            if (choice.equalsIgnoreCase("y")) {
                array = createRandomArray(length);
            } else {
                array = createArrayFromInput(scanner, length);
            }

            System.out.println("Given array:");
            printArray(array);

            bubbleSort(array);

            System.out.println("Sorted array:");
            printArray(array);

            System.out.print("Repeat? (y/n): ");
            repeat = scanner.next();
        } while (repeat.equalsIgnoreCase("y"));
        scanner.close();
    }
}