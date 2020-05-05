package FunctionLayer;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Calculator {

    final static int MODULESIZE = 30;
    private static int spaerSpacing = 3 * MODULESIZE;
    private static int stolpeSpacing = 10 * MODULESIZE;

    public static Pair calculateParts( Order order , Material material ) {

        int spacing = 0;

        if( material.getType().equals( "Spær" ) ){
            spacing = spaerSpacing;
        }

        if( material.getType().equals( "Rem" ) ){
            return new Pair( material , 2 );
        }

        if ( material.getType().equals( "Stolpe" ) ){
            spacing = stolpeSpacing;
        }

        if(spacing == 0) {
            System.out.println("Type ikke genkendt, returnerer null");
            return null;
        }

        int amount = 2;
        int divisor = 2;
        float length = order.getCarportLength() - ( MODULESIZE * 2 );

        while(true) {

            float tempLength = length / divisor;

            if( tempLength <= spacing ) {
                amount += divisor -1;
                break;
            }
            divisor++;
        }

        return new Pair( material , amount );
    }

    public static Material findMaterial( String type , Order order ) {
        ArrayList<Material> materialList = (ArrayList<Material>) Material.getMaterialList().clone();
        Material suitableMat = null;

        Predicate<Material> filter = (Material mat) -> ( !mat.getType().equals( type ) );

        if ( type.equals( "Spær" ) ) {
            materialList.removeIf( filter );
            suitableMat = materialList.get(0);
            for ( Material m : materialList ) {
                 if ( m.getLength() >= order.getCarportWidth() && m.getLength() < suitableMat.getLength() ) {
                     suitableMat = m;
                     System.out.println("suitablemat set to " + m.getName());
                }
            }
            System.out.println("found " + suitableMat.getType() + " " + suitableMat.getName());
            return suitableMat;
        }

        if ( type.equals( "Rem" ) ) {
            materialList.removeIf( filter );
            suitableMat = materialList.get(0);
            for ( Material m : materialList ) {
               if ( m.getLength() >= order.getCarportLength() ) {
                    suitableMat = m;
                }
            }
            System.out.println("found " + suitableMat.getType() + " " + suitableMat.getName());
            return suitableMat;
        }

        if ( type.equals( "Stolpe" ) ) {
            materialList.removeIf( filter );
            for ( Material m : materialList ) {
                suitableMat = m;
            }
            System.out.println("found stolpe " + suitableMat.getName() );
            return suitableMat;
        }

        System.out.println("No suitable material found. Maybe the type doesn't exist?");
        return null;
    }

}
