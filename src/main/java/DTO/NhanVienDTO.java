package DTO;

public class NhanVienDTO {
    private String staffID;
    private String staffLast;
    private String staffFirst;
    private String staffGender;
    private String staffBirth;
    private String staffAddress;
    private String staffTelephone;

    public NhanVienDTO() {
        staffID = "";
        staffLast = "";
        staffFirst = "";
        staffGender = "";
        staffTelephone = "";
    }

    public NhanVienDTO(String staffID) {
        this.staffID = staffID;
    }

    public NhanVienDTO(String staffID, String staffLast) {
        this.staffID = staffID;
        this.staffLast = staffLast;
    }

    public NhanVienDTO(String staffID, String staffLast, String staffFirst) {
        this.staffID = staffID;
        this.staffLast = staffLast;
        this.staffFirst = staffFirst;
    }
    
    public NhanVienDTO(String staffID, String staffLast, String staffFirst, String staffGender) {
        this(staffID, staffLast, staffFirst);
        this.staffGender = staffGender;
    }

    public NhanVienDTO(String staffID, String staffLast, String staffFirst, String staffGender, String staffBirth, String staffAddress, String staffTelephone) {
        this.staffID = staffID;
        this.staffLast = staffLast;
        this.staffFirst = staffFirst;
        this.staffGender = staffGender;
        this.staffBirth = staffBirth;
        this.staffAddress = staffAddress;
        this.staffTelephone = staffTelephone;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffLast() {
        return staffLast;
    }

    public void setStaffLast(String staffLast) {
        this.staffLast = staffLast;
    }

    public String getStaffFirst() {
        return staffFirst;
    }

    public void setStaffFirst(String staffFirst) {
        this.staffFirst = staffFirst;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public String getStaffBirth() {
        return staffBirth;
    }

    public void setStaffBirth(String staffBirth) {
        this.staffBirth = staffBirth;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }
    
    public String getStaffTelephone() {
        return staffTelephone;
    }

    public void setStaffTelephone(String staffTelephone) {
        this.staffTelephone = staffTelephone;
    }
}
