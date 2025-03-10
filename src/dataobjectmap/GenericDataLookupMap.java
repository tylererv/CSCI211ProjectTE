package dataobjectmap;

public class GenericDataLookupMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv
    public GenericDataLookupMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/CityAndPopulation.csv");
    }

    public static void test() {
        //String fileName = "DataFiles/CityAndPopulation.csv";
        GenericDataLookupMap objLookup;
        objLookup = new GenericDataLookupMap();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
