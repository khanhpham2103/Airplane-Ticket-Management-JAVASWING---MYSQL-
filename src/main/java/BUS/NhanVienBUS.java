package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {

    ArrayList<NhanVienDTO> ds;

    public NhanVienDTO get(String ID) {
        for (NhanVienDTO nv : ds) {
            if (ID.equals(nv.getStaffID())) {
                return nv;
            }
        }
        return null;
    }
    
    public void add(NhanVienDTO nv){
        ds.add(nv);
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.add(nv);
    }
    
        public String getNextID() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        String nextID = "";
        int increaser = Integer.parseInt(nvDAO.getLastID().substring(2))+1;
        String numberID = String.valueOf(increaser);
        while (numberID.length() != 2){
            numberID = "0"+numberID;
        }
        nextID = "NV"+numberID;
        return nextID;
    }
    
    public void delete(String ID){
        for(NhanVienDTO n : ds){
           if(n.getStaffID().equals(ID)){
                ds.remove(n);
                NhanVienDAO nvDAO = new NhanVienDAO();
                nvDAO.delete(ID);
                return;
            }
        }
    }
    
    public void set(NhanVienDTO nv) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getStaffID().equals(nv.getStaffID())) {
                ds.set(i, nv);
                NhanVienDAO nvDAO = new NhanVienDAO();
                nvDAO.set(nv);
                return;
            }
        }
    }

    public void list() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        ds = new ArrayList<>();
        ds = nvDAO.list();
    }

    public ArrayList<NhanVienDTO> getList() {
        return ds;
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
