package dataobjectmap;

public class CityandPopulationMap extends GenericDataReaderIntoMap {

    public CityandPopulationMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/uscities.csv");
    }

    public static void test() {
        CityandPopulationMap objLookup = new CityandPopulationMap();
        objLookup.keyValueLookup();
    }
    public static void main(String[] args) {
        test();
    }


}
