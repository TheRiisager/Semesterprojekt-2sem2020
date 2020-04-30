package DBAccess;

import FunctionLayer.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialMapper {


    public static ArrayList<Material> loadMaterials(){

        ArrayList<Material> materials = new ArrayList<>();

        try{
                Connection con = Connector.connection();
                String SQL = "SELECT * FROM Material;";
                PreparedStatement ps = con.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();

                while ( rs.next() ) {
                    int materialID = rs.getInt("materialID");
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    float price = rs.getInt("price");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    materials.add(new Material(materialID, width, length, height, type, name, price));
                }
                return materials;

        }catch(SQLException e){
            System.out.println(e);
            System.out.println("SQL exception in MaterialMapper.loadMaterials()");

        }catch(ClassNotFoundException a){
            System.out.println(a);
            System.out.println("ClassNotFound Exception in MaterialMapper.loadMaterials()");
        }

        return null;
    }





    }

