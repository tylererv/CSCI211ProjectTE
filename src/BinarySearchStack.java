import java.util.ArrayDeque;
import java.util.Random;

public class BinarySearchStack {
    ArrayDeque<String> emulateJavaStack = new ArrayDeque<>();
    int totalBinarySearchCalls = 0;
    int calllevel = 0;

    public BinarySearchStack() {
        System.out.println("Created new BinarySearchStack");
    }

    public boolean binarySearch(int[] data, int target, int low, int high) {
        totalBinarySearchCalls++;
        calllevel++;
        boolean result = false;
        //System.out.println("binarySearch called: low = " + low + " high = " + high
        //        + " diff = " + (high - low) + " totalBinarySearchCalls = "
        //        + totalBinarySearchCalls + " calllevel: " + calllevel);
        String pushString = ("binarySearch called: low = " + low + " high = " + high
                + " diff = " + (high - low) + " totalBinarySearchCalls = "
                + totalBinarySearchCalls + " calllevel: " + calllevel);
        //this.emulateJavaStack.push("Pushing " + calllevel);
        this.emulateJavaStack.push(pushString);
        System.out.println("Just pushed...");
        String topElement = this.emulateJavaStack.peekFirst();
        System.out.println("topElement is: " + topElement);
        if (low > high) {
            //System.out.println("Return: false");
            //return false; // interval empty; no match
            result = false;
        } else {
            int mid = (low + high) / 2;                            // truncating division
            if (target == data[mid]) {
                System.out.println("Return: true");
                //return true;
                result = true;
            } // found a match
            else if (target < data[mid]) {
                result = binarySearch(data, target, low, mid - 1);   // recur left of the middle
            } else {
                result = binarySearch(data, target, mid + 1, high);  // recur right of the middle
            }
        }
        System.out.println("Exiting now: result = " + result + " calllevel = " + calllevel);
        topElement = this.emulateJavaStack.pop();
        System.out.println("Just popped...");
        System.out.println("topElement is: " + topElement);
        calllevel--;
        if (calllevel == 0)
            System.out.println("calllevel now 0: exiting entire recursive function");
        return result;
    }

    // Helper methods defined here
    // Those methods needed to run tests on book examples
    public static int[] generateSequentialIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Use this to vary the search terms
    public int[] generateRandomIntArray (int size) {
        // Generate the array
        int[] array = new int[size];
        int low = 0;
        int high = size - 1;
        // Now fill with random integers from low to high
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        double rand0to1;
        int randomrange = high - low;
        int randlowertoupper;
        for (int i = 0; i < size; i++) {
            rand0to1 = rand.nextDouble();
            randlowertoupper = (int) (low + rand0to1 * randomrange);
            array[i] = randlowertoupper;
        }
        return array;
    }

    public static void test() {
        System.out.println("We are here");
        BinarySearchStack myBinarySearchStack = new BinarySearchStack();
        myBinarySearchStack.totalBinarySearchCalls = 0;

        // Test run parameters
        int inputArraySize1 = 134217728;
        int inputArraySize2 = 268435456;
        int timesToRun = 1;

        //int[] inputArray = {2, 5, 8, 13, 2};
        boolean answer = false;
        int[] inputArray;
        int[] searchValues;
        // Benchmark variables
        long startTime, endTime, elapsed;
        String outputString;
        System.out.println("Building random array of search values...");
        searchValues = myBinarySearchStack.generateRandomIntArray(inputArraySize1);
        System.out.println("Building array 1...");
        //inputArray = myBinarySearchStack.generateSequentialIntArray(inputArraySize1);
        inputArray = myBinarySearchStack.generateSequentialIntArray(inputArraySize1);
        System.out.println("Running binary search...");
        startTime = System.currentTimeMillis();
        // Must include timesToRun here - function is recursive
        for (int i = 0; i < timesToRun; i++) {
            answer = myBinarySearchStack.binarySearch(inputArray, searchValues[i],
                    0, inputArray.length);
        }
        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;
        //outputString = new String(Long.toString(elapsed));
        outputString = Long.toString(elapsed);
        System.out.println(outputString);
        double elapsedseconds = (double) elapsed/1000;
        outputString = ("Time in seconds is: " +
                String.format("%.5f", elapsedseconds));
        System.out.println(outputString);
    }

    public static void main(String[] args) {
        // Run test method
        test();
    }
}
