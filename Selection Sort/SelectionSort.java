
public class SelectionSort {

    private int[] array;

    public SelectionSort(int[] a){
        this.array=a;
    }

    public void sort(){
    
        for(int i=0;i<this.array.length;i++){

            int min=i;

            for(int j=i+1;j<array.length;j++){
            
                if(array[j]<array[min]){
                
                    min=j;
                
                }

            }

            //qua avviene lo swap
            int temp=array[min];
            array[min]=array[i];
            array[i]=temp;

        }

    }

    public void arrayToString(){
    
        for(int i : array){
        
            System.out.print(i+" ");

        }

    }

    public static void main(String[] args){
    
        int[] ex={3,2,5,1,8,6};
        SelectionSort in=new SelectionSort(ex);

        System.out.println("Array iniziale: ");
        in.arrayToString();

        System.out.println("\nSorting dell'array....");
        
        in.sort();
        System.out.println("Array sorted: ");
        in.arrayToString();
    
    }

}
