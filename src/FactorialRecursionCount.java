//import java.util.Arrays;

public class FactorialRecursionCount {
    private static int totalfactorialcalls = 0;
    private static int calllevel = 0;

    public static int factorial(int n) throws IllegalArgumentException {
        totalfactorialcalls++;
        calllevel++;
        int returnval;
        //boolean result = false;
        System.out.println("factorial called: n = " + n
                + " totalfactorialcalls = "
                + totalfactorialcalls + " calllevel: " + calllevel);
        if (n < 0)
            throw new IllegalArgumentException();     // argument must be nonnegative
        // Changed this to countdown to n == 1 instead of 0 - same result
        else if (n == 1) {
            System.out.println("Exiting now: base case return = 1"
                    + " calllevel = " + calllevel);
            calllevel--;
            return 1;                                 // base case
        }
        else {
            returnval = n * factorial(n - 1);
            System.out.println("Exiting now: return = " + returnval
                    + " calllevel = " + calllevel);
            calllevel--;
            if (calllevel == 0)
                System.out.println("calllevel now 0: exiting entire recursive function");
            return returnval;
        }
    }

    public static int factorial2(int n) throws IllegalArgumentException {
        int myiter, answer;
        answer = 1;
        if (n < 0)
            throw new IllegalArgumentException();     // argument must be nonnegative
        else for (myiter = n; myiter > 1; myiter--) {
            answer = answer*myiter;
        }
        return answer;
    }

    public static void test() {
        // Test run parameters
        int inputN = 10;
        int timesToRun = 1;
        //int[] inputArray = {2, 5, 8, 13, 2};
        String outputString;

        System.out.println("Running nfactorial...");
        long startTime = System.currentTimeMillis();
        int answer = 0;
        // Must include timesToRun here - function is recursive
        for (int i = 0; i < timesToRun; i++) {
            answer = factorial(inputN);
            //System.out.println(answer);
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        //outputString = new String(Long.toString(elapsed));
        outputString = Long.toString(elapsed);
        System.out.println(outputString);
        double elapsedseconds = (double) elapsed/1000;
        outputString = ("Time in seconds is: " +
                String.format("%.5f", elapsedseconds));
        System.out.println(outputString);
        outputString = ("Factorial of " + inputN + " is: " + answer);
        System.out.println(outputString);
    }

    public static void main(String[] args) {
        test();
    }
}