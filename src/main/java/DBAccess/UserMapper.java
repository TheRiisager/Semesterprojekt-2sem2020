package DBAccess;

import DBAccess.Connector;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO Users (Name, phoneNumber, email, address, password, role) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
                ps.setString( 1, user.getName() );
                ps.setString( 2, user.getPhoneNumber() );
                ps.setString( 3, user.getEmail() );
                ps.setString( 4, user.getAddress() );
                ps.setString( 5, user.getPassword() );
                ps.setString( 6, user.getRole() );
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt( 1 );
                user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID, Name, address, phoneNumber, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                int id = rs.getInt( "userID" );
                String name = rs.getString( "Name" );
                String address = rs.getString( "address");
                String role = rs.getString( "role" );
                String phoneNumber = rs.getString("phoneNumber");
                User user = new User(name, phoneNumber, email, address, password, role);
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Boolean updateUserInfo(User user){
        try{

            Connection con = Connector.connection();
            String SQL =  "UPDATE Users SET Name = ?, phoneNumber = ?, address = ? WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, user.getName() );

            String phoneNumber = user.getPhoneNumber();
            int phoneNr = Integer.parseInt(phoneNumber);

            ps.setInt( 2, phoneNr );
            ps.setString( 3, user.getAddress() );
            ps.setInt( 4, user.getId() );
            ps.executeUpdate();


            return true;
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
            return false;
        }

    }

}
