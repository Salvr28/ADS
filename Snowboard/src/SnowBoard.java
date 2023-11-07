import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SnowBoard {

    int[][] board;
    int[][] matLen;

    public void beginSnowBoarding(File file) throws FileNotFoundException{
        Scanner scan=new Scanner(file);
        int nTest=0;

        while(scan.hasNextLine()){
            
            nTest=scan.nextInt();

            for(int k=0;k<nTest;k++){
                
                int n=0;
                String nome="";

                nome=scan.next();
                n=scan.nextInt();
                board=new int[n][n];
                matLen=new int[n][n];

                //inizializzo le due board
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        board[i][j]=scan.nextInt();
                        matLen[i][j]=0;
                    }
                }

                printBoard();
                findSolution(0, n, nome);

            }

        }

        scan.close();

    }

    public void updateMatrixLen(int k, int n, int xTurn, int yTurn){

        //ogni volta che faccio un passo in più aggiorno
        if(k>matLen[xTurn][yTurn]){
            matLen[xTurn][yTurn]=k;
        }
        
    }

    //trova lunghezza percorso più lungo, per adesso non ho previsto la presenza di più percorsi massimi
    public void findSolution(int k, int n,String nome){
        
        //uso backtrack per ogni posizione, cosi mi costruisco la matrice di lunghezze
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //strano a dirsi, ma partendo ogni volta da i j, il primo backtrack sarà da i e j
                backTrack(k, n, i, j, i, j);
                printMatLen();
            }
        }

        int max=matLen[0][0];
        int xMax=0;
        int yMax=0;

        //una volta costruita la matrice di lunghezze, trovo l'elemento più grande
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matLen[i][j]>max){
                    max=matLen[i][j];
                    xMax=i;
                    yMax=j;
                }
            }
        }

        System.out.println("Per la matrice "+nome+" il percorso più lungo è di "+max+" passi a partire da ("+xMax+","+yMax+")");

    }

    public void backTrack(int k, int n, int xTurn, int yTurn, int x, int y){

        //eventualemente deve aggiornare sempre se ha trovato una lunghezza maggiore per quella posizione
        updateMatrixLen(k,n,xTurn,yTurn);

        //costruisco solo la matrice di len
        k=k+1;
        int[][] c=constructCandidates(k, n);

        for(int i=0;i<c[0].length;i++){

            int newx=x+c[0][i];
            int newy=y+c[1][i];

            if(isSafe(k,n,newx,newy,x,y)){
                int temp=board[x][y];//salvo temporaneamente
                board[x][y]=-1;//segno -1 per far capire che ci sono passato
                backTrack(k, n, xTurn, yTurn, newx, newy);
                board[x][y]=temp;//unmake move
            }

        }
        
    }

    //costruzione di 4 mosse come al solito
    public int[][] constructCandidates(int k, int n){
        int[][] c=new int[2][4];

        int[] x={0,1,-1,0};
        int[] y={1,0,0,-1};

        for(int i=0;i<4;i++){
            c[0][i]=x[i];
            c[1][i]=y[i];
        }

        return c;

    }

    public boolean isSafe(int k, int n, int newx, int newy, int x, int y){
        return (newx>=0 && newx<n && newy>=0 && newy<n && board[x][y]>=board[newx][newy] && board[newx][newy]!=-1);
    }

    public void printMatLen(){
        System.out.println("Ecco la MatLen: ");
        for(int i=0;i<matLen.length;i++){
            for(int j=0;j<matLen[i].length;j++){
                System.out.printf("%4d",matLen[i][j]);
            }
            System.out.println();
        }
    }

    public void printBoard(){
        System.out.println("Ecco la Board: ");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.printf("%4d",board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        SnowBoard s=new SnowBoard();
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Snowboard\\src\\snowboard\\testFile.txt");
        s.beginSnowBoarding(file);

    }
}
