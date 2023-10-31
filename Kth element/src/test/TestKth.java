package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import kth.KthElement;

public class TestKth {
    public static void main(String[] args) throws FileNotFoundException{
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Kth element\\src\\KthTest.txt");
    
        KthElement el=new KthElement();
        Scanner scan=new Scanner(file);
        int numTest=0;

        while(scan.hasNextLine()){
            numTest=scan.nextInt();

            for(int i=0;i<numTest;i++){
                int kth=scan.nextInt();
                int len1=scan.nextInt();
                int[] a1=new int[len1];

                for(int j=0;j<len1;j++){
                    a1[j]=scan.nextInt();
                }

                //vado a capo per sicurezza
                scan.nextLine();

                int len2=scan.nextInt();
                int[] a2=new int[len2];
                for(int j=0;j<len2;j++){
                    a2[j]=scan.nextInt();
                }

                int res=el.kthElement(a1, a2,kth);
                System.out.println("\nElemento alla posizione "+kth+" di array finale ordinato è "+res);

            }

        }

        scan.close();
        
    }
}
