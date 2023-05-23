package src.practice;


public class EmployeeCreo {

    private final String name;
    private final long empId;
    private final long salary;
    private final String address;


    public EmployeeCreo(EmployeeCreoBuilder employeeCreoBuilder) {
        this.name = employeeCreoBuilder.name;
        this.empId = employeeCreoBuilder.empId;
        this.salary = employeeCreoBuilder.salary;
        this.address = employeeCreoBuilder.address;
    }

    public String getName() {
        return name;
    }

    public long getEmpId() {
        return empId;
    }

    public long getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee of Creo: " + this.name + ", " + this.empId + ", " + this.salary + ", " + this.address;
    }

    public static class EmployeeCreoBuilder {

        private String name;
        private long empId;
        private long salary;
        private String address;

        public EmployeeCreoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeCreoBuilder empId(long empId) {
            this.empId = empId;
            return this;
        }

        public EmployeeCreoBuilder salary(long salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeCreoBuilder address(String address) {
            this.address = address;
            return this;
        }

//        public EmployeeCreo build() {
//            EmployeeCreo employeeCreo = new EmployeeCreo(this);
//            return employeeCreo;
//        }

        public EmployeeCreo build() {
            EmployeeCreo employeeCreo = new EmployeeCreo(this);
            return employeeCreo;
        }
    }
}
