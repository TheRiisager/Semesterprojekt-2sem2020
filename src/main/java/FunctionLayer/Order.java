package FunctionLayer;

import java.util.ArrayList;


public class Order {

    final static int MODULESIZE = 30;

    private ArrayList<Pair> componentList;


    private int carportWidth, carportLength;
    private int orderID;
    private int userID;
    private String componentString;
    private int status;

    public Order (int orderID, int cWidth, int cLength) {
        checkData(cWidth);
        checkData(cLength);

        this.orderID = orderID;
        this.carportWidth = cWidth;
        this.carportLength = cLength;
    }



    public Order (int cWidth, int cLength){
        checkData(cWidth);
        checkData(cLength);

        this.carportWidth = cWidth;
        this.carportLength = cLength;
    }

    public Order (int orderID, int cWidth, int cLength, String componentString, int status){
        checkData(cWidth);
        checkData(cLength);

        this.orderID = orderID;
        this.carportWidth = cWidth;
        this.carportLength = cLength;
        this.componentString = componentString;
        this.status = status;
    }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public String getComponentString() { return componentString; }

    public void setComponentString(String componentString) { this.componentString = componentString; }

    public int getCarportWidth() {
        return carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
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

    public void setComponentList(){
        this.componentList = ListCreator.createList(this);
    }

    public ArrayList<Pair> getComponentList() {
        return componentList;
    }

    private void checkData(int value){
        if(value % MODULESIZE != 0){
            System.out.println("input not divisible by module size!");
            throw new IllegalArgumentException();
        }
    }



}
