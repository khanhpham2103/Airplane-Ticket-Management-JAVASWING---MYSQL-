/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class SanBayDTO {
    private String airportID , airportName, airPortCity;

    public SanBayDTO() {
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirPortCity() {
        return airPortCity;
    }

    public void setAirPortCity(String airPortCity) {
        this.airPortCity = airPortCity;
    }

    public SanBayDTO(String airportID, String airportName, String airPortCity) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airPortCity = airPortCity;
    }

    public SanBayDTO(String airportID) {
        this.airportID = airportID;
    }

}
