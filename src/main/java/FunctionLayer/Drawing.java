package FunctionLayer;

import java.util.ArrayList;

public class Drawing {

    public static ArrayList<Integer> widthLengthOptionsArray() {
        ArrayList<Integer> widthLengthArray = new ArrayList<>();
        int number = 300;
        while (number <= 900) {
            widthLengthArray.add(number);
            number = number + 30;

        }


        return widthLengthArray;
    }

    public static String draw(Order order) {
        int viewBoxWidth = order.getCarportLength()+100;
        int viewBoxLength = order.getCarportWidth()+100;
        String viewbox = "0 0 " + viewBoxWidth + " " + viewBoxLength;

        Svg svg = new Svg(order.getCarportLength(), order.getCarportWidth(), viewbox, 0, 0);
        svg.addArrows(order.getCarportWidth()+30, 0, order.getCarportWidth()+30, order.getCarportLength());
        svg.addArrows(0, order.getCarportLength()+30, order.getCarportWidth(), order.getCarportLength()+30);
        float remWidth = 0;
        float remY = 0;

        for (Pair p : order.getComponentList()) {

            float x = 0;
            float y = 0;
            int divisor = 0;
            float offset = 0;

            float x2 = 0;
            float y2 = 0;
            System.out.println(remY);

            if (p.getKey().getType().equals("Rem")) {
                y = Calculator.MODULESIZE;
                int length = order.getCarportLength();
                int spacing = order.getCarportWidth() - Calculator.MODULESIZE * 2;
                Material mat = p.getKey();
                offset = mat.getWidth() / 2;
                remWidth = mat.getWidth();
                remY = y + offset;
                System.out.println(remY);


                while (y <= length) {
                    svg.addRect(x, y + offset, mat.getWidth(), length);
                    y += spacing;
                }

            }

            if (p.getKey().getType().equals("Spær")) {

                divisor = p.getValue() - 2 + 1; // amount is calculated using the divisor in the Calculator class, the subtraction undoes the calculations, giving us the divisor.
                int spacing = order.getCarportLength() / divisor;
                Material mat = p.getKey();
                offset = mat.getWidth() / 2;

                while (x <= order.getCarportLength()) {
                    svg.addRect(x - offset, y, mat.getLength(), mat.getWidth());
                    x += spacing;
                }
            }

            if (p.getKey().getType().equals("Stolpe")) {

                int length = order.getCarportLength() - Calculator.MODULESIZE * 2;
                divisor = (p.getValue() / 2) - 2 + 1; // amount is calculated using the divisor in the Calculator class, the subtraction undoes the calculations, giving us the divisor.
                int spacing = length / divisor;
                Material mat = p.getKey();

                y = Calculator.MODULESIZE;
                x = Calculator.MODULESIZE;
                while (x <= length) {
                    svg.addRect(x, y, mat.getHeight(), mat.getWidth());
                    x += spacing;
                }

                y = order.getCarportWidth() - Calculator.MODULESIZE;
                x = Calculator.MODULESIZE;
                System.out.println("Length: " + length + " Spacing: " + spacing);
                while (x <= length) {
                    svg.addRect(x, y, mat.getHeight(), mat.getWidth());
                    x += spacing;
                }
                x = order.getCarportLength() - Calculator.MODULESIZE;
                svg.addRect(x, y, mat.getHeight(), mat.getWidth());
                y = Calculator.MODULESIZE;
                svg.addRect(x, y, mat.getHeight(), mat.getWidth());
            }

            if(p.getKey().getType().equals("Kryds")){
                y = remY + remWidth;
                x = Calculator.MODULESIZE * 2;
                x2 = (order.getCarportLength() - Calculator.MODULESIZE) / 3 *2;
                y2 = order.getCarportLength() - Calculator.MODULESIZE;

                svg.addCross(x , y, x2, y2);
            }
        }



        return svg.toString();

    }
}