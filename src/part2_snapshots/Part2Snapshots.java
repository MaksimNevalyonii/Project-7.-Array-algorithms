package part2_snapshots;

import java.util.Random;

/**
 * Part 2. Iteration snapshots of bubble sort for a random array of 5 elements.
 * Swapped pairs are wrapped in ** ** (Markdown bold) so the output can be
 * pasted into the assignment editor and the bold applied there.
 */
public class Part2Snapshots {

    private static final int LENGTH = 5;

    // Part 2.1 Create a random array with 5 elements
    public static int[] createRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    // Part 2.2 Build one snapshot line; the pair at swapIndex and swapIndex + 1 is bold
    // (pass -1 when nothing was swapped)
    public static String snapshot(int[] array, int swapIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == swapIndex) {
                sb.append("**").append(array[i]).append("  ").append(array[i + 1]).append("**  ");
                i++; // the second element of the pair is already printed
            } else {
                sb.append(array[i]).append("  ");
            }
        }
        return sb.toString().trim();
    }

    // Part 2.3 Bubble sort which prints a snapshot for every iteration
    public static void bubbleSortWithSnapshots(int[] array) {
        int n = array.length;
        // Outer loop
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Outer loop, iteration " + (i + 1) + ":");
            System.out.println(snapshot(array, -1));
            System.out.println("Inner loop:");
            // Inner loop
            for (int j = 0; j < n - 1; j++) {
                int swapIndex = -1;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapIndex = j; // remember the swapped pair for bold output
                }
                System.out.println("iteration " + (j + 1) + ":  " + snapshot(array, swapIndex));
            }
        }
    }

    // Part 2. Main
    public static void main(String[] args) {
        int[] array = createRandomArray(LENGTH);
        System.out.println("Initial array:");
        System.out.println(snapshot(array, -1));
        bubbleSortWithSnapshots(array);
        System.out.println("Sorted array:");
        System.out.println(snapshot(array, -1));
    }
}