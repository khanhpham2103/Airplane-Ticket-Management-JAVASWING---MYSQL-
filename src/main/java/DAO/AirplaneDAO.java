/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AirplaneDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class AirplaneDAO {

    public ArrayList<AirplaneDTO> list() {
        ArrayList<AirplaneDTO> ds = new ArrayList<>();
        MySQLConnect ms = new MySQLConnect();
        try {
            String sql = "SELECT * FROM airplane";
            System.out.println(sql);
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
//                System.out.println("get data from db");
                String idAirplane = rs.getString("airplaneID");
                String Name = rs.getString("airplaneName");
                String Brand = rs.getString("airplaneBrand");
                String idAirline = rs.getString("airlineID");
                int Eco = Integer.parseInt(rs.getString("ECOseats"));
                int Bus = Integer.parseInt(rs.getString("BUSseats"));
                AirplaneDTO tmp = new AirplaneDTO(idAirplane, Name, Brand, idAirline, Eco, Bus);
                ds.add(tmp);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            System.out.println("Lỗi Kết Nối ");

        }
        return ds;
    }

    public void add(AirplaneDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "INSERT INTO airplane VALUES (";
        sql += "'" + a.getAirplaneID() + "','" + a.getAirplaneName() + "'";
        sql += ",'" + a.getAirplaneBrand() + "','" + a.getAirlineID() + "'";
        sql += ",'" + a.getEcoSeats() + "','" + a.getBusSeats() + "')";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void set(AirplaneDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "UPDATE airplane SET ";
        sql += "airplaneID='" + a.getAirplaneID() + "',";
        sql += "airplaneName='" + a.getAirplaneName() + "',";
        sql += "airplaneBrand='" + a.getAirplaneBrand() + "',";
        sql += "airlineID='" + a.getAirlineID() + "',";
        sql += " ECOseats='" + a.getEcoSeats() + "',";
        sql += "BUSseats='" + a.getBusSeats() + "'";
        sql += " WHERE airplaneID = '" + a.getAirplaneID() + "'";

        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void delete(String ID) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "DELETE FROM airplane WHERE airplaneID = '" + ID + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }
}
