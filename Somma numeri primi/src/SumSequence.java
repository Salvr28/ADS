import java.util.ArrayList;

public class SumSequence {

    private ArrayList<Integer> a=new ArrayList<Integer>();
    private static int MAX_S=50;

    public void generateSequence(int sum, int n, int p){
        for(int i=0;i<MAX_S;i++){
            a.add(-1);
        }

        backtrack(-1, n, sum, p);
    }

    public void backtrack(int k, int n, int sum, int p){
        
        if(isSolution(k, n, sum)){
            processSolution(k, n);
        }else{
            
            //System.out.println("k prima: "+k);
            k=k+1;
            //System.out.println("k dopo: "+k+"\n");
            /* 
            for(int i=0;i<a.size();i++){
                System.out.print(a.get(i)+" ");
            }
            System.out.print("\n");
            */

            ArrayList<Integer> c=constructCandidates(k, n, sum, p);

            for(int i=0;i<c.size();i++){
                
                a.set(k, c.get(i));
                backtrack(k, n, sum, p);
                a.set(k, -1);

            }

        }

    }

    public boolean isPrime(int n){
        int fattori=1;
        int j=1;

        for(j=1;j<=(n/2)+1;j++){
            if(n%j==0){
                fattori++;
            }
        }

        //System.out.println("Numero fattori: "+fattori);

        return (fattori==2);
    }

    public boolean isSolution(int k, int n, int sum){
    
        if(k==n-1){

            int aSum=0;
            
            //costruisco somma da confrontare
            for(int i=0;i<n;i++){
                aSum += a.get(i);
            }

            if(aSum==sum){
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }

    }

    public ArrayList<Integer> constructCandidates(int k, int n, int sum, int p){
        
        ArrayList<Integer> c=new ArrayList<Integer>();
        ArrayList<Integer> primi=new ArrayList<Integer>();

        //costruiamo il vettore dei numeri primi
        for(int i=p+1;i<sum;i++){
            if(isPrime(i)){
                primi.add(i);
            }
        }

        //me lo stampo un attimo
        /* 
        for(int i=0;i<primi.size();i++){
            System.out.print(primi.get(i)+" ");
        }
        */

        //li metto nel vettore dei candidati se non eccede a[k]
        for(int i=0;i<primi.size();i++){

            //per inizializzazione di a, devo stare attento alla prima volta che inserisco nel vettore
            if(k==0 && a.get(k)==-1){//non posso controllare a[-1]
                c.add(primi.get(i));
            }else if(primi.get(i)>a.get(k-1)){//qui posso controllare il numero precedente
                c.add(primi.get(i));
            }

        }

        return c;

    }

    public void processSolution(int k, int n){

        System.out.print("{ ");
        for(int i=0;i<n;i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.print("}\n");
        
    }

    public static void main(String[] args) throws Exception {
        
        SumSequence s=new SumSequence();
        s.generateSequence(63, 3, 5);

    }
}
