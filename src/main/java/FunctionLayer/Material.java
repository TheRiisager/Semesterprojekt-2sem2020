package FunctionLayer;

import java.util.ArrayList;

public class Material {
    public static ArrayList<Material> materialList = new ArrayList<>();

    private int materialID;
    private float width;
    private float length;
    private float height;

    private String type;
    private String name;

    private float price;

    public Material( int materialID, float width, float length, float height, String type, String name, float price ) {
        this.materialID = materialID;
        this.width = width;
        this.length = length;
        this.height = height;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static void InitMaterials(){
        materialList = LogicFacade.loadMaterials();
    }

    public static ArrayList<Material> getMaterialList() {
        return materialList;
    }

    @Override
    public String toString(){
        return name + " (" + width + "x" + height + ")";
    }
}
