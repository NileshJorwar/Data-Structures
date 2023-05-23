package src.practice;


public class EmployeeNT {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final long salary;
    private final String address;

    EmployeeNT(EmployeeBuilder userBuilder){
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.salary = userBuilder.salary;
        this.id = userBuilder.id;
        this.address = userBuilder.address;

    }
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User:" + this.firstName + ", " + this.lastName;
    }

    public static class EmployeeBuilder {
        private int id;
        private final String firstName;
        private final String lastName;
        private long salary;
        private String address;

        public EmployeeBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder salary(long salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public EmployeeNT build() {
            EmployeeNT user = new EmployeeNT(this);
            return user;
        }
    }
}
