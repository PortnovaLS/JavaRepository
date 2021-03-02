package PackageLesson4;

public class MyFourthClass {

    public static void main(String[] args) {
        Employee employee = new Employee("Ivanov", "Ivan", "manager", 7685543, 60000, 38);

        System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPosition());

        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee("Ivanov" + i, "Ivan" + i, "manager" + i, 7685543 + i, 60000 + i, 38 + i);
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i].getInfo());
            }

        }
        salaryUp(employees);
        for (int i = 0; i < employees.length; i++){
            System.out.println(employees[i].getInfo());
        }
    }
    public static void salaryUp (Employee[]employees){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 35) {
                employees[i].setSalary(employees[i].getSalary() + 10000);
            }
        }
    }

}
