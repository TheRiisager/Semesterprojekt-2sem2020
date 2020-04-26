package FunctionLayer;

import javafx.util.Pair;

public class Calculator {

    final static int MODULESIZE = 30;
    private static int spærSpacing = 2;
    private static int stolpeSpacing = 10;

    public static Pair calculateParts(Order order, Material material) {

        int amount;

        if( material.getType().equals( "spær" ) ){
            amount = (order.getCarportLength() / MODULESIZE) / spærSpacing;

            return new Pair( material , amount );
        }

        if( material.getType().equals( "rem" ) ){
            return new Pair( material , 2);
        }

        if ( material.getType().equals( "stolpe" ) ){
            amount = (order.getCarportLength() / MODULESIZE) / stolpeSpacing;
        }

        return null;
    }

}
