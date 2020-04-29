package FunctionLayer;
import java.util.ArrayList;
import java.util.Objects;

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

}
