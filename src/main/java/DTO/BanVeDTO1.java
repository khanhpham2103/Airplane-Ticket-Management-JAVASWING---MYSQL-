/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class BanVeDTO1 {

    private String MaChuyenBay, LoTrinh, ThoiGianDi, ThoiGianDen, SanBayCatCanh, SanBayHaCanh,SoECO,SoBUS;

    public BanVeDTO1(String MaChuyenBay, String LoTrinh, String ThoiGianDi, String ThoiGianDen, String SanBayCatCanh, String SanBayHaCanh, String SoECO, String SoBUS) {
        this.MaChuyenBay = MaChuyenBay;
        this.LoTrinh = LoTrinh;
        this.ThoiGianDi = ThoiGianDi;
        this.ThoiGianDen = ThoiGianDen;
        this.SanBayCatCanh = SanBayCatCanh;
        this.SanBayHaCanh = SanBayHaCanh;
        this.SoECO = SoECO;
        this.SoBUS = SoBUS;
    }

    public BanVeDTO1(String MaChuyenBay, String LoTrinh, String ThoiGianDi, String ThoiGianDen, String SanBayCatCanh, String SanBayHaCanh) {
        this.MaChuyenBay = MaChuyenBay;
        this.LoTrinh = LoTrinh;
        this.ThoiGianDi = ThoiGianDi;
        this.ThoiGianDen = ThoiGianDen;
        this.SanBayCatCanh = SanBayCatCanh;
        this.SanBayHaCanh = SanBayHaCanh;
    }

    public BanVeDTO1() {
    }

    public String getSoECO() {
        return SoECO;
    }

    public void setSoECO(String SoECO) {
        this.SoECO = SoECO;
    }

    public String getSoBUS() {
        return SoBUS;
    }

    public void setSoBUS(String SoBUS) {
        this.SoBUS = SoBUS;
    }

    public String getMaChuyenBay() {
        return MaChuyenBay;
    }

    public void setMaChuyenBay(String MaChuyenBay) {
        this.MaChuyenBay = MaChuyenBay;
    }

    public String getLoTrinh() {
        return LoTrinh;
    }

    public void setLoTrinh(String LoTrinh) {
        this.LoTrinh = LoTrinh;
    }

    public String getThoiGianDi() {
        return ThoiGianDi;
    }

    public void setThoiGianDi(String ThoiGianDi) {
        this.ThoiGianDi = ThoiGianDi;
    }

    public String getThoiGianDen() {
        return ThoiGianDen;
    }

    public void setThoiGianDen(String ThoiGianDen) {
        this.ThoiGianDen = ThoiGianDen;
    }

    public String getSanBayCatCanh() {
        return SanBayCatCanh;
    }

    public void setSanBayCatCanh(String SanBayCatCanh) {
        this.SanBayCatCanh = SanBayCatCanh;
    }

    public String getSanBayHaCanh() {
        return SanBayHaCanh;
    }

    public void setSanBayHaCanh(String SanBayHaCanh) {
        this.SanBayHaCanh = SanBayHaCanh;
    }

    public void Output() {
        System.out.println(this.MaChuyenBay + "  " + this.getLoTrinh() + "\n");
    }
}
