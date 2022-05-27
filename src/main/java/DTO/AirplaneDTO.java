/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class AirplaneDTO {

    String airplaneID, airplaneName, airplaneBrand, airlineID;
    int EcoSeats, BusSeats;

    public AirplaneDTO() {
    }

    public AirplaneDTO(String airplaneID, String airplaneName, String airplaneBrand, String airlineID, int EcoSeats, int BusSeats) {
        this.airplaneID = airplaneID;
        this.airplaneName = airplaneName;
        this.airplaneBrand = airplaneBrand;
        this.airlineID = airlineID;
        this.EcoSeats = EcoSeats;
        this.BusSeats = BusSeats;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getAirplaneBrand() {
        return airplaneBrand;
    }

    public void setAirplaneBrand(String airplaneBrand) {
        this.airplaneBrand = airplaneBrand;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public int getEcoSeats() {
        return EcoSeats;
    }

    public void setEcoSeats(int EcoSeats) {
        this.EcoSeats = EcoSeats;
    }

    public int getBusSeats() {
        return BusSeats;
    }

    public void setBusSeats(int BusSeats) {
        this.BusSeats = BusSeats;
    }

    public void Output() {
        System.out.println(this.airplaneID + " " + this.airplaneName+ " "+this.airplaneBrand + "  "+this.airlineID + " " + this.EcoSeats + " "+ this.BusSeats + "\n");

    }

}
