package FunctionLayer;

public class Drawing {

    public static String draw(Order order) {
        String viewbox  = "0 0 " + order.getCarportLength() + " " + order.getCarportWidth();

        Svg svg = new Svg(order.getCarportLength(), order.getCarportWidth(), viewbox , 0,0 );
        for(Pair p: order.getComponentList()) {

            float x = 0;
            float y = 0;
            int divisor = 0;
            float offset = 0;

            if ( p.getKey().getType().equals("Spær") ){

                divisor = p.getValue() -2 +1; // amount is calculated using the divisor in the Calculator class, the subtraction undoes the calculations, giving us the divisor.
                int spacing = order.getCarportLength() / divisor;
                Material mat = p.getKey();
                offset = mat.getWidth() / 2;

                while( x <= order.getCarportLength() ) {
                    svg.addRect(x - offset , y , mat.getLength() , mat.getWidth() );
                    x += spacing;
                }
            }

            if ( p.getKey().getType().equals("Stolpe") ){

                int length = order.getCarportLength() - Calculator.MODULESIZE * 2;
                divisor = (p.getValue() / 2) -2 +1; // amount is calculated using the divisor in the Calculator class, the subtraction undoes the calculations, giving us the divisor.
                int spacing = length / divisor;
                Material mat = p.getKey();

                y = Calculator.MODULESIZE;
                x = Calculator.MODULESIZE;
                while( x <= length ) {
                    svg.addRect(x , y , mat.getHeight() , mat.getWidth() );
                    x += spacing;
                }

                y = order.getCarportWidth() - Calculator.MODULESIZE;
                x = Calculator.MODULESIZE;
                System.out.println("Length: " + length + " Spacing: " + spacing);
                while( x <= length ) {
                    svg.addRect(x , y , mat.getHeight() , mat.getWidth() );
                    x += spacing;
                }
                x = order.getCarportLength() - Calculator.MODULESIZE;
                svg.addRect(x , y , mat.getHeight() , mat.getWidth() );
                y = Calculator.MODULESIZE;
                svg.addRect(x , y , mat.getHeight() , mat.getWidth() );
            }
        }
        if ( p.getKey().getType().equals("Rem") ){



        return svg.toString();
    }
}