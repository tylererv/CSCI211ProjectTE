import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapStockSymbol {
    public Map<String, String> stockSymbols;

    public MapStockSymbol() {
        // Step 1: Define the map
        Map<String, String> testStockSymbols = new HashMap<>();
        // Step 2: read the CSV file data into the map
        String fileName = "DataFiles/ThirdPartyDataCSVFiles/stock_symbols.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    testStockSymbols.put(parts[0].trim().toUpperCase(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        stockSymbols = testStockSymbols;
    }

    public static void test() {
        // Test - Create the loaded Map object
        MapStockSymbol ourStockSymbols = new MapStockSymbol();
        // Test operation with user input
        Scanner symbolscanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a stock symbol (or 'quit' to exit): ");
            String symbol = symbolscanner.nextLine().trim().toUpperCase();
            if (symbol.equalsIgnoreCase("quit")) {
                //symbolscanner.close();
                break;
            }
            String description = (String) ourStockSymbols.stockSymbols.get(symbol);
            if (description != null) {
                System.out.println("Description: " + description);
            } else {
                System.out.println("Symbol not found.");
            }
        }
        System.out.println("Thank you for using the Stock Symbol Lookup program");
    }

    public static void main(String[] args) {
        test();
    }
}