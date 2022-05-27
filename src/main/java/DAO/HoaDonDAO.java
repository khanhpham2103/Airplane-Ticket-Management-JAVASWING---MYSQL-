package DAO;

import DTO.invoiceDetailDTO;
import DTO.HoaDonDTO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HoaDonDAO {
    
    public HoaDonDAO() {
    }

    public ArrayList<HoaDonDTO> list() {
        ArrayList<HoaDonDTO> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from invoice";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String invoiceID = rs.getString("invoiceID");
                String staffID = rs.getString("staffID");
                String customerID = rs.getString("customerID");
                long invoiceTotal = Long.parseLong(rs.getString("invoiceTotal"));
                String invoiceDateTime = rs.getString("invoiceDateTime");
                HoaDonDTO hd = new HoaDonDTO(invoiceID, staffID, customerID, invoiceTotal, invoiceDateTime);
                ds.add(hd);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }

    public void add(HoaDonDTO hd) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "insert into invoice values ("
                + "'" + hd.getInvoiceID() + "'"
                + ",'" + hd.getStaffID() + "'"
                + ",'" + hd.getCustomerID() + "'"
                + ",'" + hd.getInvoiceTotal() + "'"
                + ",'" + hd.getInvoicedDateTime() + "')";
        System.out.println(qry);
        mySQL.executeUpdate(qry);
    }

    public void delete(String ID) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "delete from invoice where invoiceID = '" + ID + "'";
        mySQL.executeUpdate(qry);
    }

    public void set(HoaDonDTO hd) {
        MySQLConnect mySQL = new MySQLConnect();
        String qry = "update invoice set "
                + "staffID = '" + hd.getStaffID() + "'"
                + ",customerID = '" + hd.getCustomerID() + "'"
                + ",invoiceDateTime = '" + hd.getInvoicedDateTime() + "'"
                + " where invoiceID = '" + hd.getInvoiceID()+"'";
        mySQL.executeUpdate(qry);
    }
    
    public ArrayList<String> getStaffID(){
        ArrayList <String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select staffID,staffLast,staffFirst from staff";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String staffID = rs.getString("staffID");
                String staffLast = rs.getString("staffLast");
                String staffFirst = rs.getString("staffFirst");
                dsID.add(staffID+" - "+staffLast+" "+staffFirst);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }
    
    public ArrayList<String> getCustomerID(){
        ArrayList <String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select customerID,customerLast,customerFirst from customer";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String customerID = rs.getString("customerID");
                String customerLast = rs.getString("customerLast");
                String customerFirst = rs.getString("customerFirst");
                dsID.add(customerID+" - "+customerLast+" "+customerFirst);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }
    
    public ArrayList<invoiceDetailDTO> getInvoiceDetail(String ID){
        ArrayList <invoiceDetailDTO> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select * from invoicedetail where invoiceID = '"+ID+"'";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String invoiceID = rs.getString("invoiceID");
                String typeID = rs.getString("typeID");
                int amount = Integer.parseInt(rs.getString("amount"));
                long total = (long)rs.getFloat("total");
                invoiceDetailDTO cthd = new invoiceDetailDTO(invoiceID, typeID, amount, total);
                ds.add(cthd);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }
    
    public ArrayList<HoaDonDTO> invoiceByTime(String startDate, String endDate){
        ArrayList<HoaDonDTO> ds = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "SELECT staffID, SUM(invoiceTotal) FROM invoice WHERE Date(invoiceDateTime) BETWEEN '"+startDate+"' AND '"+endDate+"' GROUP BY staffID";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String staffID = rs.getString("staffID");
                long invoiceTotal = Long.parseLong(rs.getString("SUM(invoiceTotal)"));
                HoaDonDTO hd = new HoaDonDTO(staffID, invoiceTotal);
                ds.add(hd);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return ds;
    }
    
//    public static void main(String[] args) {
//        ArrayList<HoaDonDTO> invoiceByQuater = invoiceByQuater("2022-04-01", "2022-04-31");
//        for(HoaDonDTO hd : invoiceByQuater){
//            System.out.println(hd.getStaffID() +"   "+ hd.getInvoiceTotal());
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
