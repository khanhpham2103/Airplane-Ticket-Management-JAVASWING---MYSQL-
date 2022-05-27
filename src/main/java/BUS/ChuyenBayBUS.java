package BUS;

import DAO.ChuyenBayDAO;
import DTO.ChuyenBayDTO;
import java.util.ArrayList;

public class ChuyenBayBUS {
    
    ArrayList<ChuyenBayDTO> ds;

    public ChuyenBayDTO get(String ID) {
        for (ChuyenBayDTO cb : ds) {
            if (ID.equals(cb.getFlightID())) {
                return cb;
            }
        }
        return null;
    }
    
    public void add(ChuyenBayDTO cb){
        ds.add(cb);
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        cbDAO.add(cb);
    }
    
    public void delete(String ID){
        for(ChuyenBayDTO n : ds){
           if(n.getFlightID().equals(ID)){
                ds.remove(n);
                ChuyenBayDAO cbDAO = new ChuyenBayDAO();
                cbDAO.delete(ID);
                return;
            }
        }
    }
    
    public void set(ChuyenBayDTO hd) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getFlightID().equals(hd.getFlightID()) ) {
                ds.set(i, hd);
                ChuyenBayDAO cbDAO = new ChuyenBayDAO();
                cbDAO.set(hd);
                return;
            }
        }
    }

    public void list() {
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        ds = new ArrayList<>();
        ds = cbDAO.list();
    }

    public ArrayList<ChuyenBayDTO> getList() {
        return ds;
    }
    
    public ArrayList<String> getRouteID(){
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        return cbDAO.getRouteID();
    }
    
    public ArrayList<String> getAirplaneID(){
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        return cbDAO.getAirplaneID();
    }
    
    public ArrayList<String> getFlightScheduleID(){
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        return cbDAO.getFlightScheduleID();
    }
    
    public ArrayList<String> getAirportID() {
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        return cbDAO.getAirportID();
    }
    
    public ArrayList<String> getSeats(String ID) {
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        return cbDAO.getSeats(ID);
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
