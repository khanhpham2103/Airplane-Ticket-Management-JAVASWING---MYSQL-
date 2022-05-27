package DAO;

import DTO.HHKhongDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HHKhongDAO {
    
    public HHKhongDAO() {
    }
    
    public ArrayList<HHKhongDTO> list() {
        ArrayList<HHKhongDTO> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from airline";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String airlineID = rs.getString("airlineID");
                String airlineName = rs.getString("airlineName");
                HHKhongDTO hhk = new HHKhongDTO(airlineID, airlineName);
                ds.add(hhk);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }

    public void add(HHKhongDTO hhk) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "insert into airline values ("
                + "'" + hhk.getAirlineID() + "'"
                + ",'" + hhk.getAirlineName() + "')";
        mySQL.executeUpdate(qry);
    }

    public void delete(String ID) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "delete from airline where airlineID = '" + ID + "'";
        mySQL.executeUpdate(qry);
    }

    public void set(HHKhongDTO hhk) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "update airline set "
                + "airlineName = '" + hhk.getAirlineName() + "'"
                + " where airlineID = '" + hhk.getAirlineID() +"'";
        mySQL.executeUpdate(qry);
    }
    
    public ArrayList<String> getAirline(){
        ArrayList <String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from airline";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String airlineID = rs.getString("airlineID");
                String airlineName = rs.getString("airlineName");
                dsID.add(airlineID+" - "+airlineName);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }
    
//    public static void main(String[] args) {
////        ArrayList <HHKhongDTO> ds = list();
////        for (HHKhongDTO hhk : ds) {
////            System.out.println(hhk.toString());
////        }
//        String qry = "insert into airline values ("
//                + "'" + null + "'"
//                + ",'" + null + "')";
//        System.out.println(qry);
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
