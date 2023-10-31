package alg;

public class Alg {

    public int countInt(int[] a, int p, int r, int obj){
        
        int cont=0;

        if(p<r){

            int mid=(p+r)/2;
        
            cont += countInt(a, p, mid, obj);
            cont += countInt(a, mid+1, r, obj);

        }else{
            
            //conteggio caso base
            if(a[p]==obj){
                return 1;
            }else{
                return 0;
            }

        }

        return cont;

    }

    //a parte mi rimplemento merge sort per ripetizione
    public void mergeSort(int[] a, int p, int r){
        if(p<r){
        
            int mid=(p+r)/2;

            mergeSort(a, p, mid);
            mergeSort(a, mid+1, r);
            merge(a,p,mid,r);

        }
    }

    public void merge(int[] a,int p,int q,int r){
        int [] left=new int[q-p+1];
        int[] right=new int[r-q];

        for(int i=0;i<left.length;i++){
            left[i]=a[p+i];
        }

        for(int i=0;i<right.length;i++){
            right[i]=a[q+1+i];
        }

        int i=0,j=0,k=p;

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                
                a[k]=left[i];
                i++;
                k++;

            }else if(left[i]>right[j]){

                a[k]=right[j];
                j++;
                k++;
            
            }
        }

        while(i<left.length){
            a[k]=left[i];
                i++;
                k++;
        }

        while(j<right.length){
            a[k]=right[j];
                j++;
                k++;
        }
    }


    public static void main(String[] args) throws Exception {
        
        Alg alg=new Alg();
        int[] a={7,4,3,2,3,5,8,9,3,3};

        System.out.println("Vettore non ordinato: ");
        for(int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
        }

        //l'ordinamento non serve per contare le occorrenze
        System.out.println("\nVettore ordinato: ");
        alg.mergeSort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
        }

        System.out.println("\nNumero di 3 nel vettore: ");
        int cont=alg.countInt(a,0,a.length-1,3);
        System.out.println(cont);

    }
}
