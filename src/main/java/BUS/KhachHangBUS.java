/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
//import com.sun.corba.se.impl.util.RepositoryId;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class KhachHangBUS {

    private ArrayList<KhachHangDTO> ds;

    public KhachHangDTO get(String MaKhachHang) {
        for (KhachHangDTO a : ds) {
            if (a.getMaKH().equals(MaKhachHang)) {
                return a;
            }
        }
        return null;

    }

    public void add(KhachHangDTO a) {
        ds.add(a);
        KhachHangDAO khdao = new KhachHangDAO();
        khdao.add(a);
    }

    public void delete(String MaKhachHang) {
        for (KhachHangDTO a : ds) {
            if (a.getMaKH().equals(MaKhachHang)) {
                ds.remove(a);
                KhachHangDAO khdao = new KhachHangDAO();
                khdao.delete(MaKhachHang);
                return;
            }
        }
    }

    public void set(KhachHangDTO a) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaKH().equals(a.getMaKH())) {
                ds.set(i, a);
                KhachHangDAO khdao = new KhachHangDAO();
                khdao.set(a);
                return;
            }
        }

    }

    public void list() {
        KhachHangDAO khdao = new KhachHangDAO();
        ds = new ArrayList<KhachHangDTO>();
        ds = khdao.list();
    }

    public void LastList() {
    }

    public ArrayList<KhachHangDTO> getList() {
        return ds;
    }

}
