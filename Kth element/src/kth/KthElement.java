package kth;
public class KthElement {

    public void mergeSort(int[] a,int p,int r){
        
        if(p<r){
            int mid=(p+r)/2;

            mergeSort(a, p, mid);
            mergeSort(a, mid+1, r);
            merge(a,p,mid,r);

        }

    }

    public void merge(int[] a, int p, int mid, int r){
        int[] left=new int[mid-p+1];
        int[] right=new int[r-mid];

        for(int i=0;i<left.length;i++){
            left[i]=a[p+i];
        }

        for(int i=0;i<right.length;i++){
            right[i]=a[mid+1+i];
        }

        int i=0,j=0,k=p;

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                a[k]=left[i];
                i++;
                k++;
            }else{
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

    public int kthElement(int[] a1, int[] a2, int kth){
        mergeSort(a1, 0, a1.length-1);
        mergeSort(a2, 0, a2.length-1);

        if(kth>a2.length+a1.length){
            return -1;
        }

        System.out.println("\nHo ordinato i vettori"); 

        System.out.println("a1: ");
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i]+" ");
        }

        System.out.println("\na2: ");
        for(int i=0;i<a2.length;i++){
            System.out.print(a2[i]+" ");
        }

        int i=0,j=0,min=0,max=0;

        
        for(int k=0;k<a1.length+a2.length;k++){
            
            //il max serve per ultimo elemento, unico caso in cui non deve prendere il minimo
            try{
            if(a1[i]<=a2[j]){
                min=a1[i];
                max=a2[j];
                i++;
            }else if(a1[i]>a2[j]){
                min=a2[j];
                max=a1[i];
                j++;
            }

            if(k==kth-1){
                return min;
            }

            }catch(ArrayIndexOutOfBoundsException e){
                return max;
            }

        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        KthElement el=new KthElement();
        
        int[] a1={2,6,3,9,7};
        int[] a2={4,1,8,10};
        int k=5,res=0;

        System.out.println("a1: ");
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i]+" ");
        }

        System.out.println("\na2: ");
        for(int i=0;i<a2.length;i++){
            System.out.print(a2[i]+" ");
        }

        System.out.println("Voglio trovare elemento posizione "+k);
        res=el.kthElement(a1, a2, k);
        System.out.println("\nDovrebbe essere "+res);


    }
}
