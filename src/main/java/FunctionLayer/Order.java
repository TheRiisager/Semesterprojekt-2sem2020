package FunctionLayer;

public class Order {

    private int carportWidth, carportLength, carportHeight;
    private int orderID;
    private int userID;

    public Order (int orderID, int cWidth, int cLength, int cHeight) {
        this.orderID = orderID;
        this.carportWidth = cWidth;
        this.carportLength = cLength;
        this.carportHeight = cHeight;
    }
    public Order (int cWidth, int cLength, int cHeight){
        this.carportWidth = cWidth;
        this.carportLength = cLength;
        this.carportHeight = cHeight;
    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setOrderID(int orderID) { this.orderID = orderID; }


}
