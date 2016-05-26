package org.chernatkin.go;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "type", "latitude", "longitude"})
public class City {
    
    private long id;
    
    private String name;
    
    private String type;
    
    private String latitude;
    
    private String longitude;
    
    @JsonCreator
    public City(@JsonProperty("_id") long id, 
                @JsonProperty("name") String name, 
                @JsonProperty("type") String type, 
                @JsonProperty("geo_position") GeoPosition position) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = position.getLatitude();
        this.longitude = position.getLongitude();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", type=" + type + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
