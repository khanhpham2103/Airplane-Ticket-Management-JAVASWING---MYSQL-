/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BanVeDTO1;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.ticketDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class BanVeDAO {

    public ArrayList<BanVeDTO1> ListChuyenBayTable() {
        ArrayList<BanVeDTO1> ds = new ArrayList<>();
        MySQLConnect ms = new MySQLConnect();
        try {
//            String sql = "SELECT flight.*, airplane.*,route.* FROM `flight`,airplane,route WHERE airplane.airplaneID= flight.airplaneID and flight.routeID = route.routeID";
            String sql = "SELECT flight.*, airplane.*,flightschedule.* FROM `flight`,airplane,flightschedule WHERE airplane.airplaneID= flight.airplaneID and flight.flightScheduleID=flightschedule.flightScheduleID;";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String MaChuyenBay = rs.getString("flightID");
                String LoTrinh = rs.getString("routeID");
                String ThoiGianDi = rs.getString("arrivalTime");
                String ThoiGianDen = rs.getString("departureTime");
                String SanBayCatCanh = rs.getString("arrivalAirport");
                String SanBayHaCanh = rs.getString("departureAirport");
                String ecoNum = rs.getString("bookedECOSeats");
                String busNum = rs.getString("bookedBUSSeats");
                BanVeDTO1 tmp = new BanVeDTO1(MaChuyenBay, LoTrinh, ThoiGianDi, ThoiGianDen, SanBayCatCanh, SanBayHaCanh,ecoNum,busNum);

//                BanVeDTO1 tmp = new BanVeDTO1(MaChuyenBay, LoTrinh, ThoiGianDi, ThoiGianDen, SanBayCatCanh, SanBayHaCanh);
                ds.add(tmp);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            System.out.println("Lỗi Kết Nối ");
        }
        return ds;
    }

    public ArrayList<String> GetMaxPerType() {
        ArrayList<String> ds = new ArrayList<>();
        MySQLConnect ms = new MySQLConnect();
        try {
//            String sql = "SELECT flight.*, airplane.*,route.* FROM `flight`,airplane,route WHERE airplane.airplaneID= flight.airplaneID and flight.routeID = route.routeID";
            String sql = "(SELECT ticketID FROM `ticket` WHERE typeID =\"BUS\" ORDER BY `ticket`.`ticketID` DESC LIMIT 0,1)UNION (SELECT ticketID FROM `ticket` WHERE typeID =\"ECO\" ORDER BY `ticket`.`ticketID` DESC LIMIT 0,1);";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String hd = rs.getString("ticketID");
                ds.add(hd);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            System.out.println("Lỗi Kết Nối ");
        }
        return ds;
    }

    public void AddInvoice(HoaDonDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "INSERT INTO invoice VALUES (";
        sql += "'" + a.getInvoiceID() + "'";
        sql += ",'" + a.getStaffID() + "'";
        sql += ",'" + a.getCustomerID() + "'";
        sql += "," + a.getInvoiceTotal() + "'";
        sql += "";

    }

}
