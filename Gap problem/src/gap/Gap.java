package gap;

public class Gap {

    public void findGap(int[] a){
        
        if(a[0]<a[a.length-1]){
            System.out.println("il primo elemento "+a[0]+" è minore dell'ultimo "+a[a.length-1]+" quindi sicuramente ci sarà un gap");
        }else{
            System.out.println("il primo elemento "+a[0]+" non è strettamente minore dell'ultimo "+a[a.length-1]+" quindi non è detto che ci sarà un gap");
        }

        System.out.println("Cerchiamo il GAP");

        if(gapFinder(a, 0, a.length-1)){
            System.out.println("GAP TROVATO!");
        }else{
            System.out.println("GAP NON TROVATO...");
        }

    }

    public boolean gapFinder(int[] a, int p, int r){
    
        boolean res=false;

        if(p<r){
        
            int mid=(r+p)/2;

            boolean g1=gapFinder(a, p, mid);
            boolean g2=gapFinder(a, mid+1, r);
            boolean g=gapChecker(a, p, mid, r, g1, g2);

            res=g;

        }else{
            
            //passo base devo continuare il confronto
            //quindi sempre return false 
            res=false; // potevo non fare niente ma è esplicativo

        }


        return res;

    }

    public boolean gapChecker(int[] a, int p, int mid, int r, boolean g1, boolean g2){

        boolean res=false;

        //se già uno dei due sotto vettori ha trovato il gap allora ritorno true
        if(g1 || g2){
            res=true;
        }else{
            
            //altrimenti cerco tra il mid e mid+1
            if(a[mid]<a[mid+1]){
                res=true;
            }else{
                res=false;
            }

        }

        return res;
    
    }

    public static void main(String[] args) throws Exception {
        
        int[] a={1,3,2,4,9,8};
        int[] b={4,2,3,5,1};
        int[] c={7,6,5,4,3,2};

        Gap gap=new Gap();
        gap.findGap(a);
        gap.findGap(b);
        gap.findGap(c);
    }
}
