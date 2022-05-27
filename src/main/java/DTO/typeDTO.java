
package DTO;


public class typeDTO {
    private String typeID;
    private String typeName;
    private int waittingRoom;
    private float typePrice;

    public typeDTO(String typeID, String typeName, int waittingRoom, float typePrice) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.waittingRoom = waittingRoom;
        this.typePrice = typePrice;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getWaittingRoom() {
        return waittingRoom;
    }

    public void setWaittingRoom(int waittingRoom) {
        this.waittingRoom = waittingRoom;
    }

    public float getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(float typePrice) {
        this.typePrice = typePrice;
    }
}
