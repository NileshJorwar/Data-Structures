package src.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String rebateNumber;
    int count;
    String rollNb;
    String code;
    String oldRollNb;


    public Employee(String rebateNumber, int count, String rollNb, String code, String oldRollNb) {
        this.rebateNumber = rebateNumber;
        this.count = count;
        this.rollNb = rollNb;
        this.code = code;
        this.oldRollNb = oldRollNb;
    }
}

public class StreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("AAAA", 10, "ABC", "4B", "AAA"));
        employees.add(new Employee("AAAA", -10, "ABC", "4C", "AAA"));
        employees.add(new Employee("AAAA", -20, "ABB", "4A", "111"));
        employees.add(new Employee("AAAA", -40, "ABB", "4C", "AAC"));
        employees.add(new Employee("AAAA", -40, "123", "4B", "AAC"));


        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(x -> x.rollNb));
        var l = map.values().stream()
                .filter(x -> !x.isEmpty())
                .map(x ->
                        x.stream()
                                .sorted(getComparator()
                                ).findFirst().get()).collect(Collectors.toList());
        System.out.println(l);
    }

    private static Comparator<Employee> getComparator() {
        return (o1, o2) -> {
            boolean ifFirstL = Character.isLetter(o1.oldRollNb.toCharArray()[0]);
            boolean ifSecondL = Character.isLetter(o2.oldRollNb.toCharArray()[0]);
            if (ifFirstL && !ifSecondL)
                return -1;
            else if (!ifFirstL && ifSecondL)
                return 1;
            else
                return (o1.oldRollNb).compareTo(o2.oldRollNb);

        };
    }
}