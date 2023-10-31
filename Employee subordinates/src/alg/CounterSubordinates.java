/*You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
*/
package alg;

import java.util.ArrayList;

import empl.Employee;

public class CounterSubordinates {

    public int countSub(ArrayList<Employee> l, int id){
        
        int count=0;
        int i=0;

        //trovo l'impiegato con quel'id
        for(i=0;i<l.size();i++){
            if(l.get(i).getId()==id){
                break;
            }
        }

        System.out.println("Ho cercato nella lista impiegati...");
        System.out.println("Impiegato id: "+id+" con importanza: "+l.get(i).getImportance());
        System.out.println("Esso ha "+l.get(i).getSubordinates().size()+" subordinati");

        //se l'impiegato non ha subordinati, caso base
        if(l.get(i).getSubordinates().size()!=0){
            
            //per ogni subordinato richiamo countSub 
            for(int j=0;j<l.get(i).getSubordinates().size();j++){
                count+=countSub(l,l.get(i).getSubordinates().get(j));
            }

            //dopo ricerca iterativa aggiungo anche la propria importanza
            count+=l.get(i).getImportance();

        }else{//se dimensione subordinati zero, riporto solo importanza di se stesso
            return l.get(i).getImportance();
        }

        return count;

    }

    public static void main(String[] args) throws Exception {
        
        CounterSubordinates c=new CounterSubordinates();

        ArrayList<Integer> a1=new ArrayList<Integer>();
        a1.add(2);
        a1.add(3);
        
        Employee e1=new Employee(1, 5, a1);
        Employee e2=new Employee(2, 3, new ArrayList<Integer>());
        Employee e3=new Employee(3, 3, new ArrayList<Integer>());
        
        ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println("Cerchiamo l'importanza dell'impiegato con id 1");
        System.out.println("La sua importanza è: "+c.countSub(list, 1));

    }
}
