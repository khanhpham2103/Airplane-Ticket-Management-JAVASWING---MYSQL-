package BUS;

import DAO.HoaDonDAO;
import DAO.MySQLConnect;
import DAO.ThongKeDAO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.ThongKeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ThongKeBUS {

    ArrayList<HoaDonDTO> ds = new ArrayList<>();

    ;
     
     public void list() {
        HoaDonDAO hdDAO = new HoaDonDAO();
        ds = new ArrayList<>();
        ds = hdDAO.list();
    }

    public ArrayList<HoaDonDTO> getList() {
        return ds;
    }

    public ArrayList<String> getStaff() {
        HoaDonDAO hdDAO = new HoaDonDAO();
        return hdDAO.getStaffID();
    }

    public ArrayList<ThongKeDTO> invoiceByTime() {
        ThongKeDAO tkDAO = new ThongKeDAO();
        ArrayList<ThongKeDTO> dt = new ArrayList<>();
        ThongKeDTO dto = null;
        NhanVienBUS busn = new NhanVienBUS();
        busn.list();
        for (NhanVienDTO a : busn.getList()) {
            ThongKeDTO tmp = tkDAO.ProcessThongKe(a.getStaffID());
            tmp.setID(tmp.getID() + " - " + a.getStaffLast() + " "+ a.getStaffFirst());
            dt.add(tmp);
        }
        return dt;
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
