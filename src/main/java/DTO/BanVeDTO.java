/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class BanVeDTO {

    private String Ma, Ho, Ten, GioiTinh, Birth, DiaChi, SDt;
    private String BusNum, EcoNum;

    public BanVeDTO() {
    }

    public BanVeDTO(String Ma, String Ho, String Ten, String GioiTinh, String Birth, String DiaChi, String SDt, String BusNum, String EcoNum) {
        this.Ma = Ma;
        this.Ho = Ho;
        this.Ten = Ten;
        this.GioiTinh = GioiTinh;
        this.Birth = Birth;
        this.DiaChi = DiaChi;
        this.SDt = SDt;
        this.BusNum = BusNum;
        this.EcoNum = EcoNum;
    }



    public String getBusNum() {
        return BusNum;
    }

    public void setBusNum(String BusNum) {
        this.BusNum = BusNum;
    }

    public String getEcoNum() {
        return EcoNum;
    }

    public void setEcoNum(String EcoNum) {
        this.EcoNum = EcoNum;
    }

 
    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getSDt() {
        return SDt;
    }

    public void setSDt(String SDt) {
        this.SDt = SDt;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String Birth) {
        this.Birth = Birth;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

}
