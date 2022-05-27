package DTO;

public class HHKhongDTO {
    private String airlineID;
    private String airlineName;

    public HHKhongDTO() {
    }
    
    public HHKhongDTO(String airlineID, String airlineName) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {
        return "HHKhongDTO{" + "airlineID=" + airlineID + ", airlineName=" + airlineName + '}';
    }
    
    
}

/**
 *
 * @author PHAM PHU KHANH
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
