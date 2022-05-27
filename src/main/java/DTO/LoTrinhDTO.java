/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;



/**
 *
 * @author ASUS
 */
public class LoTrinhDTO {
    private String RouteID,DePartureLocation,ArrivalLocation;

    public LoTrinhDTO() {
    }

    public LoTrinhDTO(String RouteID, String DePartureLocation, String ArrivalLocation) {
        this.RouteID = RouteID;
        this.DePartureLocation = DePartureLocation;
        this.ArrivalLocation = ArrivalLocation;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String RouteID) {
        this.RouteID = RouteID;
    }

    public String getDePartureLocation() {
        return DePartureLocation;
    }

    public void setDePartureLocation(String DePartureLocation) {
        this.DePartureLocation = DePartureLocation;
    }

    public String getArrivalLocation() {
        return ArrivalLocation;
    }

    public void setArrivalLocation(String ArrivalLocation) {
        this.ArrivalLocation = ArrivalLocation;
    }
    public void Output(){
        System.out.println(this.RouteID + " "+ this.DePartureLocation + " "+ this.ArrivalLocation + "\n");
    }

}
