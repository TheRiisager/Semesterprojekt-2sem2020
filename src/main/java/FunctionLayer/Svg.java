package FunctionLayer;

import java.util.Locale;

public class Svg {

    private int width;
    private int height;
    private String viewbox;
    private int x;
    private int y;
    private StringBuilder svg = new StringBuilder();

    private final String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"%s\" width=\"%s\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String crossTemplate = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000; stroke-dasharray: 5 5\" />";
    private final String lineTemplate = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000; marker-start: url(#beginArrow); marker-end: url(#endArrow);\" />";



    private final String arrowheadTemplate = "<marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">" +
                                         "<path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />" +
                                         "</marker>" +
                                         "<marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">" +
                                         "<path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />" +
                                         "</marker>";

    public Svg(int width, int height, String viewbox, int x, int y) {
        this.width = width;
        this.height = height;
        this.viewbox = viewbox;
        this.x = x;
        this.y = y;
        svg.append(String.format(headerTemplate, height, width, viewbox));
        svg.append(arrowheadTemplate);
    }

    public void addRect(float x, float y, float height, float width){
        svg.append(String.format(Locale.US , rectTemplate, x, y, height, width) );
    }

    public void addCross(float x1, float y1, float x2, float y2) {
        svg.append(String.format(Locale.US, crossTemplate, x1, y1, x2, y2));
        svg.append(String.format(Locale.US, crossTemplate, x2, y1, x1, y2));

    }

    public void addArrows(float x1, float y1, float x2, float y2) {
        svg.append(String.format(Locale.US, lineTemplate, x1, y1, x2, y2));
    }



    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getViewbox() {
        return viewbox;
    }

    public void setViewbox(String viewbox) {
        this.viewbox = viewbox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>" ;
    }
}