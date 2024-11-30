import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDepartmentMapper {

    public static void main(String[] args) {
        Department department1 = new Department("D1", "Dept 1");
        Department department2 = new Department("D2", "Dept 2");
        Student student1 = new Student("S1", "student 1", 55, department1);
        Student student2 = new Student("S2", "student 2", 45, department2);

        Student student3 = new Student("S3", "student 3", 55, department1);
        Student student4 = new Student("S4", "student 4", 75, department2);

        List<Student> students = List.of(student1, student2, student3, student4);
        Map<Department, List<Student>> studentByDept = students.stream()
                .filter(s -> s.getScore() >= 50).collect(Collectors.groupingBy(Student::getDepartment));

        System.out.println(studentByDept);
    }
}

class Student {
    private String rollNumber;
    private String name;

    private Integer score;

    private Department department;
    public Student(String rollNumber, String name, Integer score, Department department) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.score = score;
        this.department = department;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", department=" + department +
                '}';
    }
}

class Department {
    private String code;
    private String name;

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
