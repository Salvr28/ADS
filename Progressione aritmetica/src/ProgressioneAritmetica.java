/*
 * Non sono convinto di questa soluzione dividi et impera
 * probabilmente aumenta ancora di più la complessità, invece di migliorare il caso base O(n)
 * da rivedere
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgressioneAritmetica {

    private boolean trovato;
    private int mancante;

    public void dividi(int[] a, int p, int r){
    
        if(p<r && !trovato){

            int mid=(p+r)/2;

            dividi(a,p,mid);
            dividi(a, mid+1, r);
            compare(a,p,mid,r);

        }

    }

    public void compare(int[] a, int p, int mid, int r){
        //supponiamo di avere due progressione aritmetiche nei sottoarray
        //quindi devo capire se l'unione delle due è una progressione
        int primo=a[p];
        int ultimo=a[r];
        int somma=((r-p+1)*(primo+ultimo))/2;
        int sommaSottoArray=0;
        
        for(int i=p;i<=r;i++){
            sommaSottoArray+=a[i];
        }

        //System.out.println();
        //System.out.println(somma);
        //System.out.println(sommaSottoArray);

        if(somma==sommaSottoArray){
            //in questo caso è una progressione e continuo la ricerca
            return;
        }else{
            //qui dentro c'è la parte mancante che in teoria sta tra mid e mid+1
            //però a parte questo si può trovare semplicemente nel seguente modo
            //riaggiorno la somma poichè suppongo che c'è un elemento in più
            int newSomma=((r-p+2)*(primo+ultimo))/2; 
            mancante=newSomma-sommaSottoArray;
            trovato=true;
            return;
        }

    }

    public void printArr(int[] a){
        System.out.println("Array: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public int getMancante(int[] a){
        mancante=0;
        trovato=false;

        dividi(a,0,a.length-1);

        return mancante;

    }

    public void findMancante(File file) throws FileNotFoundException{
        
        Scanner scan=new Scanner(file);
        int ntest=0;

        while(scan.hasNextLine()){
            
            ntest=scan.nextInt();
            int size=0;

            for(int i=0;i<ntest;i++){
                
                size=scan.nextInt();
                int[] a=new int[size];

                for(int j=0;j<size;j++){
                    a[j]=scan.nextInt();
                }

                System.out.println(this.getMancante(a));

            }

        }

        scan.close();

    }

    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Progressione aritmetica\\src\\testFile.txt");
        ProgressioneAritmetica p=new ProgressioneAritmetica();
        //int[] a={2,4,8,10,12};
        //p.printArr(a);
        //System.out.println("Mancante: "+p.getMancante(a));

        p.findMancante(file);

    }
}
