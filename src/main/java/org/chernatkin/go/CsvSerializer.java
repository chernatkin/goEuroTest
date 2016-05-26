package org.chernatkin.go;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvSerializer {
    
    private final CsvMapper mapper = new CsvMapper();
    
    private final CsvSchema schema = mapper.schemaFor(City.class).withHeader().withQuoteChar('"');
    
    public void writeCityAsCsv(String file, List<City> cities) throws IOException {
        
        cities = Optional.ofNullable(cities)
                         .orElse(Collections.emptyList());
        
        mapper.writer(schema).writeValues(new File(file)).writeAll(cities);
    }

}
