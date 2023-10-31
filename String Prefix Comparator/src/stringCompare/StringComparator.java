package stringCompare;

public class StringComparator {

    //vi sono delle stampe commentate per debugging

    public StringComparator(){
    }

    //funzione di divisone vettore di stringhe, molto simile a quella di mergeSort
    public String divide(String[] a, int left, int right){
        
        String prefix=new String();

        if(left<right){
                    
            int med=(left+right)/2;

            String s1=divide(a,left,med);
            String s2=divide(a,med+1,right);
            //System.out.println("Devo confrontare "+s1+" e "+s2);
            prefix=findPrefix(s1,s2);

        }else{
            //passo base singola stringa, riporto la stringa stessa
            prefix=a[left];
        }

        return prefix;

    }

    //funzione che risolve il sottoproblema
    public String findPrefix(String s1, String s2){
        
        int i=0;
        String prefix="";

        int l1=s1.length();
        int l2=s2.length();
        int min=0;

        //il ciclo di confronto dovrà durare al massimo quanto la stringa più piccola
        if(l1<=l2){
            min=l1;
        }else{
            min=l2;
        }

        //System.out.println("la minima lunghezza è: "+min);

        //System.out.println("carattere s1 posto "+i+": "+s1.charAt(i));
        //System.out.println("carattere s2 posto "+i+": "+s2.charAt(i));

        //confronto carattere per carattere e aggiungo alla stringa prefix
        if(s1!=null && s2!=null){
            while(i<min && s1.charAt(i)==s2.charAt(i)){
        
                prefix=prefix+s1.charAt(i);
                //System.out.println("Aggiungo a stringa prefisso elemento: "+s1.charAt(i));
                i++;

            }
        }

        //System.out.println("prefisso in comune: "+prefix);
        return prefix;
    }

    public static void main(String[] args) {
       
        String[] arr={"apple","applied","ape","april"};

        StringComparator com=new StringComparator();

        String pref=com.divide(arr, 0, 3);

        System.out.println("Il prefisso comune è: "+pref);

    }
}
