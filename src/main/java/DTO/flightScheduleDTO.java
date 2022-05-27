
package DTO;

public class flightScheduleDTO {
    private String flightScheduleID;
    private String departureAirport;
    private String arrivalAirport;
    private String weekdays;
    private String time;

    public flightScheduleDTO(String flightScheduleID, String departureAirport, String arrivalAirport, String weekdays, String time) {
        this.flightScheduleID = flightScheduleID;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.weekdays = weekdays;
        this.time = time;
    }

    public String getFlightScheduleID() {
        return flightScheduleID;
    }

    public void setFlightScheduleID(String flightScheduleID) {
        this.flightScheduleID = flightScheduleID;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
