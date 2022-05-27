package DTO;

public class ChuyenBayDTO {
    private String flightID;
    private String routeID;  // route tuyến đường
    private String airplaneID;  // airplane máy bay
    private String flightScheduleID;  // schedule lịch trình
    private String departureTime; // departure sự khởi hành
    private String arrivalTime; // arrival đến
    private int totalSeats;  // total seats tổng số ghế
    private String bookedECOSeats;  // bookedECOSeats đã đặt trước
    private String bookedBUSSeats;  // bookedBUSSeats đã đặt chỗ

    public ChuyenBayDTO() {
        flightID = "";
        routeID = "";
        airplaneID = "";
        flightScheduleID = "";
        departureTime = "";
        arrivalTime = "";
        totalSeats = 0;
        bookedECOSeats = "";
        bookedBUSSeats ="";
    }

    public ChuyenBayDTO(String flightID) {
        this.flightID = flightID;
    }

    public ChuyenBayDTO(String flightID, String routeID) {
        this.flightID = flightID;
        this.routeID = routeID;
    }

    public ChuyenBayDTO(String flightID, String routeID, String airplaneID) {
        this(flightID, routeID);
        this.airplaneID = airplaneID;
    }

    public ChuyenBayDTO(String flightID, String routeID, String airplaneID, String flightScheduleID) {
        this(flightID, routeID, airplaneID);
        this.flightScheduleID = flightScheduleID;
    }

    public ChuyenBayDTO(String flightID, String routeID, String airplaneID, String flightScheduleID, String departureTime) {
        this(flightID, routeID, airplaneID, flightScheduleID);
        this.departureTime = departureTime;
    }

    public ChuyenBayDTO(String flightID, String routeID, String airplaneID, String flightScheduleID, String departureTime, String arrivalTime) {
        this(flightID, routeID, airplaneID, flightScheduleID, departureTime);
        this.arrivalTime = arrivalTime;
    }

    public ChuyenBayDTO(String flightID, String routeID, String airplaneID, String flightScheduleID, String departureTime, String arrivalTime, int totalSeats, String bookedECOSeats, String bookedBUSSeats) {
        this.flightID = flightID;
        this.routeID = routeID;
        this.airplaneID = airplaneID;
        this.flightScheduleID = flightScheduleID;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.bookedECOSeats = bookedECOSeats;
        this.bookedBUSSeats = bookedBUSSeats;
    }
    

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getFlightScheduleID() {
        return flightScheduleID;
    }

    public void setFlightScheduleID(String flightScheduleID) {
        this.flightScheduleID = flightScheduleID;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getBookedECOSaets() {
        return bookedECOSeats;
    }

    public void setBookedECOSaets(String bookedECOSeats) {
        this.bookedECOSeats = bookedECOSeats;
    }

    public String getBookedBUSSeats() {
        return bookedBUSSeats;
    }

    public void setBookedBUSSeats(String bookedBUSSeats) {
        this.bookedBUSSeats = bookedBUSSeats;
    }

    @Override
    public String toString() {
        return "ChuyenBayDTO{" + "flightID=" + flightID + ", routeID=" + routeID + ", airplaneID=" + airplaneID + ", flightScheduleID=" + flightScheduleID + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", totalSeats=" + totalSeats + ", bookedECOSeats=" + bookedECOSeats + ", bookedBUSSeats=" + bookedBUSSeats + '}';
    }

}
