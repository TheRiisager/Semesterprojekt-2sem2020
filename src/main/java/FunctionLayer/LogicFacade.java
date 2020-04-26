package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name, String phoneNumber,String email, String address, String password ) throws LoginSampleException {
        User user = new User(name, phoneNumber, email, address, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<Order> getAllOrders(){
       return OrderMapper.getAllOrders();
    }

    //TODO clean up method, so that it only takes a userID and an Order, and returns an Order.
    public static Order createOrder(User user, int width, int length){
        Order order = new Order(width, length, length);
        int userID = user.getId();
        int id = OrderMapper.createOrderToDB(order, userID); // set the orderID in the OrderMapper method instead, and return the complete order object.
        order.setUserID(userID); //set this when first instantiating the object (before calling this method)
        order.setOrderID(id);
        return order;
    }

    public static Order getOrder( int orderID ) {
        return OrderMapper.getOrder( orderID );
    }

    public static void updateOrder( int orderID, int length, int width, int height ){
        OrderMapper.updateOrder( orderID, length, width );
    }

    public static ArrayList<Material> loadMaterials(){
        return MaterialMapper.loadMaterials();
    }

}
