package FunctionLayer;

import java.util.ArrayList;

public class Material {
    public static ArrayList<Material> materialList;

    private int materialID;
    private int width, length, height;

    private String type;
    private String name;

    private float price;

    public Material( int materialID, int width, int length, int height, String type, String name, float price ) {
        this.materialID = materialID;
        this.width = width;
        this.length = length;
        this.height = height;
        this.type = type;
        this.name = name;
        this.price = price;

        if( materialList.isEmpty() ){
            materialList = LogicFacade.loadMaterials();
        }
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        return name + " (" + length + "x" + width + "x" + height + ")";
    }
}
