package node;

public class Node {

    private int key;
    private Node padre;
    private Node destro;
    private Node sinistro;

    public Node(int k){
        this.key=k;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getPadre() {
        return padre;
    }

    public void setPadre(Node padre) {
        this.padre = padre;
    }

    public Node getDestro() {
        return destro;
    }

    public void setDestro(Node destro) {
        this.destro = destro;
    }

    public Node getSinistro() {
        return sinistro;
    }

    public void setSinistro(Node sinistro) {
        this.sinistro = sinistro;
    }

    
    
}
