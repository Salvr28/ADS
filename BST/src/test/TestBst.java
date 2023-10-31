package test;
import bst.BST;
import node.Node;

public class TestBst {
    
    public static void main(String[] args){
        
        BST bst=new BST();
        int[] arr={2,4,7,13,26,3,5,18,10};

        for(int i=0;i<arr.length;i++){
            Node n=new Node(arr[i]);
            bst.insert(n);
        }

        //stampo per verificare inserimento
        System.out.println("L'albero generato è: ");
        bst.visitTree(bst.getRoot());

        System.out.println("\nProvo a cercare elemento 7");
        if(bst.search(bst.getRoot(), 7)!=null){
            System.out.println("Elemento 7 trovato");
        }else{
            System.out.println("Elemento 7 NON trovato");
        }

        System.out.println("Elimino elemento 7");
        bst.delete(bst.search(bst.getRoot(), 7));
        System.out.println("L'albero generato è: ");
        bst.visitTree(bst.getRoot());

        System.out.println("\nInserisco elemento 12");
        bst.insert(new Node(12));
        System.out.println("L'albero generato è: ");
        bst.visitTree(bst.getRoot());

    }

}
