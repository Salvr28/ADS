package skylineObjects;

public class Strip {

    private int x; //coordinata di sinistra
    private int height;

    public Strip(int x, int h){
        this.x=x;
        this.height=h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
