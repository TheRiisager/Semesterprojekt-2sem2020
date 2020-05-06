package FunctionLayer;

public class Drawing {

    public static String draw(Order order) {
        String viewbox  = "0,0," + order.getCarportLength() + "," + order.getCarportWidth();

        Svg svg = new Svg(order.getCarportLength(), order.getCarportWidth(), viewbox , 0,0 );
        for(Pair p: order.getComponentList()) {

            if ( p.getKey().getType().equals("Spær") ){
                float length = order.getCarportLength() - 60;
                int divisor = p.getValue() -2 + 1;
                float spacing = length / divisor;

                int x = 0;
                int y = 0;
                float matlength = p.getKey().getLength();
                float matWidth =  p.getKey().getWidth();

                for(int i = 0 ; i < p.getValue() ; i++) {
                    svg.addRect( x , y , matWidth , matlength );
                    x += spacing - ( matWidth/2 );
                }

            }

        }

        return svg.toString();
    }
}