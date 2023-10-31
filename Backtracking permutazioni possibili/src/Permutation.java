import java.util.ArrayList;

public class Permutation {

    private static int MAX_C=10;
    private static int MAX_S=10;
    private ArrayList<Integer> a=new ArrayList<Integer>();

    public void generatePermutation(int n){
        
        //inizializzo vettore soluzioni a tutti -1 per max soluzioni
        for(int i=0;i<MAX_S;i++){
            a.add(-1);
        }

        //chiamo backtrack con valori nascosti ad utente
        backtrack(-1, n);

    }

    public void backtrack(int k, int n){
        
        ArrayList<Integer> c=new ArrayList<Integer>();

        if(isSolution(k,n)){
            processSolution(k,n);
        }else{
            
            k=k+1;
            c=constructCandidates(k,n);

            for(int i=0;i<c.size();i++){

                a.set(k, c.get(i));//scendo nodo
                backtrack(k,n);//richiamo Backtrack
                a.set(k, -1);//faccio unmove

            }

        }

    }

    public boolean isSolution(int k, int n){
        if(k==n-1){
            return true;
        }else{
            return false;
        }
    }

    //funzione che elabora la soluzione
    public void processSolution(int k, int n){

        //semplice funzione che stampa tutte le permutazioni
        System.out.print("{ ");
        for(int i=0;i<n;i++){
            System.out.print(a.get(i)+1+" ");
        }
        System.out.print("}\n");
                
    }

    //funzione che mi costruisce i nodi candidati ad ogni livello dell'albero depth first
    public ArrayList<Integer> constructCandidates(int k, int n){
        
        //metodo ingegnoso per tenere conto delle permutazioni
        boolean[] perm=new boolean[MAX_C];
        ArrayList<Integer> c=new ArrayList<Integer>();

        //inizialmente setto un vettore di appoggio bool, tutto a false
        for(int i=0;i<MAX_C;i++){
            perm[i]=false;
        }

        //poi setto a true tutte le posizioni degli elementi già presenti in vettore soluzioni
        for(int i=0;i<k;i++){
            perm[a.get(i)]=true;
        }

        //aggiungo nel vettore di candidati solo i numeri che non sono già presenti
        for(int i=0;i<n;i++){
            
            //controllo qui se è presente, altrimenti aggiungo
            if(!perm[i]){
                c.add(i);
            }

        }

        return c;

    }

    public static void main(String[] args) throws Exception {
        
        Permutation perm=new Permutation();
        perm.generatePermutation(3);

    }
}
