import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeSorting {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 25));
        employees.add(new Employee("Alice", 30));
        employees.add(new Employee("Bob", 25));
        employees.add(new Employee("Charlie", 30));

        employees.sort(Comparator.comparing(Employee::age).thenComparing(Employee::name));

        System.out.println(employees);
    }
}

record Employee(String name, int age) {

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + '}';
    }

}