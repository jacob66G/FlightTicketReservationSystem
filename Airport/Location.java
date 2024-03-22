package Airport;

import Coordinates.Coordinates;

import java.io.Serializable;

public class Location implements Serializable {
    private String CountryName;
    private String CityName;
    private Coordinates coordinates;

    public Location(String countryName, String cityName, Coordinates coordinates) {
        CountryName = countryName;
        CityName = cityName;
        this.coordinates = coordinates;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
