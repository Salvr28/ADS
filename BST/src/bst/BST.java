package bst;
import node.Node;

public class BST {

    private Node root;

    public BST(){
    }

    public Node getRoot(){
        return root;
    }

    //funzione di stampa del bst in ordine crescente di chiave
    public void visitTree(Node n){

        if(n!=null){
            visitTree(n.getSinistro());
            System.out.print(n.getKey()+" ");
            visitTree(n.getDestro());
        }

    }

    public Node search(Node n, int k){
        
        if(n==null || n.getKey()==k){
            return n;
        }

        if(k<n.getKey()){
            return search(n.getSinistro(),k);
        }else{
            return search(n.getDestro(),k);
        }

    }

    public Node minTree(Node n){

        //problema passaggio per riferimento java
        Node x=n;

        while(x.getSinistro()!=null){
            x=x.getSinistro();
        }

        return x;
    }

    public Node maxTree(Node n){
        Node x=n;

        while(x.getDestro()!=null){
            x=x.getDestro();
        }

        return x;
    }

    public Node successor(Node n){
        
        //caso facile, prendo il più piccolo del sottoTree di destra
        if(n.getDestro()!=null){
            return minTree(n);
        }

        //altrimenti devo prendere l'antenato di n più in alto a sinistra
        Node y=n.getPadre();
        Node x=n;

        //risalgo albero fino a che x è destro di y
        while(y!=null && x==y.getDestro()){
            x=y;
            y=y.getPadre();
        }

        return y;

    }

    public void insert(Node n){
        Node y=null;
        Node x=this.root;

        //albero non vuoto
        while(x!=null){
            y=x;

            //trovo posizione dove inserire
            if(n.getKey()<x.getKey()){
                x=x.getSinistro();
            }else{
                x=x.getDestro();            
            }

        }

        //setto il padre di nodo da inserire ultimo nodo trovato
        n.setPadre(y);

        if(y==null){
           this.root=n;// albero vuoto    
        }else if(n.getKey()<y.getKey()){
            y.setSinistro(n);
        }else if(n.getKey()>=y.getKey()){
            y.setDestro(n);
        }

    }

    public void delete(Node n){
        Node y;
        Node x;
        
        //divisione casi di delete, nodo non ha figli, ne ha uno, ne ha due
        if(n.getSinistro()==null || n.getSinistro()==null){
            y=n;
        }else{
            y=successor(n);
        }

        //controllo se y ha un figlio sinistro o destro, setto x come il figlio
        if(y.getSinistro()!=null){
            x=y.getSinistro();
        }else{
            x=y.getDestro();
        }

        //se x, figlio di y, non è nullo attacco il padre di x a quello di y
        if(x!=null){
            x.setPadre(y.getPadre());
        }

        if(y.getPadre()==null){
            this.root=x; //elimino la radice e sostituisco
        }else if(y==y.getPadre().getSinistro()){
            y.getPadre().setSinistro(x);
        }else if(y==y.getPadre().getDestro()){
            y.getPadre().setDestro(x);            
        }

        if(n!=y){
            n.setKey(y.getKey());
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
