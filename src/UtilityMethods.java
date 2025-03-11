import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class UtilityMethods {

    // Methods should be declared as static for directed use
    // Intended to be called without an instance of the class

    public static String systemCheck() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            System.out.println("Operating System: Mac");
        } else if (osName.contains("windows")) {
            System.out.println("Operating System: Windows");
        } else {
            System.out.println("Operating System: Unknown");
        }
        return osName;
    }

    public static ArrayList<String> getFilenames(String directoryPath) {
        File directory = new File(directoryPath);
        ArrayList<String> filenames = new ArrayList<>();

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        filenames.add(file.getName());
                    }
                }
            } else {
                System.err.println("Error: Could not list files in directory: " + directoryPath);
            }
        } else {
            System.err.println("Error: Not a valid directory: " + directoryPath);
        }
        Collections.sort(filenames);
        return filenames;
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.err.println("Error clearing console: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String mySystem = systemCheck();
    }
}
