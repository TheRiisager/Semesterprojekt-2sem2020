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
                int orderID = rs.getInt("orderID");
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                int status = rs.getInt("status");
                String componetString = rs.getString("componentList");

                orders.add( new Order( orderID, width, length, componetString, status ) );

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

    public static Order getOrder ( int orderID ) {
        Order order = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE orderID = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, orderID );
            ResultSet rs = ps.executeQuery();

            if(rs.next() ) {
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                int status = rs.getInt("status");
                String componetString = rs.getString("componentList");

                order = new Order(orderID, width, length, componetString, status);
            }

        }catch ( SQLException e ){
            System.out.println( e );
            System.out.println( "SQL exception in OrderMapper.getOrder()" );

        }catch (ClassNotFoundException a){
            System.out.println( a );
            System.out.println( "ClassNotFound Exception in OrderMapper.getOrder()" );
        }


        return order;
    }

    //TODO: Implement status and componentList
    public static void updateOrder ( int orderID, int length, int width, int status ) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE Orders SET Length=?, Width=?, Status=? WHERE orderID = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, length );
            ps.setInt( 2, width );
            ps.setInt( 3, orderID );
            ps.setInt( 4, status );

            ps.executeUpdate();
        }catch ( SQLException e ){
            System.out.println( e );
            System.out.println( "SQL exception in OrderMapper.getOrder()" );

        }catch (ClassNotFoundException a){
            System.out.println( a );
            System.out.println( "ClassNotFound Exception in OrderMapper.getOrder()" );
        }
    }



    public static Order createOrderToDB(Order order){

        try{
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders (Length, Width, userID, componentList, status)"
                    + "VALUES    (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getCarportLength());
            ps.setInt(2, order.getCarportWidth());
            ps.setInt( 3, order.getUserID() );
            ps.setString(4, order.getComponentString());
            ps.setInt(5, order.getStatus());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setOrderID(id);

            return order;
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("SQL exception in OrderMapper.createOrderToDB()");
            return null;
        }catch(ClassNotFoundException a) {
            System.out.println(a);
            System.out.println("ClassNotFound Exception in OrderMapper.createOrderToDB()");
            return null;
        }
    }



}
