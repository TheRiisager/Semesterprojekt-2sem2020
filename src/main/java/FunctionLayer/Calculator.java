package FunctionLayer;

public class Calculator {

    final static int MODULESIZE = 30;
    private static int spaerSpacing = 2;
    private static int stolpeSpacing = 10;

    public static Pair calculateParts( Order order , Material material ) {

        int amount;

        if( material.getType().equals( "spær" ) ){
            amount = (order.getCarportLength() / MODULESIZE) / spaerSpacing;

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

    public static Material findMaterial( String type , Order order) {
        Material suitableMat = null;

        if ( type.equals( "spær" ) ) {
            for ( Material m : Material.materialList ) {
                if( m.getLength() >= order.getCarportWidth() && suitableMat == null && m.getType().equals( type ) ) {
                    suitableMat = m;
                } else if ( m.getLength() >= order.getCarportWidth() && m.getLength() < suitableMat.getLength() && m.getType().equals( type ) ) {
                    suitableMat = m;
                }
            }
            return suitableMat;
        }

        if ( type.equals( "rem" ) ) {
            for ( Material m : Material.materialList ) {
                if( m.getLength() >= order.getCarportLength() && suitableMat == null && m.getType().equals( type ) ) {
                    suitableMat = m;
                } else if ( m.getLength() >= order.getCarportLength() && m.getLength() < suitableMat.getLength() && m.getType().equals( type ) ) {
                    suitableMat = m;
                }
            }
            return suitableMat;
        }

        if ( type.equals( "stolpe" ) ) {
            for ( Material m : Material.materialList ) {
                if( m.getType().equals( type ) ) {
                    suitableMat = m;
                }
            }
            return suitableMat;
        }

        System.out.println("No suitable material found. Maybe the type doesn't exist?");
        return null;
    }

}
