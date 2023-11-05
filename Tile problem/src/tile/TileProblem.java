package tile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TileProblem {

    private int[][] board;
    private int len;
    private int cont;

    //per far funzionare sto coso devi partire sempre dalla posizione del sottoquadrante in cui si trova la cella vuota 
    public void fillBoard(int n, int x, int y){

        //rinizializzo ogni volta il contatore per riutilizzo futuro
        cont=0;
        
        //setto il lato della board
        len=(int) Math.pow(2, n);
        board=new int[len][len];

        //se la posizione è valida inizializzo la board
        if (isValid(n, x, y)){
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    board[i][j]=0;
                }
            }

            //setto il punto vuoto
            board[x][y]=-1;

            //la stampo per far vedere inizio
            this.printBoard();

            //e poi chiamo tile, all'inizio il sottoquadrante è l'intera matrice, quindi parto da pos iniziale
            tile(len,0,0);

        }else{
            System.out.println("Posizione inserita non valida");
        }
    }

    //passo ogni volta posizione sottoqudrante dove una cella è "riempita", si intende anche la vuota iniziale
    public void tile(int n, int x, int y){
        
        //caso base, un quadrato 2x2 con solo una casella già occupata
        if(n==2){

            //uso un place diverso qui
            cont++;
        
            //controllo tutte e quattro le caselle
            //per selezionare il sottoquadrante uso la posizione iniziale passatomi
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    
                    if(board[i][j]==0){
                        board[i][j]=cont;
                    }

                }
            }

            this.printBoard();

        }else{//Nell'else vi è il dividi et impera
        
            int xC=0,yC=0;

            //scorro il sottoquadrante per cercare cella già riempita
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    if(board[i][j]!=0){
                        xC=i;
                        yC=j;
                    }
                }
            }

            //System.out.println("xC: "+xC+" yC:"+yC);

            //come faccio a capire ora in che quadrante si trova?
            //ragiono per n/2: si trova nella seconda metà per x e y? allora 4 quadrante ecc
            //  Y=n/2
            // 1  |  2
            //---------- X=n/2
            // 3  |  4

            //chiamo place in base al quadrante passandogli le coordinate da riempire giuste
            //per le coordinate giuste basta pensare ai contorni degli n/2
            //      1    |  (n/2;n/2-1)   
            //-----------
            // (n/2-1;n/2)  (n/2;n/2)
            //esempio per il primo quadrante
            if(xC <x+n/2 && yC<y+n/2){// primo quadrante
                place(x+n/2, y+(n/2)-1, x+(n/2)-1, y+n/2, x+n/2, y+n/2);
            }else if(xC>=x+n/2 && yC<y+n/2){//terzo quadrante
                place(x + (n / 2) - 1, y + (n / 2), x + (n / 2),
                y + n / 2, x + (n / 2) - 1, y + (n / 2) - 1);
            }else if(xC<x+n/2 && yC>=y+n/2){//secondo quadrante
                place(x + n / 2, y + (n / 2) - 1, x + n / 2,
                y + n / 2, x + n / 2 - 1, y + n / 2 - 1);
            }else if(xC>=x+n/2 && yC>=y+n/2){//quarto quadrante
                place(x+(n/2)-1,y+(n/2)-1,x+(n/2)-1,y+(n/2),x+n/2,y+(n/2)-1);
            }

            //richiamo tile sui quattro sottoquadranti
            tile(n/2,x,y+n/2);
            tile(n/2,x,y);
            tile(n/2,x+n/2,y);
            tile(n/2,x+n/2,y+n/2);
        
        }

    }

    //funzione di utilità per piazzare la tile passandogli le tre coordinate
    public void place(int x1, int y1, int x2, int y2, int x3, int y3){
    
        //aumento il contatore
        cont++;

        //piazzo la tile
        board[x1][y1]=cont;
        board[x2][y2]=cont;
        board[x3][y3]=cont;

        this.printBoard();

    }

    public boolean isValid(int n, int x, int y){
        return (x>=0 && x<len && y>=0 && y<len);
    }

    public void printBoard(){
        System.out.println("Ecco la board: ");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.printf("%4d",board[i][j]);
            }
            System.out.println();
        }
    }

    public void generateSolution(File file) throws FileNotFoundException{
    
        Scanner scan=new Scanner(file);
        int nTest=0;

        while (scan.hasNextLine()) {
            
            nTest=scan.nextInt();
            int powerOfTwo=0,xEmpty=0,yEmpty=0;

            for(int i=0;i<nTest;i++){
                
                powerOfTwo=scan.nextInt();
                xEmpty=scan.nextInt();
                yEmpty=scan.nextInt();

                this.fillBoard(powerOfTwo, xEmpty, yEmpty);

            }

        }

        scan.close();

    }

    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Tile problem\\src\\tile\\testFile.txt");
        TileProblem t=new TileProblem();
        t.generateSolution(file);
        t.printBoard();

    }
}
