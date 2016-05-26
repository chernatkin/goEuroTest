package org.chernatkin.go;

import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerationException;

public class Main {

    private static final GoEuroClient GO_EURO_CLIENT = new GoEuroClient();
    
    private static final CsvSerializer CSV_SERIALIZER = new CsvSerializer();
    
    
    public static void main(String[] args) {
        
        if(args.length != 1 || StringUtils.isBlank(args[0])){
            System.out.println("Provide not empty city name as parameter");
            System.exit(1);
        }
        
        final String cityName = args[0];
        
        List<City> cities = null;
        try {
            cities = GO_EURO_CLIENT.getCities(cityName);
        } catch (JsonGenerationException jge){
            System.out.println("Failed parse json from goEuro");
            jge.printStackTrace();
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Failed read data from goEuro");
            ioe.printStackTrace();
            System.exit(1);
        }
        

        try {
            CSV_SERIALIZER.writeCityAsCsv(cityName, cities);
        } catch (IOException ioe) {
            System.out.println("Failed write csv data to file:" + cityName);
            ioe.printStackTrace();
            System.exit(1);
        }
        
        System.out.println("Data for city {" + cityName + "} successfully read in file " + cityName);
    }

}
