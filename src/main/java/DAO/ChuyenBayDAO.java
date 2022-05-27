package DAO;

import DTO.ChuyenBayDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChuyenBayDAO {

    public ChuyenBayDAO() {
    }

    public static ArrayList<ChuyenBayDTO> list() {
        ArrayList<ChuyenBayDTO> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from flight";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String flightID = rs.getString("flightID");
                String routeID = rs.getString("routeID");
                String airplaneID = rs.getString("airplaneID");
                String flightScheduleID = rs.getString("flightScheduleID");
                String departureTime = rs.getString("departureTime");
                String arrivalTime = rs.getString("arrivalTime");
                int totalSeats = Integer.parseInt(rs.getString("totalSeats"));
                String bookedECOSeats = rs.getString("bookedECOSeats");
                String bookedBUSSeats = rs.getString("bookedBUSSeats");
                ChuyenBayDTO cbDTO = new ChuyenBayDTO(flightID, routeID, airplaneID, flightScheduleID, departureTime, arrivalTime, totalSeats, bookedECOSeats, bookedBUSSeats);
                ds.add(cbDTO);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }

    public void add(ChuyenBayDTO cb) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "insert into flight values ("
                + "'" + cb.getFlightID() + "'"
                + ",'" + cb.getRouteID() + "'"
                + ",'" + cb.getAirplaneID() + "'"
                + ",'" + cb.getFlightScheduleID() + "'"
                + ",'" + cb.getDepartureTime() + "'"
                + ",'" + cb.getArrivalTime() + "'"
                + ",'" + cb.getTotalSeats() + "'"
                + ",'" + cb.getBookedECOSaets() + "'"
                + ",'" + cb.getBookedBUSSeats() + "')";
        mySQL.executeUpdate(qry);
    }

    public void delete(String ID) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "delete from flight where flightID = '" + ID + "'";
        mySQL.executeUpdate(qry);
    }

    public void set(ChuyenBayDTO cb) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "update flight set "
                + "routeID = '" + cb.getRouteID() + "'"
                + ",airplaneID = '" + cb.getAirplaneID() + "'"
                + ",flightScheduleID = '" + cb.getFlightScheduleID() + "'"
                + ",departureTime = '" + cb.getDepartureTime() + "'"
                + ",arrivalTime = '" + cb.getArrivalTime() + "'"
                + ",totalSeats = '" + cb.getTotalSeats() + "'"
                + ",bookedECOSeats = '" + cb.getBookedECOSaets() + "'"
                + ",bookedBUSSeats = '" + cb.getBookedBUSSeats() + "'"
                + " where flightID = '" + cb.getFlightID() + "'";
        mySQL.executeUpdate(qry);
    }

    public ArrayList<String> getRouteID() {
        ArrayList<String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select routeID, departureLocation, arrivalLocation from route";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String routeID = rs.getString("routeID");
                String departureLocation = rs.getString("departureLocation");
                String arrivalLocation = rs.getString("arrivalLocation");
                dsID.add(routeID + " (" + departureLocation + " - " + arrivalLocation + ")");
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }

    public ArrayList<String> getAirplaneID() {
        ArrayList<String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select airplaneID, airplaneName from airplane";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String airplaneID = rs.getString("airplaneID");
                String airplaneName = rs.getString("airplaneName");
                dsID.add(airplaneID + " (" + airplaneName + ")");
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }

    public ArrayList<String> getSeats(String ID) {
        ArrayList<String> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "SELECT SUM(ECOseats + BUSseats) AS totalSeats, ECOseats, BUSseats FROM airplane WHERE airplaneID = " + "'" + ID + "'";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String totalSeats = rs.getString("totalSeats");
                ds.add(totalSeats);
                String ECOseats = rs.getString("ECOseats");
                ds.add(ECOseats);
                String BUSseats = rs.getString("BUSseats");
                ds.add(BUSseats);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }

    public ArrayList<String> getFlightScheduleID() {
        ArrayList<String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from flightschedule";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String flightScheduleID = rs.getString("flightScheduleID");
                String departureAirport = rs.getString("departureAirport");
                String arrivalAirport = rs.getString("arrivalAirport");
                String weekdays = rs.getString("weekdays");
                String time = rs.getString("time");
                dsID.add(flightScheduleID + " (" + departureAirport + "-" + arrivalAirport + "/" + weekdays + "/" + time + ")");
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }
    
    public ArrayList<String> getAirportID() {
        ArrayList<String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select airportID, airportCity from airport";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String airportID = rs.getString("airportID");
                String airportName = rs.getString("airportCity");
                dsID.add(airportID + " ("+ airportName +")");
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }
    
    public void updateAmountECO(String flightId, String seat) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "update flight set "
                + "bookedECOSeats = '" + seat + "'"
                + " where flightID = '" + flightId + "'";
        mySQL.executeUpdate(qry);
        System.out.println(qry);
    }
    
    public void updateAmountBUS(String flightId, String seat) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "update flight set "
                + "bookedBUSSeats = '" + seat + "'"
                + " where flightID = '" + flightId + "'";
        mySQL.executeUpdate(qry);
        System.out.println(qry);
    }
    
//    public static void main(String[] args) {
//        ArrayList <String> list = getSeats("A220");
//        for(String str : list){
//            System.out.println(str);
//        }
//    }
}

/**
 *
 * @author PHAM PHU KHANH
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
