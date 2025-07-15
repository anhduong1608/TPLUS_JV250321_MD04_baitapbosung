import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 8.5),
                new Student("Charlie", 21, 7.5),
                new Student("David", 23, 9.0),
                new Student("Eve", 20, 5.5),
                new Student("Frank", 22, 8.0),
                new Student("Grace", 21, 7.0),
                new Student("Heidi", 23, 8.8),
                new Student("Ivan", 20, 6.5),
                new Student("Judy", 22, 7.2)
        );
        List<Student> filtered = students.stream().filter(s->s.getGrade()>7.0)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println("danh sách sv có điểm lớn hơn 7.0");
        for (Student s:filtered){
            s.display();
        }
    }
}
