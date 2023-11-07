public class Queens {

    private int[] sol;
    private int[] candidates;
    private int contatore;

    public void resolveQueens(int n){

        if(n<3){
            System.out.println("Si accettano solo valori di board al di sopra di 2");
            return;
        }

        sol=new int[n];
        candidates=new int[n];
        contatore=0;

        //inizializzo vettore soluzione
        //e anche vettore candidati in contemporanea
        for(int i=0;i<n;i++){
            sol[i]=-1;
            candidates[i]=i;
        }

        backTrack(-1, n);

        System.out.println("\nIl numero totale di combinazioni è: "+contatore);
        
    }

    public void processSolution(int k, int n){
        System.out.println("\nUna soluzione: ");
        for(int i=0;i<n;i++){
            System.out.print(sol[i]+1+" ");
        }
        contatore++;
    }

    public boolean isSolution(int k, int n){
    
        if(k==n-1){
            return true;
        }else{
            return false;
        }

    }

    public boolean isSafe(int k, int c){
        //al primo passaggio faccio quello che voglio
        if(k==0){
            return true;
        }else{
        
            //scorro all'indietro il vettore soluzione per controllare
            for(int i=0;i<k;i++){
                if(sol[i]==c || sol[i]==c-k+i || sol[i]==c+k-i){
                    return false;
                }
            }

            return true;

        }
    }

    public void backTrack(int k, int n){

        //printVec(n);
        
        if(isSolution(k, n)){
            processSolution(k, n);
        }else{
            k=k+1;
            
            for(int i=0;i<candidates.length;i++){
                if(isSafe(k, candidates[i])){
                    sol[k]=candidates[i];
                    backTrack(k, n);
                    sol[k]=-1;
                }
            }
            

        }

    }

    public void printVec(int n){
        System.out.println("\nvettore: ");
        for(int i=0;i<n;i++){
            System.out.print(sol[i]+1+" ");
        }
    }

    public static void main(String[] args) throws Exception {
        Queens queens=new Queens();
        queens.resolveQueens(8);
    }
}
