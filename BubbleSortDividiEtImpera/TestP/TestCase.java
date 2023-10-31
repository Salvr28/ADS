package TestP;

import java.util.ArrayList;
import java.util.Scanner;

import BubbleSortP.BubbleSort;

public class TestCase {

    static ArrayList<int[]> test;
    
    public static void main(String[] args){

        test=new ArrayList<int[]>();
        Scanner scan=new Scanner(System.in);
    
        //1 FASE: SCELTA DEL TEST CASE-----------------------------------------------
        try {

            System.out.println("Per terminare l'inserimento di array inserire quando richiesto dimensione 0 (n=0)");

            while(true){

                System.out.println("Inserire Dimensione stringa (minore di 500.000): ");
                int n=scan.nextInt();

                //caso di terminazione test case
                if (n==0){

                    System.out.println("FINE TEST CASE");
                    scan.close();

                    break;

                //decido una dimensione per un array da sortare
                }else if(n!=0 && n<500000){

                    int[] ar=new int[n];
                
                    for(int i=0;i<n;i++){
                    
                        System.out.println("Inserire elemento numero "+i+" : ");
                        ar[i]=scan.nextInt();

                    }

                    test.add(ar);

                }

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Attenzione exception da gestire");
        }

        //2 FASE: ESECUZIONE DELL'ALGORITMO------------------------------------------------------

        BubbleSort bubble=new BubbleSort();

        for(int i=0;i<test.size();i++){
            
            //per ogni array creato eseguo l'algoritmo di ordinamento
            bubble.resetBubble(test.get(i));
            System.out.println("Array prima di essere ordinato: ");
            bubble.print();
    
            //faccio partire algoritmo
            bubble.recall();
    
            System.out.println("Array dopo essere ordinato: ");
            bubble.print();
            System.out.println("Numero scambi necessari per ordinare: "+bubble.getScambi());
            System.out.println("--------------------------------------------------");

        }

    }

}
