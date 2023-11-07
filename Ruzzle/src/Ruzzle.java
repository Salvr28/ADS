import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ruzzle {

    private int[][] candidates={{0,1,1,-1,-1,0,-1,1},
                                {1,0,1,-1,0,-1,1,-1}};
    private char[][] board;
    private int[][] sol;

    public void generateSolution(File file) throws FileNotFoundException{
        Scanner scan=new Scanner(file);
        int ntest=0;

        while(scan.hasNextLine()){
            
            ntest=scan.nextInt();
            
            for(int q=0;q<ntest;q++){
                int n=0,m=0;
                String s="";

                s=scan.next();
                n=scan.nextInt();
                m=scan.nextInt();
                scan.nextLine();

                board=new char[n][m];
                for(int i=0;i<n;i++){
                    int j=0;
                    String line=scan.nextLine();
                    for(char c : line.toCharArray()){
                        if(c!=' '){
                            this.board[i][j]=c;
                            j++;
                        }
                    }
                }

                sol=new int[2][s.length()];
                for(int i=0;i<s.length();i++){
                    sol[0][i]=-1;
                    sol[1][i]=-1;
                }

                this.backTrack(-1, n, m, 0, 0, s);

            }
        }

        scan.close();
        
    }

    public void processSolution(int k, int n, int m, String s){
        System.out.println("Una soluzione: ");
        for(int i=0;i<sol[0].length;i++){
            System.out.print("("+(sol[0][i]+1)+","+(sol[1][i]+1)+") ");
        }

        System.exit(0);

    }

    public void printBoard(int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf("%4d",board[i][j]);
            }
        }
    }

    public boolean isSolution(int k, String s){
        return k==s.length()-1;
    }

    public boolean isSafe(int k, int n, int m, int nX, int nY, String s){
        return (nX>=0 && nX<n && nY>=0 && nY<m && board[nX][nY]!='-' && s.charAt(k)==board[nX][nY]);
    }

    public void backTrack(int k, int n, int m,int x, int y, String s){
        
        if(isSolution(k, s)){
            processSolution(k, n, m, s);
        }else{
            k=k+1;

            for(int i=0;i<candidates[0].length;i++){

                int nX=x+candidates[0][i];
                int nY=y+candidates[1][i];

                if(isSafe(k,n, m,nX,nY,s)){
                    char temp=board[x][y];
                    board[x][y]='-';
                    sol[0][k]=nX;
                    sol[1][k]=nY;
                    backTrack(k, n, m, nX, nY, s);
                    board[x][y]=temp;
                    sol[0][k]=-1;
                    sol[1][k]=-1;
                }
            }

        }

    }

    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Ruzzle\\src\\testFile.txt");
        Ruzzle ruzzle=new Ruzzle();
        ruzzle.generateSolution(file);
    }
}
