package BUS;

import DAO.HoaDonDAO;
import DTO.invoiceDetailDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

public class HoaDonBUS {
    
    ArrayList<HoaDonDTO> ds;

    public HoaDonDTO get(String ID) {
        for (HoaDonDTO hd : ds) {
            if (ID.equals(hd.getInvoiceID())) {
                return hd;
            }
        }
        return null;
    }
    
    public void add(HoaDonDTO hd){
        ds.add(hd);
        HoaDonDAO hdDAODAO = new HoaDonDAO();
        hdDAODAO.add(hd);
    }
    
    public void delete(String ID){
        for(HoaDonDTO n : ds){
           if(n.getInvoiceID().equals(ID)){
                ds.remove(n);
                HoaDonDAO hdDAO = new HoaDonDAO();
                hdDAO.delete(ID);
                return;
            }
        }
    }
    
    public void set(HoaDonDTO hd) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getInvoiceID().equals(hd.getInvoiceID())) {
                ds.set(i, hd);
                HoaDonDAO hdDAO = new HoaDonDAO();
                hdDAO.set(hd);
                return;
            }
        }
    }

    public void list() {
        HoaDonDAO hdDAO = new HoaDonDAO();
        ds = new ArrayList<>();
        ds = hdDAO.list();
    }

    public ArrayList<HoaDonDTO> getList() {
        return ds;
    }
    
    public ArrayList<String> getStaffID(){
        HoaDonDAO hdDAO = new HoaDonDAO();
        return hdDAO.getStaffID();
    }
    
    public ArrayList<String> getCustomerID(){
        HoaDonDAO hdDAO = new HoaDonDAO();
        return hdDAO.getCustomerID();
    }
    
    public ArrayList<invoiceDetailDTO> getInvoiceDetail(String ID){
        HoaDonDAO hdDAO = new HoaDonDAO();
        return hdDAO.getInvoiceDetail(ID);
    }
    
    public ArrayList<HoaDonDTO> invoiceByTime(String startDate, String endDate){
        HoaDonDAO hdDAO = new HoaDonDAO();
        return hdDAO.invoiceByTime(startDate, endDate);
    }
    
    public ArrayList<HoaDonDTO> searchByMonthAndYear(String month, String year) {
        
        ArrayList<HoaDonDTO> hdSearchList = new ArrayList<>();
        
        for (HoaDonDTO hd : ds) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
               hdSearchList.add(hd);
            }
        }
        return hdSearchList;
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
