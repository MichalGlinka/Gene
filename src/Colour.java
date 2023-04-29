public class Colour {
    private int r;
    private int g;
    private int b;

    public Colour(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Colour addColour(Colour colour){
        Colour result = new Colour(0,0,0);
        result.r = Math.min(this.r + colour.getR(), 255);
        result.g = Math.min(this.g + colour.getG(), 255);
        result.b = Math.min(this.b + colour.getB(), 255);
        return result;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return r + ";" + g + ";" + b + "m";
    }
}
