package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import alg.Alg;

public class Test {

    public static void main(String[] args){
        
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Occorrenze intero dividi et impera\\src\\testFile.txt");
        Alg alg=new Alg();
        ArrayList<Integer> vect_occ=new ArrayList<Integer>();

        try {
            Scanner scan=new Scanner(file);

            int numTest=scan.nextInt();

            for(int i=0;i<numTest;i++){
                
                int obj=scan.nextInt();
                int len=scan.nextInt();
                int[] a=new int[len];

                for(int j=0;j<len;j++){
                    a[j]=scan.nextInt();
                }

                vect_occ.add(alg.countInt(a, 0, len-1, obj));
            }

            for(int i=0;i<vect_occ.size();i++){
                System.out.println(vect_occ.get(i));
            }

            scan.close();

        } catch (Exception e) {
            // TODO: handle exception
        }


    }
   
}
