import java.util.ArrayList;

public class Tree {

    private ArrayList<Integer> tree;
    private int altezza;
    private int numeroElementi;

    public Tree(int h){
        this.altezza=h;
        this.numeroElementi=(int)Math.pow(2,altezza)-1;
        this.tree=new ArrayList<Integer>((int)Math.pow(2,altezza)-1);

        for(int i=0;i<numeroElementi+1;i++){
            tree.add(i);
        }
    }

    

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
