package treap;
import java.util.ArrayList;
import nodo.Nodo;

public class Treap {

    ArrayList<Nodo> treap;

    public Treap(){
        treap=new ArrayList<Nodo>();
    }

    public ArrayList<Nodo> getTreap(){
        return treap;
    }

    public Nodo rightRotate(Nodo y){
    
        Nodo x=y.getLeft();
        Nodo T=x.getRight();

        x.setRight(y);
        y.setLeft(T);

        return x;
    
    }

    public Nodo leftRotate(Nodo x){
    
        Nodo y=x.getRight();
        Nodo T=y.getLeft();

        y.setLeft(x);
        x.setRight(T);

        return y;
    
    }


    //controllo solo per la chiave se è già presente
    public boolean checkNodo(Nodo n){
    
        //ritorna true se il controllo va a buon fine:
        //posso inserire se ritorna true
        if(treap.size()==0){
            return true;
        }

        for(int i=0;i<treap.size();i++){
            
            if(n.getKey()==treap.get(i).getKey() || n.getPrio()==treap.get(i).getPrio()){
                return false;
            }

        }

        return true;

    }

    public Nodo insert(Nodo root, int k){
        
        //se albero vuoto o sono arrivato alla fine della ricorsione
        if(root==null){

            Nodo n=new Nodo(k);
            
            //continuo nell'inserimento se posso
            System.out.println("Voglio inserire nodo con key: "+n.getKey()+" e prio: "+n.getPrio());
            boolean check=checkNodo(n);

            if(check){
                treap.add(n);
                return n;
            }else{
                System.out.println("Priorità o chiave già presente");
                return null; 
            }
        }

        //Se la chiave è più piccola si root, inserimento a sinistra
        if(k<root.getKey()){
            
            root.setLeft(insert(root.getLeft(), k));

            //aggiusto heap e prio con subrotate
            if(root.getLeft()!=null && root.getLeft().getPrio()<root.getPrio()){
                root=rightRotate(root);
            }

        //Se chiave è più grande inserimento a destra
        }else{

            root.setRight(insert(root.getRight(), k));

            //aggiusto heap e prio
            if(root.getRight()!=null && root.getRight().getPrio()<root.getPrio()){
                root=leftRotate(root);
            }
        
        }            

        return root;

    }

    public void inorder(Nodo root){

        if (root != null){
            inorder(root.getLeft());
            System.out.print("key: " + root.getKey() + " | priority: " + root.getPrio());
            if (root.getLeft() != null)
                System.out.print(" | left child: " + root.getLeft().getKey());
            if (root.getRight() != null)
                System.out.print(" | right child: " + root.getRight().getKey());
            System.out.println();
            inorder(root.getRight());
        }
    }

    public static void main(String[] args) throws Exception {
        
        Treap t=new Treap();

        Nodo root=null;
        root=t.insert(root,50);
        root=t.insert(root,20);
        root=t.insert(root,60);
        t.inorder(root);
        root=t.insert(root,30);
        root=t.insert(root,50);
        root=t.insert(root,40);
        t.inorder(root);
        root=t.insert(root,90);    
        root=t.insert(root,80);
        t.inorder(root);

    }
}
