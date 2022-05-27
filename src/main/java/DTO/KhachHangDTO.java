/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class KhachHangDTO {

    private String MaKH, hoKH, tenKH, GioiTinh, SDT,birth,address;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String MaKH, String hoKH, String tenKH, String GioiTinh, String birth, String address, String SDT) {
        this.MaKH = MaKH;
        this.hoKH = hoKH;
        this.tenKH = tenKH;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.birth = birth;
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void Output() {
        System.out.println(this.MaKH + " " + this.hoKH + " " + this.tenKH + " " + this.GioiTinh + " " + this.GioiTinh + " " + "\n");
    }

}
