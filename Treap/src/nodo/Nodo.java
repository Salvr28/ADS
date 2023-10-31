package nodo;

import java.util.Random;

public class Nodo {
    
    private int key;
    private int prio;
    private Nodo right;
    private Nodo left;

    public Nodo(int k){

        Random rand=new Random();

        this.key=k;
        this.prio=rand.nextInt(31);
        this.right=null;
        this.left=null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

}
