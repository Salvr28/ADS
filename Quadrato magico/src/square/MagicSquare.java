package square;

/*
A magic square of order n is an arrangement of n2 numbers, usually distinct integers, in a square, such that the n numbers in all rows, all columns, and both diagonals sum to the same constant. A magic square contains the integers from 1 to n2. 
The constant sum in every row, column and diagonal are called the magic constant or magic sum, M. The magic constant of a normal magic square depends only on n and has the following value: 
M = n(n2+1)/2 
 */

public class MagicSquare {

    private int MagicNumber;
    private int[][] square;

    public void magicSquare(int n){
        
        square=new int[n][n];

        this.MagicNumber=(n*((n*n)+1))/2;

        //inizializzo a tutti zeri
        for(int i=0;i<square.length;i++){
            for(int j=0;j<square[i].length;j++){
                square[i][j]=0;
            }
        }

        backTracking(-1,n);

    }

    public void backTracking(int k, int n){
        
        if(isSolution(k, n)){
            processSolution(k, n);
        }else{
            
            k=k+1;
            int[] c=constructCandidates(k,n);

            //per scorrere matrice con indice k si sfrutta la divisione per le righe e modulo per colonne
            for(int i=k/n;i<square.length;i++){
                for(int j=0;j<c.length;j++){
                    
                    //inserisco solo se la casella è "vuota"
                    if(square[i][k%n]==0){
                        
                        //soliti passaggi del backtracking
                        square[i][k%n]=c[j];
                        backTracking(k, n);
                        square[i][k%n]=0;

                    }

                }
            }

        }

    }

    public int[] constructCandidates(int k, int n){
        
        //i candidati non dovrebbero cambiare in base a k
        //per ogni casella andrà provato un numero da 1 a n^2
        int[] c=new int[n*n];

        for(int i=0;i<c.length;i++){
            c[i]=i+1;
        }

        return c;
    }

    public boolean isSolution(int k, int n){
    
        //condizione di terminazione più complessa rispetto al solito
        boolean res=false;
        int sumRow=0;
        int sumCol=0;
        int diag1=0;
        int diag2=0;

        //se la matrice è piena controllo il numero magico per righe colonne e diagonali
        if(k==(n*n)-1){
            
            //System.out.println("Matrice piena, controllo...");
            for(int i=0;i<square.length;i++){
                for(int j=0;j<square[i].length;j++){
                    //aggiorno le somme
                    sumRow += square[i][j];
                    sumCol += square[j][i];
                }

                diag1 += square[i][i];
                diag2 += square[i][square.length-1-i];

                //questi controlli li posso fare nel frattempo che scorro il ciclo for
                if(sumRow!=MagicNumber || sumCol!=MagicNumber){
                    //System.out.println("riga o colonna Sbagliata");
                    return res;
                }

                //le riaggiorno per un nuovo giro del ciclo
                sumRow=0;
                sumCol=0;

            }

            //le diagonali le controllo fuori
            if(diag1!=MagicNumber || diag2!=MagicNumber){
                //System.out.println("diagonale Sbagliata");
                return res;
            }

            //se passo i controlli incolume posso dire che ho la soluzione
            res=true;

        }

        return res;

    }

    public void processSolution(int k, int n){

        System.out.println("Una soluzione: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(square[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) throws Exception {
        MagicSquare magic=new MagicSquare();

        magic.magicSquare(3);

    }
}
