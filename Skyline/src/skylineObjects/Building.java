package skylineObjects;

public class Building {

    private int left;
    private int right;
    private int height;

    public Building(int l, int h, int r){
        this.height=h;
        this.left=l;
        this.right=r;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
