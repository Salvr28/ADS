import java.util.ArrayList;
import java.util.Scanner;

public class Distance {

    public Distance(){
    }

    public void sort(int [] a){
        
        //variabile key
        int key=0;

        //parti direttamente dal secondo elemento
        for(int i=1;i<a.length;i++){
        
            key=a[i];

            //indice dinamico per il confronto all'indietro
            int j=i-1;

            while(j>=0 && key<a[j]){
            
                //sto facendo lo swap traslando, il valore di key è salvato prima
                a[j+1]=a[j];
                j=j-1;

            }

            //ripristino il valore di key
            a[j+1]=key;
        
        }

    }

    public static int findMin(int[] a){
        
        int Dij=0;
        int somma=0;
        int puntoMedio=(a.length/2);
        int min=1000000;

        for (int i=0;i<a.length;i++){
        
            somma=0;

            for (int j=0;j<a.length;j++){
                
                Dij=Math.abs(a[i]-a[j]);
                somma += Dij;
                
            }

            if(somma < min){
                min=somma;
            }

        }

        somma=0;

        for(int i=0;i<a.length;i++){
            Dij=Math.abs(a[i]-puntoMedio);
            somma += Dij;
        }

        if(somma<min){
            min=somma;
        }

        return min;

    }

    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);

        System.out.println("inserisci numero parenti: ");
        int numParenti=scan.nextInt();

        int[] a=new int[numParenti];

        for(int i=0;i<numParenti;i++){
        
            System.out.println("inserisci il parente "+i+" dove abita: ");
            a[i]=scan.nextInt();

        }

        scan.close();

        int min=findMin(a);
        System.out.println("La distanza minima trovata è: "+min);

    }
}
