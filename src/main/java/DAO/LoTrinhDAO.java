/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoTrinhDTO;
//import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class LoTrinhDAO {

    public LoTrinhDAO() {
    }

    public ArrayList<LoTrinhDTO> list() {
        MySQLConnect ms = new MySQLConnect();

        ArrayList<LoTrinhDTO> ds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM route";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String maLoTrinh = rs.getString("routeID");
                String noiDen = rs.getString("departureLocation");
                String noiDi = rs.getString("arrivalLocation");
//                    System.out.println(maLoTrinh +" "+ noiDen + " "+ noiDi + " ");
                LoTrinhDTO tmp = new LoTrinhDTO(maLoTrinh, noiDen, noiDi);
                ds.add(tmp);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            System.out.println("Lỗi Kết Nối ");
        }
        return ds;
    }

    public void add(LoTrinhDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " INSERT INTO route VALUES (";
        sql += "'" + a.getRouteID() + "',";
        sql += "'" + a.getDePartureLocation() + "',";
        sql += "'" + a.getArrivalLocation() + "')";
        System.out.println(sql + "\n");
        ms.executeUpdate(sql);

    }

    public void set(LoTrinhDTO s) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " UPDATE route SET ";
        sql += "routeID ='" + s.getRouteID() + "', ";
        sql += "departureLocation ='" + s.getDePartureLocation() + "' ,";
        sql += "arrivalLocation ='" + s.getArrivalLocation() + "'";
        sql += "WHERE routeID = '" + s.getRouteID() + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void delete(String ID) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "DELETE FROM route WHERE routeID = '" + ID + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);

    }

}
