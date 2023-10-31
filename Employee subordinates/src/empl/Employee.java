package empl;

import java.util.ArrayList;

public class Employee {
    private int id;
    private int importance;
    private ArrayList<Integer> subordinates;

    public Employee(int id, int importance, ArrayList<Integer> sub){
        this.id=id;
        this.importance=importance;
        this.subordinates=sub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public ArrayList<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(ArrayList<Integer> subordinates) {
        this.subordinates = subordinates;
    }

    

}
