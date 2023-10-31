import java.util.ArrayList;

public class BackTrack {

    private static int MAX_SIZE_SOLUTION=10;
    private static int MAX_N_CANDIDATE=2;
    private ArrayList<Integer> a=new ArrayList<>();

    public void processSolution(int k){
        System.out.print("{ ");
        for(int i=0;i<=k;i++){
            if(a.get(i)==1){
                System.out.print((i+1)+" ");
            }
        }
        System.out.print("}\n");
    }

    //funzione controllo passo soluzione
    public boolean isSolution(int k, int n){
    
        //k==n-1 perchè ho usato k per indici di vettori
        //vettore di n elementi k=n-1 essendo partito da zero
        if(k==n-1){
            return true;
        }else{
            return false;
        }

    }

    private void backTrack(int k, int n){

        //controlla se siamo arrivati ad un passo dove si è raggiunta una soluzione
        if(isSolution(k,n)){
            processSolution(k);
        }else{
            
            //System.out.println("K prima: "+k);
            k=k+1;
            //System.out.println("K dopo: "+k);

            int[] c=constructCandidates(k,n);

            for(int i=0;i<c.length;i++){

                //passi fondamentali
                a.set(k, c[i]);//1-creo il nodo di dopo settando un candidato
                backTrack(k, n);//scendo nel nodo creato e rifaccio tutto
                a.set(k,-1);//ho finito e sto risalendo, passerò al nodo a fianco per il ciclo for

                //inutile nel programma attuale, servira per pruning futuri(?)
                //------------------------------------------------------
                if(k==n){
                    System.out.println("Sono entrato nel break");
                    break;
                }
                //----------------------------------------------------

            }

        }
        
    }

    //funzione che mi genera i candidati, nodi di un livello k
    public int[] constructCandidates(int k, int n){

        //in contesti differenti cambia in base a k e regole del gioco
        //qui la creazione è sempre la stessa
        int[] c=new int[MAX_N_CANDIDATE];
        
        c[0]=1;
        c[1]=0;

        return c;
    }

    public void generateSubSet(int n){

        //for per inizializzare
        for(int i=0;i<MAX_SIZE_SOLUTION;i++){
            a.add(-1);
        }

        //bisogna stare attenti con gli indici del passo k
        backTrack(-1,n);
    }

    public static void main(String[] args) throws Exception {

        BackTrack back=new BackTrack();
        back.generateSubSet(4);

    }
}