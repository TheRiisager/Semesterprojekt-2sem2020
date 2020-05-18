package FunctionLayer;
import java.util.ArrayList;
import java.util.Objects;

public class ListCreator {

    public static ArrayList<Pair> createList( Order order ){
        ArrayList<Pair> componentList = new ArrayList<>();

        //spær
        componentList.add( Calculator.calculateParts( order, Calculator.findMaterial("Spær", order ) ) );
        System.out.println("spær added");

        //stolper
        componentList.add( Calculator.calculateParts( order, Calculator.findMaterial("Stolpe", order ) ) );
        System.out.println("Stolpe added");

        //remme
        componentList.add( Calculator.calculateParts( order, Calculator.findMaterial("Rem", order ) ) );
        System.out.println("Rem added");

        //kryds
        componentList.add( Calculator.calculateParts( order, Calculator.findMaterial("Kryds", order) ) );

        System.out.println(componentList.get(0).getKey());

        return componentList;

    }

    public static String componentListToString(ArrayList<Pair> componentList){
        String string = "";
        for(Pair p : componentList){
            Material value = p.getKey();
            int key = p.getValue();

            string += value.getMaterialID() + "," + key + "-";

        }
        return string;
    }

    public static ArrayList<Pair> stringToComponentList(String string){
        ArrayList<Pair> componentList = new ArrayList<>();
        String[] arrOfStr = string.split("-",0);

        for(String a : arrOfStr) {
            String[] arrOfArrOfStr = a.split(",", 0);
            Integer key = Integer.parseInt(arrOfArrOfStr[0]);
            Integer value = Integer.parseInt(arrOfArrOfStr[1]);

            for(Material b : Material.materialList){
                if(b.getMaterialID()==key){
                    componentList.add(new Pair(b,value));
                    break;
                }
            }

        }

        return componentList;
    }

}
