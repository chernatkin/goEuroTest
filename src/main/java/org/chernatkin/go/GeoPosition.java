package org.chernatkin.go;

public class GeoPosition {
    
    private String latitude;
    
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
    
}
