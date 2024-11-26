////package src;
////
////import java.util.LinkedHashMap;
////import java.util.List;
////import java.util.UUID;
////import java.util.function.Function;
////import java.util.stream.Collectors;
////
////import static java.util.stream.Collectors.toList;
////
////class Employee {
////    int id;
////    String name;
////    Double salary;
////}
////
////
////class Department {
////    int deptId;
////    String deptType;
////    List<String> addresses;
////
////    public int getDeptId() {
////        return deptId;
////    }
////
////    public String getDeptType() {
////        return deptType;
////    }
////
////    public List<String> getAddresses() {
////        return addresses;
////    }
////
////    public void setDeptId(int deptId) {
////        this.deptId = deptId;
////    }
////
////    public void setDeptType(String deptType) {
////        this.deptType = deptType;
////    }
////
////    public void setAddresses(List<String> addresses) {
////        this.addresses = addresses;
////    }
////}
////
////
////
////So I have EmployeeDepartment Dataset based on Employee and Department above
////say for example:
////
//    I have below entries in dataset with Employee to Many departments as a row in dataset
//        123, "Sachin", 1220.89, [{888,"HR",["M"]},{888,"HR",["B"]},{888,"HR",["C","D"]},{888,"HR",["L"]},{888,"HR",["J","K"]},{889,"HR",["C","D"]},{887,"HR",["C","D"]}]
//        124, "Nilesh", 10.89, [{899,"HR",["K"]},{8998,"SER",["C","D"]},{888,"HR",["L"]},{888,"HR",["J","K"]},{889,"HR",["C","D"]},{887,"HR",["C","D"]}]
//        125, "Ramesh", 120.89, [{908,"HR",["M"]},{99,"HR",["B"]},{888,"HR",["C","D"]},{888,"HR",["L"]},{888,"HR",["J","K"]},{889,"HR",["C","D"]},{887,"HR",["C","D"]}]
//
//what i want simply is for each employee
//the department array should be grouped based on deptId, deptType for all addreses to join up sorted and build the results like below
//            123, "Sachin", 1220.89, [{888,"HR",["B","C","D","J","K","M"]},{889,"HR",["C","D"]},{887,"HR",["C","D"]}]
//            124, "Nilesh", 10.89, [{899,"HR",["K"]},{8998,"SER",["C","D"]},{888,"HR",["J","K","L"]},{889,"HR",["C","D"]},{887,"HR",["C","D"]}]
//
//
//
////So my result should be
////        123, "Sachin", 1220.89, [{888,"HR",["B","C","D","J","K","M"]},{889,"HR",["C","D"]},{887,"HR",["C","D"]}]
////above result is based on grouping of Departments ID and type while adding all the same groups addresses together in asceding order
////how do i achieve above like result when I have big dataset
////
////
////        {888,"HR",["M"]},
////        {888,"HR",["B"]},
////        {888,"HR",["C","D"]},
////        {888,"HR",["L"]},
////        {888,"HR",["J","K"]},
////
////        First group
////        123, "Sachin", 1220.89,    {888,"HR",["B","C","D","J","K","M"]}
////        Second group
////        123, "Sachin", 1220.89,    {889,"HR",["C","D"]},
////        THird Group
////        123, "Sachin", 1220.89,    {887,"HR",["C","D"]}
////
////        123, "Sachin", 1220.89,