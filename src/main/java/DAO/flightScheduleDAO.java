package DAO;

import DTO.flightScheduleDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class flightScheduleDAO {

//    private MySQLCOnnect dbc = new MySQLCOnnect();

    public flightScheduleDAO() {
    }

    public ArrayList docdsflightSchedule() {
        MySQLConnect ms = new MySQLConnect();
        ArrayList dsflightSchedule = new ArrayList<flightScheduleDTO>();
        try {
            String sql = "select * from flightSchedule order by time";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String flightScheduleID = rs.getString("flightScheduleID");
                String departureAirport = rs.getString("departureAirport");
                String arrivalAirport = rs.getString("arrivalAirport");
                String weekdays = rs.getString("weekdays");
                String time = rs.getString("time");

                flightScheduleDTO t = new flightScheduleDTO(flightScheduleID, departureAirport, arrivalAirport, weekdays, time);
                dsflightSchedule.add(t);
            }
            ms.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsflightSchedule;
    }

    public void add(flightScheduleDTO tkDTO) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " INSERT INTO flightSchedule VALUES (";
        sql += "'" + tkDTO.getFlightScheduleID() + "',";
        sql += "'" + tkDTO.getDepartureAirport() + "',";
        sql += "'" + tkDTO.getArrivalAirport() + "',";
        sql += "'" + tkDTO.getWeekdays() + "',";
        sql += "'" + tkDTO.getTime() + "')";
        System.out.println(sql + "\n");
        ms.executeUpdate(sql);
    }

    public void set(flightScheduleDTO tk) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " UPDATE flightSchedule SET ";
        sql += "flightScheduleID ='" + tk.getFlightScheduleID() + "', ";
        sql += "departureAirport ='" + tk.getDepartureAirport() + "', ";
        sql += "arrivalAirport ='" + tk.getArrivalAirport() + "', ";
        sql += "weekdays ='" + tk.getWeekdays() + "', ";
        sql += "time ='" + tk.getTime() + "' ";
        sql += "WHERE flightScheduleID ='" + tk.getFlightScheduleID() + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void delete(String ID) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "DELETE FROM flightSchedule WHERE flightScheduleID = '" + ID + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }
    
    public ArrayList getAndSortDateOrderByTime(String weekday) {
        MySQLConnect ms = new MySQLConnect();
        
         ArrayList dsflightSchedule = new ArrayList<flightScheduleDTO>();
        try {
            String sql = "SELECT * FROM flightSchedule WHERE weekdays= '" + weekday + "' ORDER BY TIME";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String flightScheduleID = rs.getString("flightScheduleID");
                String departureAirport = rs.getString("departureAirport");
                String arrivalAirport = rs.getString("arrivalAirport");
                String weekdays = rs.getString("weekdays");
                String time = rs.getString("time");

                flightScheduleDTO fS = new flightScheduleDTO(flightScheduleID, departureAirport, arrivalAirport, weekdays, time);
                dsflightSchedule.add(fS);
            }
            ms.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsflightSchedule;
    }
}
