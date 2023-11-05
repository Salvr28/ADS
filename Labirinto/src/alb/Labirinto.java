package alb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labirinto {

    private int[][] lab;
    private int[][] board;


    public void generateSolution(File file) throws FileNotFoundException{
    
        Scanner scan=new Scanner(file);
        int nTest=0;

        while (scan.hasNextLine()) {
            
            nTest=scan.nextInt();
            int nx=0;
            int ny=0;

            for(int i=0;i<nTest;i++){
                nx=scan.nextInt();
                ny=scan.nextInt();

                lab=new int[nx][ny];
                board=new int[nx][ny];

                for(int j=0;j<nx;j++){
                    for(int k=0;k<ny;k++){
                        board[j][k]=0;
                    }
                }

                for(int j=0;j<nx;j++){
                    for(int k=0;k<ny;k++){
                        lab[j][k]=scan.nextInt();
                    }
                }

                backTrack(-1, nx, 0, 0);

            }

        }

        scan.close();

    }

    public boolean isSolution(int k, int n){
        if(board[n-1][n-1]==1){
            return true;
        }else{
            return false;
        }
    }

    public void processSolution(int k, int n){
    
        System.out.println("Una soluzione: ");
        board[0][0]=1;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    public void backTrack(int k, int n, int x, int y){
    
        if(isSolution(k, n)){
            processSolution(k, n);
        }else{
            k=k+1;
            int[][] c=constructCandidates(k, n);

            for(int i=0;i<c[0].length;i++){
            
                int newX=x+c[0][i];
                int newY=y+c[1][i];

                //se la mossa è safe
                if(isSafe(k,n,newX,newY)){
                    board[newX][newY]=1;
                    backTrack(k, n, newX, newY);
                    board[newX][newY]=0;
                }

            }

        }

    }

    public int[][] constructCandidates(int k, int n){
        
        int[][] c=new int[2][2];

        int[] movex={0,1};
        int[] movey={1,0};

        for(int j=0;j<2;j++){
        
            c[0][j]=movex[j];
            c[1][j]=movey[j];
            
        }

        return c;

    }

    public boolean isSafe(int k, int n, int x, int y){
        
        return (x>=0 && x<n && y>=0 && lab[x][y]!=0);

    }

    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Labirinto\\src\\alb\\testFile.txt");
        Labirinto l=new Labirinto();
        l.generateSolution(file);
    }
}
