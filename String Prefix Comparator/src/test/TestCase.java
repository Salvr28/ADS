package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import stringCompare.StringComparator;

public class TestCase {
    public static void main(String[] args){

        File f= new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\String Prefix Comparator\\src\\test\\testFile.txt");
        ArrayList<String> vettore_prefissi=new ArrayList<String>();
        StringComparator comp=new StringComparator();

        try{
            Scanner scanFile=new Scanner(f);

            while(scanFile.hasNextLine()){

                int n=scanFile.nextInt();

                if(n==0){
                    break;
                }

                scanFile.nextLine(); // per avanzare dopo la lunghezza del test case

                String[] ar=new String[n];

                for(int i=0;i<n;i++){
                    ar[i]=scanFile.nextLine();
                }

                vettore_prefissi.add(comp.divide(ar,0,ar.length-1));

            }

            scanFile.close();

            System.out.println("Il vettore di prefissi è: ");
            for(int i=0;i<vettore_prefissi.size();i++){
                if(vettore_prefissi.get(i).length()!=0){
                    System.out.println(vettore_prefissi.get(i)+" ");
                }else{
                    System.out.println("nessun prefisso comune");
                }
            }

        }catch(IOException e){
            System.err.println("Errore nello scanner");
        }
  
    }
}
