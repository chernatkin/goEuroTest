package org.chernatkin.go;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GoEuroClient {
    
    private static final String API_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    public GoEuroClient(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public List<City> getCities(String substring) throws JsonProcessingException, MalformedURLException, IOException {
        final String encodedUrl = API_URL + encode(substring);
        
        final URLConnection connection = new URL(encodedUrl).openConnection();

        try(final InputStream is = connection.getInputStream()){
            return mapper.readValue(is, new TypeReference<List<City>>(){});
        }
    }
    
    private String encode(String encode){
        try {
            return URLEncoder.encode(encode, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException uex) {
            throw new RuntimeException(uex);
        }
    }
}
