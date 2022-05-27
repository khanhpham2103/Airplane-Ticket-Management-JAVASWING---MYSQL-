package BUS;

import DAO.HHKhongDAO;
import DTO.HHKhongDTO;
import java.util.ArrayList;

public class HHKhongBUS {
    
    ArrayList<HHKhongDTO> ds;

    public HHKhongDTO get(String ID) {
        for (HHKhongDTO hhk : ds) {
            if (ID.equals(hhk.getAirlineID())) {
                return hhk;
            }
        }
        return null;
    }
    
    public void add(HHKhongDTO hhk){
        ds.add(hhk);
        HHKhongDAO hhkDAO = new HHKhongDAO();
        hhkDAO.add(hhk);
    }
    
    public void delete(String ID){
        for(HHKhongDTO n : ds){
           if(n.getAirlineID().equals(ID)){
                ds.remove(n);
                HHKhongDAO hhkDAO = new HHKhongDAO();
                hhkDAO.delete(ID);
                return;
            }
        }
    }
    
    public void set(HHKhongDTO hhk) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getAirlineID().equals(hhk.getAirlineID())) {
                ds.set(i, hhk);
                HHKhongDAO hhkDAO = new HHKhongDAO();
                hhkDAO.set(hhk);
                return;
            }
        }
    }

    public void list() {
        HHKhongDAO hhkDAO = new HHKhongDAO();
        ds = new ArrayList<>();
        ds = hhkDAO.list();
    }

    public ArrayList<HHKhongDTO> getList() {
        return ds;
    }
    
    public ArrayList<String> getAirline(){
        HHKhongDAO hhkDAO = new HHKhongDAO();
        return hhkDAO.getAirline();
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
