import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSCI211Menus {
    ArrayList<CSCI211MenuItem> CSCI211MenuItemList;

    public CSCI211Menus() {
        CSCI211MenuItemList = new ArrayList<CSCI211MenuItem>();
        //String[5] csvFile;
        // Read the filenames in the directory
        String directoryPrefix = "DataFiles" + "/" + "ConfigurationCSVFiles";
        ArrayList<String> fileNamesList = new ArrayList<>();
        fileNamesList = UtilityMethods.getFilenames(directoryPrefix);
        //String csvFile;
        for (String newCsvFile : fileNamesList) {
            //System.out.println(newCsvFile);
            String csvFile = directoryPrefix + "/" + newCsvFile;
            //System.out.println(csvFile);
                    //"DataFiles/ConfigurationCSVFiles/ProjectComponentSpreadsheet.csv"; // Path to CSV file
            String line;
            String csvSplitBy = ",";
            int lineno = 0;
            String[] data;
            try (BufferedReader br =
                         new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    //if (lineno == 0) {
                    //    String groupTitle = line.split(csvSplitBy, -1);
                    //}
                    if (lineno > 0) {
                        data = line.split(csvSplitBy, -1);
                        String objectName = data[0].trim();
                        String packageName = data[1].trim();
                        String methodName = data[2].trim();
                        String displayTitle = data[3].trim();
                        String team = data[4].trim();
                        String author = data[5].trim();
                        String notes = data[6].trim();
                        CSCI211MenuItem thisMenuItem =
                                new CSCI211MenuItem(objectName,
                                        packageName,
                                        methodName,
                                        displayTitle, team,
                                        author, notes);
                        CSCI211MenuItemList.add(thisMenuItem);

                    }
                    lineno++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void PrintMenus () {
        // Print the menus
        int i = 0;
        for (CSCI211MenuItem item : CSCI211MenuItemList) {
            i++;
            String team = item.getTeam();
            if (!team.equals(""))
                System.out.println("\nFrom Team: " + team);
            System.out.print(i + ":");
            System.out.print(" " + item.getDisplayTitle());
            System.out.print(" (" + item.getObjectName());
            System.out.println("." + item.getMethodName() + ")");
            String author = item.getAuthor();
            if (!author.equals(""))
                System.out.println("    Contributor: " + author);
        }
    }

    public static void main (String[]args) {
        // Create the menus
        CSCI211Menus myCSCI211Menus = new CSCI211Menus();
        // Print the menus
        myCSCI211Menus.PrintMenus();
    }
}
