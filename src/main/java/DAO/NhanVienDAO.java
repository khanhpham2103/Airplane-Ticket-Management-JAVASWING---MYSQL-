package DAO;

import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanVienDAO {

    public NhanVienDAO() {
    }
    
    public ArrayList<NhanVienDTO> list() {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from staff";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String staffID = rs.getString("staffID");
                String staffLast = rs.getString("staffLast");
                String staffFirst = rs.getString("staffFirst");
                String staffGender = rs.getString("staffGender");
                String staffBirth = rs.getString("staffBirth");
                String staffAddress = rs.getString("staffAddress");
                String staffTelephone = rs.getString("staffTelephone");
                NhanVienDTO nv = new NhanVienDTO(staffID, staffLast, staffFirst, staffGender, staffBirth, staffAddress, staffTelephone);
                ds.add(nv);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }

    public void add(NhanVienDTO nv) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "insert into staff values ("
                + "'" + nv.getStaffID() + "'"
                + ",'" + nv.getStaffLast() + "'"
                + ",'" + nv.getStaffFirst() + "'"
                + ",'" + nv.getStaffGender() + "'"
                + ",'" + nv.getStaffBirth()+ "'"
                + ",'" + nv.getStaffAddress()+ "'"
                + ",'" + nv.getStaffTelephone() + "'"
                + ",'" + nv.getStaffTelephone() + "')";
        System.out.println(qry);
        mySQL.executeUpdate(qry);
    }

    public void delete(String ID) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "delete from staff where staffID = '" + ID + "'";
        mySQL.executeUpdate(qry);
    }

    public void set(NhanVienDTO nv) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "update staff set "
                + "staffLast = '" + nv.getStaffLast() + "'"
                + ",staffFirst = '" + nv.getStaffFirst() + "'"
                + ",staffGender = '" + nv.getStaffGender() + "'"
                + ",staffBirth = '" + nv.getStaffBirth() + "'"
                + ",staffAddress = '" + nv.getStaffAddress() + "'"
                + ",staffTelephone = '" + nv.getStaffTelephone() + "'"
                + " where staffID = '" + nv.getStaffID() +"'";
        mySQL.executeUpdate(qry);
    }

    public String getLastID() {
        MySQLConnect mySQL = new MySQLConnect();
        String lastID = "";
        try {
            String qry = "SELECT staffID FROM staff ORDER by staffID DESC LIMIT 1";
            ResultSet rs = mySQL.executeQuery(qry);
            while(rs.next()){
                lastID = rs.getString("staffID");
            }
            rs.close();
            mySQL.disConnect();
        } catch (Exception e) {
        }
        return lastID;
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
