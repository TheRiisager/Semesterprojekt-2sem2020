package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
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

}
