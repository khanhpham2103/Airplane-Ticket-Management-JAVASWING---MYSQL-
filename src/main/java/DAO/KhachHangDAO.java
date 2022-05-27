/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class KhachHangDAO {

    public KhachHangDAO() {
    }

    public ArrayList<KhachHangDTO> list() {
        MySQLConnect ms = new MySQLConnect();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {

                String maNV = rs.getString("customerID");
                String hoNV = rs.getString("customerLast");
                String tenNV = rs.getString("customerFirst");
                String GioiTinh = rs.getString("customerGender");
                String sdt = rs.getString("customerTelephone");
                String addresss = rs.getString("customerAddress");
                String birth = rs.getString("customerBirth");

                KhachHangDTO kh = new KhachHangDTO(maNV, hoNV, tenNV, GioiTinh, birth, addresss, sdt);
                dskh.add(kh);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            System.out.println("Loi ket noi db");
        }
        return dskh;
    }
    
    public ArrayList<KhachHangDTO> getlast() {
        MySQLConnect ms = new MySQLConnect();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("customerID");
                String hoNV = rs.getString("customerLast");
                String tenNV = rs.getString("customerFirst");
                String GioiTinh = rs.getString("customerGender");
                String sdt = rs.getString("customerTelephone");
                String addresss = rs.getString("customerAddress");
                String birth = rs.getString("customerBirth");
                KhachHangDTO kh = new KhachHangDTO(maNV, hoNV, tenNV, GioiTinh, birth, addresss, sdt);
                dskh.add(kh);
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {

        }
        return dskh;

    }

    public void add(KhachHangDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "INSERT INTO customer VALUES (";
        sql += "'" + a.getMaKH() + "','" + a.getHoKH() + "'";
        sql += ",'" + a.getTenKH() + "','" + a.getGioiTinh() + "'";
        sql += ",'" + a.getBirth() + "','" + a.getAddress() + "'";
        sql += ",'" + a.getSDT() + "' )";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void set(KhachHangDTO a) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "UPDATE customer SET ";
        sql += "customerID ='" + a.getMaKH() + "', ";
        sql += "customerLast = '" + a.getHoKH() + "',";
        sql += "customerFirst ='" + a.getTenKH() + "',";
        sql += "customerGender ='" + a.getGioiTinh() + "',";
        sql += "customerBirth='" + a.getBirth() + "',customerAddress='" + a.getAddress() + "',";
        sql += "customerTelephone='" + a.getSDT() + "'";
        sql += "WHERE customerID = '" + a.getMaKH() + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void delete(String id) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " DELETE FROM customer WHERE customerID = '" + id + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

}
