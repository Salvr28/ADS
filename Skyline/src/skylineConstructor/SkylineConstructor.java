package skylineConstructor;

import java.util.ArrayList;
import skylineObjects.Building;
import skylineObjects.Strip;

public class SkylineConstructor {
    
    public ArrayList<Strip> mergeSortSk(ArrayList<Building> a, int p, int r ){
        
        ArrayList<Strip> skyline=new ArrayList<Strip>();

        if(p<r){
            
            int mid=(p+r)/2;
            ArrayList<Strip> sk1=mergeSortSk(a, p, mid);
            ArrayList<Strip> sk2=mergeSortSk(a, mid+1, r);
            skyline=merge(sk1,sk2);

        }else{
            
            //passo base, ho un singolo building da cui costruisco le due strip che formano skyline
            Strip sinistra=new Strip(a.get(p).getLeft(),a.get(p).getHeight());
            Strip destra=new Strip(a.get(p).getRight(),0);

            skyline.add(sinistra);
            skyline.add(destra);

        }

        return skyline;

    }

    public ArrayList<Strip> merge(ArrayList<Strip> sk1, ArrayList<Strip> sk2){
        
        //System.out.println("Sono in merge e confronterò...");
        //printSkyline(sk1);
        //printSkyline(sk2);
        ArrayList<Strip> skyline=new ArrayList<Strip>();

        //variabili di lavoro
        int sizeTot=sk1.size()+sk2.size(),i=0,j=0,h1=0,h2=0,hmax=0,xnew=0;

        //scorro entrambe le skyline e faccio confronti alterni
        for(int k=0;k<sizeTot;k++){
            
            //aggiungo la strip con coordinata minore e aggiorno relativa hi 
            if(i<sk1.size() && j<sk2.size() && sk1.get(i).getX()<=sk2.get(j).getX()){
                h1=sk1.get(i).getHeight();
                xnew=sk1.get(i).getX();
                i++; //avanzo contatore su sk1
            }else if(j<sk2.size() && i<sk1.size() && sk1.get(i).getX()>sk2.get(j).getX()){
                h2=sk2.get(j).getHeight();
                xnew=sk2.get(j).getX();
                j++;
                
            //quando finiscono gli elementi di una skyline, gli altri vengono aggiunti in ordine
            }else if(j<sk2.size() && i==sk1.size()){
                h2=sk2.get(j).getHeight();
                xnew=sk2.get(j).getX();
                j++;
            }else if(i<sk1.size() && j==sk2.size()){
                h1=sk1.get(i).getHeight();
                xnew=sk1.get(i).getX();
                i++;
            }

            //System.out.println("h1: "+h1+" h2: "+h2);
            if(h1>=h2){
                hmax=h1;
            }else{
                hmax=h2;
            }

            //finalmente costruisco la strip da inserire
            skyline.add(new Strip(xnew,hmax));

        }

        //dopo la costruzione della skyline dovrei eliminare le skyline ridondanti
        //System.out.println("prima di togliere ridondanze: ");
        //printSkyline(skyline);
        skyline=removeRedundance(skyline);
        //System.out.println("Dopo rimuovere ridondanze: ");
        //printSkyline(skyline);

        return skyline;

    }

    public ArrayList<Strip> removeRedundance(ArrayList<Strip> sk){
        
        for(int i=0;i<sk.size();i++){
            for(int j=i+1;j<sk.size();j++){
                if(sk.get(i).getHeight()==sk.get(j).getHeight() && sk.get(i).getX()<sk.get(j).getX() && j==i+1){
                    sk.remove(j);
                    j--;
                }
            }
        }

        return sk;

    }

    public void printSkyline(ArrayList<Strip> sk){
        System.out.println("Ecco la skyline: ");
        for(int i=0;i<sk.size();i++){
            System.out.print("( "+sk.get(i).getX()+","+sk.get(i).getHeight()+" )");
        }
        System.out.println();
    }

    public static void main(String[] args){
        SkylineConstructor constructor=new SkylineConstructor();
        Building b1=new Building(1, 11, 5);
        Building b2=new Building(2, 6, 7);
        Building b3=new Building(3, 13, 9);

        ArrayList<Building> a=new ArrayList<Building>();
        a.add(b1);
        a.add(b2);
        a.add(b3);

        ArrayList<Strip> skyline=constructor.mergeSortSk(a, 0, a.size()-1);
        constructor.printSkyline(skyline);
    }

}
