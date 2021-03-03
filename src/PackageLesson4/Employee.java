package PackageLesson4;

public class Employee {

    private String surname;
    private String name;
    private String position;
    private int phoneNumber;
    private int salary;
    private int age;

    Employee(String surname, String name,String position,int phoneNumber,int salary,int age){
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;


    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }
    public String getInfo (){
        return " Фамилия: " + surname + " " + "Имя: " + name + " " + "Должность: " + position + " " +  "Телефон: " + phoneNumber +" " +  "Зарплата: " + salary +" " + "Возраст: "+ age;
    }
}





