package alg;

/* PROBLEM DESCRIPTION
Given a N*N board with the Knight placed on the first block of an empty board. 
Moving according to the rules of chess knight (only the L moves) must visit each square exactly once. 
Print the order of each cell in which they are visited.
*/

public class KnightTour {

    private int[][] board;
    private boolean risolto=false;

    public void knightBeginHisJourney(int n){
        
        board=new int[n][n];

        //inizializzo la board
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=-1;
            }
        }

        backTracking(0, 0, -1, n);

    }

    public void backTracking(int x, int y, int k, int n){
        
        if(isSolution(k,n)){
            processSolution(k,n);
            
            //dato che ne trova parecchie di soluzioni, esco alla prima
            System.exit(0);

        }else{

            k=k+1;
            int[][] moves=construcCancdidates(k,n);

            //System.out.println(moves[0].length);

            for(int i=0;i<moves[0].length;i++){
                
                //costruisco nuove coordinate e le controllo
                int nextX=x+moves[0][i];
                int nextY=y+moves[1][i];

                //prima mossa in assoluto
                if(k==0){
                    board[0][0]=0;
                    backTracking(0, 0, k, n);

                    if(!risolto){
                        System.out.println("Non esiste soluzione");
                        return;
                    }

                //se la mossa va fuori board viene scartata a prescindere
                }else if(isSafe(nextX, nextY, n)){
                    
                    //System.out.println("x: "+nextX+" e y: "+nextY+" sono safe");
                    //schema backtracking
                    board[nextX][nextY]=k;
                    backTracking(nextX, nextY, k, n);
                    board[nextX][nextY]=-1; // unmake the move yo

                }

            }
        
        }

    }

    public int[][] construcCancdidates(int k, int n){
    
        //le mosse del pezzo degli scacchi cavallo sono sempre le stesse
        int[][] moves=new int[2][8];

        //assegnazione mosse un po' noiosa
        //la riga 0 indica la mossa x, mentre la riga 1 quella y
        int[] movex={-1,-2,-2,-1,1,2,2,1};
        int[] movey={-2,-1,1,2,2,1,-1,-2};

        for(int i=0;i<8;i++){
            moves[0][i]=movex[i];
            moves[1][i]=movey[i];
        }

        return moves;

    }

    public boolean isSafe(int x, int y, int n){
        return (x>=0 && x<n && y>=0 && y<n && board[x][y]==-1);
    }

    public boolean isSolution(int k, int n){
        
        if(k==(n*n)-1){
            return true;
        }else{
            return false;
        }

    }

    public void processSolution(int k, int n){

        //setto che ho risolto il problema
        risolto=true;
        
        System.out.println("Il cavaliere ha finito il suo lungo viaggio...");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Complimenti cavaliere, siamo tutti fieri di te");

    }

    public static void main(String[] args) throws Exception {
        
        KnightTour knight=new KnightTour();
        knight.knightBeginHisJourney(8);

    }
}
