/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AirplaneDAO;
import DTO.AirplaneDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class AirplaneBUS {

    private ArrayList<AirplaneDTO> ds;

    public AirplaneDTO get(String Ma) {
        for (AirplaneDTO a : ds) {
            if (a.getAirplaneID().toLowerCase().equals(Ma.toLowerCase())) {
                return a;
            }
        }
        return null;
    }

    public void add(AirplaneDTO a) {
        ds.add(a);
        AirplaneDAO dao = new AirplaneDAO();
        dao.add(a);
    }

    public void set(AirplaneDTO a) {
        System.out.println("Update func");
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getAirplaneID().equals(a.getAirplaneID())) {
                System.out.println("Tim thay update");
                ds.set(i, a);
                AirplaneDAO dao = new AirplaneDAO();
                dao.set(a);
                return;
            }
        }
    }

    public void delete(String id) {
        for (AirplaneDTO a : ds) {
            if (a.getAirplaneID().toLowerCase().equals(id.toLowerCase())) {
                System.out.println("Found Del ");
                ds.remove(a);
                AirplaneDAO dao = new AirplaneDAO();
                dao.delete(id);
                return;
            }
        }
    }

    public ArrayList<AirplaneDTO> Search(String text, int bus, int eco) {
        ArrayList<AirplaneDTO> res = new ArrayList<>();
        ArrayList<AirplaneDTO> res1 = new ArrayList<>();
        ArrayList<AirplaneDTO> res2 = new ArrayList<>();
        ArrayList<AirplaneDTO> tmp = new ArrayList<>();
        if (!text.equals("")) {
            for (AirplaneDTO a : ds) {
                if (a.getAirplaneBrand().toLowerCase().indexOf(text.toLowerCase()) != -1) {
                    System.out.println("Founded string");
                    res.add(a);
                }
            }
        } else {
            return ds;
        }
        if (bus > 0) {
            if (res.size() > 0) {
                tmp = res;
                System.out.println(res.size() + "--------- sixe ------- " + tmp.size());
            } else {
                tmp = ds;
            }
            for (AirplaneDTO a : tmp) {
                System.out.println("Searching");

                int num = a.getBusSeats();
                if (bus <= num) {
                    System.out.println("Found BUS");
                    res1.add(a);
                }
            }
            res = res1;
        }
        if (eco > 0) {
            if (res.size() > 0) {
                tmp = res;
                System.out.println(res.size() + "--------- sixe ------- " + tmp.size());
            } else {
                tmp = ds;
            }
            for (AirplaneDTO a : tmp) {
                System.out.println("Searching");
                int num = a.getEcoSeats();
                if (eco <= num) {
                    System.out.println("Found Eco");
                    res2.add(a);
                }
            }
            res = res2;
        }
        return res;

//        return res.size() > 0 ? res : ds;
    }

    public void list() {
        AirplaneDAO dao = new AirplaneDAO();
        ds = dao.list();
    }

    public ArrayList<AirplaneDTO> getList() {
        return ds;
    }
}
