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


    public static Order createOrder(Order order){
        order = OrderMapper.createOrderToDB(order);
        return order;
    }

    public static Order getOrder( int orderID ) {
        return OrderMapper.getOrder( orderID );
    }

    public static void updateOrder( int orderID, int length, int width, int status ){
        OrderMapper.updateOrder( orderID, length, width, status );
    }

    public static ArrayList<Material> loadMaterials(){
        return MaterialMapper.loadMaterials();
    }

}
