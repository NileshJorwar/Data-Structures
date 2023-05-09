package src.generics;

public class Salary {
    int eid;
    int salary;

    public Salary(int eid, int salary) {
        this.eid = eid;
        this.salary = salary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
