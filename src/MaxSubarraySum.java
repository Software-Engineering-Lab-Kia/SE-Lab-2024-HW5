import java.util.Random;

public class MaxSubarraySum {
    public static int[] generateRandomArray(int size, int maxRange) {
        Random random = new Random(); // Create a Random object for generating random numbers
        int[] array = new int[size];  // Create an array to hold the random numbers

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxRange); // Generate a random number and store it in the array
        }

        return array; // Return the generated array
    }


    public static int badMaxSubarraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        for (int start = 0; start < array.length; start++) {
            for (int end = start; end < array.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += array[i];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int goodMaxSubarraySum(int[] array) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < array.length; i++) {
            maxEndingHere += array[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }



    public static void main(String[] args) {
        int[] randomNumbers = generateRandomArray(10000, 10000);
        System.out.print(badMaxSubarraySum(randomNumbers));
    }


}
