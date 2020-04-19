package FunctionLayer;

public class Order {

    private int carportWidth, carportLength, carportHeight;
    private int orderID;

    public Order (int orderID, int cWidth, int cLength, int cHeight) {
        this.orderID = orderID;
        this.carportWidth = cWidth;
        this.carportLength = cLength;
        this.carportHeight = cHeight;
    }

}
