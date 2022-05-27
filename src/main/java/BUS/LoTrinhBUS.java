/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoTrinhDAO;
import DTO.LoTrinhDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class LoTrinhBUS {

    private ArrayList<LoTrinhDTO> ds;

    public LoTrinhDTO get(String MaLoTrinh) {
        for (LoTrinhDTO a : ds) {
            if (a.getRouteID().equalsIgnoreCase(MaLoTrinh)) {
                return a;
            }
        }
        return null;
    }

    public void add(LoTrinhDTO a) {
        ds.add(a);
        LoTrinhDAO ltDAO = new LoTrinhDAO();
        ltDAO.add(a);
    }

    public void delete(String ID) {
        for (LoTrinhDTO n : ds) {
            if (n.getRouteID().equals(ID)) {
                ds.remove(n);
                LoTrinhDAO ltdao = new LoTrinhDAO();
                ltdao.delete(ID);
                return;
            }
        }
    }

    public void set(LoTrinhDTO s) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getRouteID().equals(s.getRouteID())) {
                ds.set(i, s);
                LoTrinhDAO ltdao = new LoTrinhDAO();
                ltdao.set(s);
                return;
            }
        }

    }

    public void list() {
        LoTrinhDAO ltDAO = new LoTrinhDAO();
        ds = new ArrayList<>();
        ds = ltDAO.list();
    }

    public ArrayList<LoTrinhDTO> getList() {
        return ds;
    }

}
