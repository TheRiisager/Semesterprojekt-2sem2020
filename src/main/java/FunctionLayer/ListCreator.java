package FunctionLayer;
import java.util.ArrayList;
import java.util.Objects;
import FunctionLayer.Material;

public class ListCreator {

    public static ArrayList<Pair> createList( Order order ){
        ArrayList<Pair> componentList = new ArrayList<>();

        //spær
        componentList.add( Calculator.calculateParts( order, Objects.requireNonNull(Calculator.findMaterial("spær", order) ) ) );

        //stolper
        componentList.add( Calculator.calculateParts( order, Objects.requireNonNull(Calculator.findMaterial("stolpe", order) ) ) );

        //remme
        componentList.add( Calculator.calculateParts( order, Objects.requireNonNull(Calculator.findMaterial("rem", order) ) ) );

        return componentList;

    }

    public static String componentListToString(ArrayList<javafx.util.Pair> componentList){
        String string = "";
        for(javafx.util.Pair p : componentList){
            Material value = (Material) p.getKey();
            int key = (int) p.getValue();

            string += value.getMaterialID() + "," + key + "-";

        }
        return string;
    }

    public static ArrayList<javafx.util.Pair> stringToComponentList(String string){
        ArrayList<javafx.util.Pair> componentList = new ArrayList<>();
        String[] arrOfStr = string.split("-",0);

        for(String a : arrOfStr) {
            String[] arrOfArrOfStr = a.split(",", 0);
            Integer key = Integer.parseInt(arrOfArrOfStr[0]);
            Integer value = Integer.parseInt(arrOfArrOfStr[1]);

            for(Material b : Material.materialList){
                if(b.getMaterialID()==key){
                    componentList.add(new javafx.util.Pair(b,value));
                    break;
                }
            }

        }

        return componentList;
    }

}
