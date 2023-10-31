package BubbleSortP;

public class BubbleSort {

    private int[] array;
    private int indexDividi;
    private int numeroScambi; //variabile per homework, riporta il numero di scambi

    public BubbleSort(){
    }

    public BubbleSort(int[] a){
        this.array=a;
        this.numeroScambi=0;
        this.indexDividi=this.array.length;
    }

    public void recall(){

        //indice utilizzato per passo base, ovvero quando rimane un elemento non sorted
        //l'ultimo elemento sarà per forza il più piccolo
        if(this.indexDividi!=0){
        
            //riporto numero scambi per singola chiamata
            int temp=sort();

            //aggiorno il contatore totale del numero scambi
            numeroScambi+=temp;

            //diminuisco l'indice di dividi
            this.indexDividi=this.indexDividi-1;

            //richiamo ricorsivamente dividi
            this.recall();

        }
        
    }

    private int sort(){

        int scambi=0;

        for(int i=0;i<indexDividi-1;i++){
        
            //controllo se devo fare lo swap
            if(array[i]>array[i+1]){
                
                //scambio se l'elemento precedente è più grande del successivo
                int temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;

                //aumento il numero di scambi
                scambi=scambi+1;
            }

        }

        return scambi;
    
    }

    public void print(){
    
        for(int i : array){
            System.out.print(i+" ");
        }

        System.out.println("");
    
    }

    public void resetBubble(int[] a){
        this.array=a;
        this.numeroScambi=0;
        this.indexDividi=this.array.length;
    }

    public int getScambi(){
        return numeroScambi;
    }


    public static void main(String[] args){
    
        int[] array={9,1,0,5,4};
        BubbleSort bubble=new BubbleSort(array);

        System.out.println("Array prima di essere ordinato: ");
        bubble.print();

        //faccio partire algoritmo
        bubble.recall();

        System.out.println("Array dopo essere ordinato: ");
        bubble.print();
        System.out.println("Numero scambi necessari per ordinare: "+bubble.getScambi());

    }


}