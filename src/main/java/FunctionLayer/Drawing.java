package FunctionLayer;

public class Drawing {

    public static String draw(Order order) {

        Svg svg = new Svg(order.getCarportLength(), order.getCarportWidth() "0,0," + (order.getCarportLength() / 2) + "," + (order.getCarportWidth / 2), 0,0 );
        for(Pair p: order.getComponentList()) {

            if (p.getKey().  )

        }


    }
}