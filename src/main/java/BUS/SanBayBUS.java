/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoTrinhDAO;
import DAO.SanBayDAO;
import DTO.SanBayDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SanBayBUS {

    private ArrayList<SanBayDTO> ds;

    public SanBayDTO get(String MaSanBay) {
        for (SanBayDTO a : ds) {
            if (a.getAirportID().equalsIgnoreCase(MaSanBay)) {
                return a;
            }
        }
        return null;
    }

    public void add(SanBayDTO a) {
        ds.add(a);
        SanBayDAO dao = new SanBayDAO();
        dao.add(a);
    }

    public void delete(String id) {
        for (SanBayDTO n : ds) {
            if (n.getAirportID().equals(id)) {
                ds.remove(n);
                SanBayDAO dao = new SanBayDAO();
                dao.delete(id);
                return;
            }
        }
    }

    public void set(SanBayDTO a) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getAirportID().equals(a.getAirportID())) {
                ds.set(i, a);
                SanBayDAO dao = new SanBayDAO();
                dao.set(a);
                return;
            }

        }
    }

    public void list() {
        SanBayDAO dao = new SanBayDAO();
        ds = new ArrayList<>();
        ds = dao.list();
    }

    public ArrayList<SanBayDTO> getList() {
        return ds;
    }
}
