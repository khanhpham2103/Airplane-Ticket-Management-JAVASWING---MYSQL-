package DTO;

public class ThongKeDTO {

    private String ID;
    private int quy1, quy2, quy3, quy4;

    public ThongKeDTO() {
    }

    public ThongKeDTO(String ID, int quy1, int quy2, int quy3, int quy4) {
        this.ID = ID;
        this.quy1 = quy1;
        this.quy2 = quy2;
        this.quy3 = quy3;
        this.quy4 = quy4;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getQuy1() {
        return quy1;
    }

    public void setQuy1(int quy1) {
        this.quy1 = quy1;
    }

    public int getQuy2() {
        return quy2;
    }

    public void setQuy2(int quy2) {
        this.quy2 = quy2;
    }

    public int getQuy3() {
        return quy3;
    }

    public void setQuy3(int quy3) {
        this.quy3 = quy3;
    }

    public int getQuy4() {
        return quy4;
    }

    public void setQuy4(int quy4) {
        this.quy4 = quy4;
    }
    public void Output(){
        System.out.println(this.ID + " " + this.quy1 + " " +this.quy2 + " " +this.quy3 + " " + this.quy4);
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
