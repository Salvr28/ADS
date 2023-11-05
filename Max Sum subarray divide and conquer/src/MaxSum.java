public class MaxSum {

    public int[] findMaxSub(int[] a, int p, int r){

        int[] res=new int[3];
        
        if(p<r){
        
            int mid=(p+r)/2;

            int[] maxLeft=findMaxSub(a, p, mid);
            int[] maxRight=findMaxSub(a, mid+1, r);
            int[] maxCross=findMaxCross(a,p,mid,r);

            //controllo la più grande delle tre somme
            if(maxLeft[2]>maxRight[2] && maxLeft[2]>maxCross[2]){
                res=maxLeft;
            }else if(maxRight[2]>maxLeft[2] && maxRight[2]>maxCross[2]){
                res=maxRight;
            }else if(maxCross[2]>maxLeft[2] && maxCross[2]>maxRight[2]){
                res=maxCross;
            }

        }else{

            //caso base un solo elemento
            int[] single={p,r,a[p]};
            res=single;
        }

        return res;

    }

    public int[] findMaxCross(int[] a, int p, int mid, int r){

        int[] res=new int[3];
        int sum=0;
        int rightSum=a[mid+1];
        int leftSum=a[mid];
        int maxLeft=mid;
        int maxRight=mid+1;

        for(int i=mid;i>=p;i--){

            sum +=a[i];
            
            //aggiorno la somma di sinistra se è diventata più grande 
            if(sum>leftSum){
                leftSum=sum;
                maxLeft=i;
            }

        }

        //riazzero sum tra una ricerca e l'altra
        sum=0;

        for(int i=mid+1;i<=r;i++){

            sum +=a[i];
            
            //aggiorno la somma di sinistra se è diventata più grande 
            if(sum>rightSum){
                rightSum=sum;
                maxRight=i;
            }

        }

        res[0]=maxLeft;
        res[1]=maxRight;
        res[2]=leftSum+rightSum;

        return res;
        
    }

    public void printArr(int[] a){
        System.out.println("Array: ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int[] a1={-1,-3,4,2,72,15};
        int[] a2={-1,2,-5,7};

        int[] r1=new int[3];
        int[] r2=new int[3];

        MaxSum m=new MaxSum();

        m.printArr(a1);
        m.printArr(a2);

        r1=m.findMaxSub(a1, 0, a1.length-1);
        r2=m.findMaxSub(a2, 0, a2.length-1);

        System.out.println("MaxSum trovata per a1: ");
        m.printArr(r1);
        System.out.println("MaxSum trovata per a2: ");
        m.printArr(r2);

    }
}
