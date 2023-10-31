package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import skylineConstructor.SkylineConstructor;
import skylineObjects.Building;
import skylineObjects.Strip;

public class TestSkyline {

    public static void main(String[] args) throws FileNotFoundException{
        
        SkylineConstructor constructor=new SkylineConstructor();
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Skyline\\src\\test\\testFile.txt");
        Scanner scan=new Scanner(file);

        int numTest;
        int numBuilding;
        int destra,sinistra,altezza;
        ArrayList<Building> edifici=new ArrayList<Building>();
        ArrayList<Strip> skyline=new ArrayList<Strip>();

        while(scan.hasNextLine()){
            numTest=scan.nextInt();
           
            for(int i=0;i<numTest;i++){
                numBuilding=scan.nextInt();

                for(int j=0;j<numBuilding;j++){
                    sinistra=scan.nextInt();
                    altezza=scan.nextInt();
                    destra=scan.nextInt();

                    Building b=new Building(sinistra, altezza, destra);

                    edifici.add(b);

                }

                skyline=constructor.mergeSortSk(edifici, 0, edifici.size()-1);
                constructor.printSkyline(skyline);

            }

        }

        scan.close();

    }
    
}
