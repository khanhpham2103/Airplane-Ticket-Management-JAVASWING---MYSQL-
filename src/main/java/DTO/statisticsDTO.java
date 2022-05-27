
package DTO;

public class statisticsDTO {
    private String month;
    private int SLHD;
    private int SLVe;
    private int SLVeECO;
    private int SLVeBUS;
    private long tongTien;

    public statisticsDTO() {
    }
    
    
    public statisticsDTO(String month, int SLHD, int SLVe, int SLVeECO, int SLVeBUS, long tongTien) {
        this.month = month;
        this.SLHD = SLHD;
        this.SLVe = SLVe;
        this.SLVeECO = SLVeECO;
        this.SLVeBUS = SLVeBUS;
        this.tongTien = tongTien;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSLHD() {
        return SLHD;
    }

    public void setSLHD(int SLHD) {
        this.SLHD = SLHD;
    }

    public int getSLVe() {
        return SLVe;
    }

    public void setSLVe(int SLVe) {
        this.SLVe = SLVe;
    }

    public int getSLVeECO() {
        return SLVeECO;
    }

    public void setSLVeECO(int SLVeECO) {
        this.SLVeECO = SLVeECO;
    }

    public int getSLVeBUS() {
        return SLVeBUS;
    }

    public void setSLVeBUS(int SLVeBUS) {
        this.SLVeBUS = SLVeBUS;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
