package FunctionLayer;

public class Pair {
    private Material key;
    private int value;

    public Pair(Material key, int value){
        this.key = key;
        this.value = value;
    }

    public Material getKey() {
        return key;
    }

    public void setKey(Material key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
