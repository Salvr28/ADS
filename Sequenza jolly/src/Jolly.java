public class Jolly {

    public void isJollySequence(int[] a){
        int[] res=jollySequence(a, 0, a.length-1);

        if(res[0]==1){
            System.out.println("La sequenza è una jolly sequence!");
        }else if(res[0]==0){
            System.out.println("La sequenza NON è una jolly sequence...");
        }

    }

    public int[] jollySequence(int[] a, int p, int r){
    
        int[] res=new int[2];

        if(p<r){
            
            int mid=(p+r)/2;
            int[] s1=jollySequence(a, p, mid);
            int[] s2=jollySequence(a, mid+1, r);
            int[] sm=mergeSequence(a, p, mid, r, s1, s2);

            res=sm;
    
        //passo base un solo numero è considerato una sequenza jolly per definizione
        }else{

            int[] single=new int[2];
            single[0]=1;//di default singolo numero è jolly
            
            if(p%2==0){
                single[1]=a.length-p;//riporto quale dovrebbe essere il numero per passaggi sopra
            }else{
                single[1]=a.length-p-1;
            }

            res=single;
            
        }

        return res;

    }

    public int[] mergeSequence(int[] a, int p, int mid, int r, int[] s1, int[] s2){
    
        int[] res=new int[2];

        int diff=Math.abs(a[mid]-a[mid+1]);

        if(diff==s1[1]-1 && diff==s2[1]+1 && s1[0]==1 && s2[0]==1){
            res[0]=1;
            res[1]=diff;
        }else{
            res[0]=0;//in questo caso riporto falso
            res[1]=diff;
        }
        
        return res;

    }

    public static void main(String[] args) throws Exception {
        Jolly jolly=new Jolly();
        int[] a={1,4,2,3};
        jolly.isJollySequence(a);
    }
}
