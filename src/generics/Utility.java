package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utility {
    private Employee employee;
    private Salary salary;

    public static Function<Employee,Salary> getsalary=employee1 -> new Salary(employee1.id,10000);

    public static void main(String[] args) {
        List<Employee> e = new ArrayList<>();
        e.add(new Employee("Shital",11,1));
        e.add(new Employee("Nilesh",13,2));
       List<Salary> salaries= e.stream().map(x->getsalary.apply(x)).collect(Collectors.toList());
      salaries.stream().forEach( s-> System.out.println(s.salary+" "+s.eid));
    }
}
