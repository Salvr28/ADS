public class SnowBoard {

    int[][] board;
    int[][] matLen;

    public void updateMatrixLen(int k, int n){
        
    }

    public void processSolution(int k, int n){
    
    }

    public void backTrack(int k, int n){

        //costruisco solo la matrice di len
        k=k+1;
        int[][] c=constructCandidates(k, n);

        for(int i=0;i<c[0].length;i++){
            if(isSafe(int k, int n)){
            
            }

        }
        
    }

    public int[][] constructCandidates(int k, int n){
        int[][] c=new int[n][n];

        int[] x={0,1,-1,0};
        int[] y={1,0,0,-1};

        for(int i=0;i<4;i++){
            c[0][i]=x[i];
            c[1][i]=y[i];
        }

        return c;

    }

    public boolean isSafe(int k, int n, int newx, int newy, int x, int y){
        return (newx>=0 && newx<n && newy>=0 && newy<n && board[x][y]>=board[newx][newy]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
