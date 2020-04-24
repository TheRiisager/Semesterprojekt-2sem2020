package DBAccess;

import FunctionLayer.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderMapper {

    public static ArrayList<Order> getAllOrders(){
        ArrayList<Order> orders = new ArrayList<Order>();

        try{
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int orderID = rs.getInt("orderID"); ;
                int height = rs.getInt("Height");
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");

                orders.add(new Order(orderID, width, length, height));

            }

        }catch(SQLException e){
            System.out.println(e);
            System.out.println("SQL exception in OrderMapper.getAllOrders()");

        }catch(ClassNotFoundException a){
            System.out.println(a);
            System.out.println("ClassNotFound Exception in OrderMapper.getAllOrders()");
        }

        return orders;
    }


    public static int createOrderToDB(Order order, int userID){

        try{
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders (Height, Length, Width, userID)"
                    + "VALUES    (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getCarportHeight());
            ps.setInt(2, order.getCarportLength());
            ps.setInt(3, order.getCarportWidth());
            ps.setInt( 4, userID );
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setOrderID(id);

            return id;
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("SQL exception in OrderMapper.createOrderToDB()");
            return -1;
        }catch(ClassNotFoundException a) {
            System.out.println(a);
            System.out.println("ClassNotFound Exception in OrderMapper.createOrderToDB()");
            return -1;
        }
    }

}
