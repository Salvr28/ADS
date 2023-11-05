package calculator;


public class PowerCalculator {

    public int power(int x, int n){
        int res;

        //caso base
        if(n==1){
            res=x;
        }else{
            
            //applichiamo una specie di dividi et impera
            if(n%2==0){
            
                //se il numero n è pari
                res=power(x, n/2)*power(x, n/2);

            }else{
            
                //se il numero n è dispari
                res=x*power(x, n/2)*power(x, n/2);

            }

        }

        return res;

    }

    public static void main(String[] args) throws Exception {
        int n=4;
        int x=4;

        PowerCalculator c=new PowerCalculator();

        int res=c.power(x, n);

        System.out.println("La potenza n: "+n+" di "+x+" è: "+res);

    }
}
