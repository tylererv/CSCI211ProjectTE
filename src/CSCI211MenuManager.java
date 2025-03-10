import songboard.SongBoard;
import java.util.Scanner;
//import songboard.SongBoard;

public class CSCI211MenuManager {

    public CSCI211MenuManager() {
        // First get CSCI211Menus
        CSCI211Menus allMenuItems = new CSCI211Menus();
        Scanner scanner = new Scanner(System.in);
        String inputChar = "User selection";
        char firstChar = '0';
        while (firstChar != 'Q') {
            // Now print the menus
            //UtilityMethods.clearScreen();
            System.out.println("\n\n>>>> Welcome to the CSCI-211 Code Products Page <<<<\n");
            System.out.println("Choose an application to run from the following:");
            allMenuItems.PrintMenus();
            System.out.print("\nEnter letter or number with selection (followed by return): ");
            //inputChar = scanner.next().toUpperCase().charAt(0);
            inputChar = scanner.next();
            System.out.println("input is: " + inputChar);
            firstChar = inputChar.toUpperCase().charAt(0);
            int inputint = 0;
            try {
                inputint = Integer.parseInt(inputChar);
                //System.out.println("Integer value using parseInt(): " + inputint);
            } catch (NumberFormatException e) {
                //System.err.println("Invalid selection: couldn't convert to int");
            }
            int indexNum = inputint - 1;
            if (indexNum >= 0 &&
                    indexNum <= allMenuItems.CSCI211MenuItemList.size()) {
                System.out.println("selection is: " + inputint);
                System.out.println("\n\n------------------");
                System.out.println("Run Begins...\n\n");
                // Now identify the item - minus one for 0 index
                CSCI211MenuItem selectedItem =
                    allMenuItems.CSCI211MenuItemList.get(indexNum);
                String selectedClass = selectedItem.getObjectName();
                String selectedPackage = selectedItem.getPackageName();
                String selectedMethod = selectedItem.getMethodName();
                String fullyQualifiedClass = selectedClass;
                if (!selectedPackage.equals("")) {
                    //System.out.println("selectedPackage is not blank");
                    //System.out.println(selectedPackage);
                    fullyQualifiedClass = selectedPackage + "." + selectedClass;
                }
                //if (selectedClass.equals("SongBoard")) {
                //    selectedClass = "songboard.SongBoard";
                //}
                try {
                    // Load the class
                    Class<?> classObject =
                            Class.forName(fullyQualifiedClass);
                    // Invoke a static method (must be static)
                    classObject.getMethod(selectedMethod).invoke(null);
                    System.out.println ("\n\nRun Completed");
                    System.out.println ("------------------");
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not found: " + e.getMessage());
                } catch (NoSuchMethodException e) {
                    System.err.println("Method not found: " + e.getMessage());
                } catch (IllegalAccessException e) {
                    System.err.println("Illegal access: " + e.getMessage());
                } catch (java.lang.reflect.InvocationTargetException e) {
                    System.err.println("Invocation exception: " + e.getCause().getMessage());
                }
            }
            else
                if (firstChar != 'Q')
                    System.out.println("Invalid selection");
        }
        scanner.close();
    }

    public static void test() {
        CSCI211MenuManager myMenuManager = new CSCI211MenuManager();
    }

    public static void main(String[] args) {
        test();
    }
}


