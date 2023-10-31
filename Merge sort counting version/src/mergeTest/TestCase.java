package mergeTest;

import merge.MergeSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCase {
    
    public static void main(String[] args){

        //CAMBIARE PATH PER TESTING
        File f= new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Merge sort counting version\\src\\mergeTest\\testFile.txt");
        ArrayList<Integer> vettore_scambi=new ArrayList<Integer>();
        MergeSort merge=new MergeSort();

        try{
            Scanner scanFile=new Scanner(f);

            while(scanFile.hasNextLine()){

                int n=scanFile.nextInt();

                if(n==0){
                    break;
                }

                int[] ar=new int[n];

                for(int i=0;i<n;i++){
                    ar[i]=scanFile.nextInt();
                }

                vettore_scambi.add(merge.count_inversion(ar));

            }

            scanFile.close();

            System.out.println("Il vettore di scambi è: ");
            for(int i=0;i<vettore_scambi.size();i++){
                System.out.println(vettore_scambi.get(i)+" ");
            }

        }catch(IOException e){
            System.err.println("Errore nello scanner");
        }
  
    }

}
