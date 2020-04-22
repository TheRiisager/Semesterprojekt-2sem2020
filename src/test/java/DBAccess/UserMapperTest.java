package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class  UserMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES 
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
    private static String USER = "cupcake";
    private static String USERPW = "cupcake";
    private static String DBNAME = "FogProjektEksamenS2Test";
    private static String HOST = "64.225.69.246";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                Connector.setConnection( testConnection );
            }
            /* reset test database
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists Users" );
                stmt.execute( "create table Users like UsersTest" );
                stmt.execute( "insert into Users select * from UsersTest" );
            }
            */
        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertTrue( user != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login( "jens@somewhere.com", "larsen" );
        assertTrue( user == null );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "kingkong", "88888888", "king@kong.com", "Verd", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "kingkonge", retrieved.getName() );
        assertEquals( "88888888", retrieved.getPhoneNumber() );
        assertEquals( "Verd", retrieved.getAddress() );
        assertEquals( "konge", retrieved.getRole() );
    }
}
