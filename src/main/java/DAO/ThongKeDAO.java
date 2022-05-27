package DAO;

import DTO.HoaDonDTO;
import DTO.ThongKeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThongKeDAO {

    private static ArrayList<HoaDonDTO> ds = new ArrayList<>();
    private String[][] quaters = {{"2022-01-01", "2022-03-31"},
    {"2022-04-01", "2022-06-30"},
    {"2022-07-01", "2022-09-30"},
    {"2022-10-01", "2022-12-31"}};

    public ThongKeDAO() {
    }

    public ArrayList<String> getStaffID() {
        ArrayList<String> dsID = new ArrayList<>();
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "select staffID, staffLast, staffFirst from staff";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                String staffID = rs.getString("staffID");
                String staffLast = rs.getString("staffLast");
                String staffFirst = rs.getString("staffFirst");
                dsID.add(staffID + " - " + staffLast + " " + staffFirst);
            }
            rs.close();
            mySQL.disConnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return dsID;
    }

//    public static ArrayList<HoaDonDTO> invoiceByTime(String date[]) {
//        MySQLConnect mySQL = new MySQLConnect();
//        try {
//            String qry = "SELECT staffID, SUM(invoiceTotal)"
//                    + " FROM invoice"
//                    + " WHERE Date(invoiceDateTime) BETWEEN '" + date[0] + "' AND '" + date[1] + "'"
//                    + " GROUP BY staffID";
//            System.out.println(qry);
//            ResultSet rs = mySQL.executeQuery(qry);
//            if (!rs.next()) {
//                qry = "SELECT staffID, staffFirst, staffLast from staff";
//                rs = mySQL.executeQuery(qry);
//                while (rs.next()) {
//                    String staffID = rs.getString("staffID");
//                    HoaDonDTO hd = new HoaDonDTO(staffID, 0);
//                    ds.add(hd);
//                }
//            } else {
//                rs = mySQL.executeQuery(qry);
//                while (rs.next()) {
//                    String staffID = rs.getString("staffID");
//                    long invoiceTotal = Long.parseLong(rs.getString("SUM(invoiceTotal)"));
//                    HoaDonDTO hd = new HoaDonDTO(staffID, invoiceTotal);
//                    ds.add(hd);
//                }
//            }
//            rs.close();
//            mySQL.disConnect();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
//        }
//        return ds;
//    }
    public static int invoiceByQuater(String id, ArrayList<String> date) {
        MySQLConnect mySQL = new MySQLConnect();
        try {
            String qry = "SELECT SUM(invoiceTotal) AS total"
                    + " FROM invoice"
                    + " WHERE staffID ='" + id + "' AND Date(invoiceDateTime) BETWEEN '" + date.get(0) + "' AND '" + date.get(1) + "'";
            ResultSet rs = mySQL.executeQuery(qry);
            while (rs.next()) {
                int total = rs.getInt("total");
                return total;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
        }
        return -1;
    }

    public ThongKeDTO ProcessThongKe(String idNv) {
        String[][] quaters = {{"2022-01-01", "2022-03-31"},
        {"2022-04-01", "2022-06-30"},
        {"2022-07-01", "2022-09-30"},
        {"2022-10-01", "2022-12-31"}};
        ThongKeDTO tmp = new ThongKeDTO();
        tmp.setID(idNv);
        for (int i = 0; i < 4; i++) {
            ArrayList<String> sum = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                sum.add(quaters[i][j]);
            }
            switch (i) {
                case 0:
                    tmp.setQuy1(invoiceByQuater(idNv, sum));
                    break;
                case 1:
                    tmp.setQuy2(invoiceByQuater(idNv, sum));
                    break;
                case 2:
                    tmp.setQuy3(invoiceByQuater(idNv, sum));
                    break;
                case 3:
                    tmp.setQuy4(invoiceByQuater(idNv, sum));
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return tmp;
    }

//    public static void main(String[] args) {
//        String[][] quaters = {{"2022-01-01", "2022-03-31"},
//        {"2022-04-01", "2022-06-30"},
//        {"2022-07-01", "2022-09-30"},
//        {"2022-10-01", "2022-12-31"}};
//
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
