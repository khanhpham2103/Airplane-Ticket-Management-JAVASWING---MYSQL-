package GUI;

public class common {

    public common() {
    }
    
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static String currentFrame;
    public static String typeId;
    public static String customerId;
    public static String flightId;
    public static String invoiceId;
    
    public void resetCommonVariables() {
        currentFrame = "";
        typeId = "";
        customerId = "";
        flightId = "";
        invoiceId = "";
    }
}
