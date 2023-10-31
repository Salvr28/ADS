package merge;

public class MergeSort {

    public MergeSort(){
    }

    public int merge(int[] a,int left, int mid, int right){
    
        int[] left_array=new int[mid-left+1];
        int[] right_array=new int[right-mid];

        for(int i=0;i<mid-left+1;i++){
            left_array[i]=a[left+i];
        }
        
        for(int j=0;j<right-mid;j++){
            right_array[j]=a[mid+j+1];
        }

        int i=0,j=0,k=left,inv_cont=0;

        while(i < left_array.length && j< right_array.length){

            if(left_array[i] <= right_array[j]){

                a[k]=left_array[i];
                i++;

            }else{
            
                a[k]=right_array[j];
                j++;
                inv_cont += left_array.length-i;

            }

            k=k+1;

        }

        while(i < left_array.length){
        
            a[k]=left_array[i];
            i++;
            k++;

        }

        while(j < right_array.length){

            a[k]=right_array[j];
            j++;
            k++;
        
        }

        return inv_cont;
    
    }

    public int mergeSortCount(int[] a, int left, int right){

        int inv_cont=0;

        if(left<right){
            
            int mid=(left+right)/2;

            inv_cont += mergeSortCount(a, left, mid);
            inv_cont += mergeSortCount(a, mid+1, right);
            inv_cont += merge(a, left, mid, right);

        }

        return inv_cont;
    
    }

    public int count_inversion(int[] a){
        return mergeSortCount(a, 0, a.length-1);
    }

    public static void main(String[] args){
    
        int[] a={9,1,0,5,4};
        MergeSort merge=new MergeSort();

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        int inv=merge.count_inversion(a);
        
        System.out.println("\nIl numero di inversioni è: "+inv);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        


    }


}
