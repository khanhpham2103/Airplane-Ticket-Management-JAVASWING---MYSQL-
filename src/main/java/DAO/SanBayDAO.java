/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanBayDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SanBayDAO {

    public SanBayDAO() {
    }

    public ArrayList<SanBayDTO> list() {
        MySQLConnect ms = new MySQLConnect();
        ArrayList<SanBayDTO> ds = new ArrayList<SanBayDTO>();
        try {
            String sql = "SELECT * FROM airport";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("airportID");
                String Name = rs.getString("airportName");
                String City = rs.getString("airportCity");
                SanBayDTO tmp = new SanBayDTO(id, Name, City);
                ds.add(tmp);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            System.out.println("Lỗi Kết Nối ");
        }
        return ds;

    }

    public void add(SanBayDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "INSERT INTO airport VALUES (";
        sql += "'" + a.getAirportID() + "',";
        sql += "'" + a.getAirportName() + "',";
        sql += "'" + a.getAirPortCity() + "')";
        System.out.println(sql + "\n");
        ms.executeUpdate(sql);
    }

    public void set(SanBayDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "UPDATE airport SET " ;
        sql += "airportID='" + a.getAirportID() + "',";
        sql += "airportName='" + a.getAirportName() + "',";
        sql += "airportCity='" + a.getAirPortCity() + "'";
        sql += " WHERE airportID = '" + a.getAirportID() + "'";
        System.out.println(sql + "\n");
        ms.executeUpdate(sql);
    }

    public void delete(String ID) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " DELETE FROM airport WHERE airportID='" + ID + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);

    }
}
