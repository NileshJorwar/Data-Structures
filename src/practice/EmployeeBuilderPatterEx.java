package src.practice;

public class EmployeeBuilderPatterEx {
    public static void main(String[] args) {
        EmployeeNT employeeNT = new EmployeeNT.EmployeeBuilder("Nilesh", "Jorwar")
                .id(12)
                .build();
        System.out.println(employeeNT);

        EmployeeCreo employeeCreo = new EmployeeCreo.EmployeeCreoBuilder()
                .empId(12)
                .build();

        System.out.println(employeeCreo);
    }
}
