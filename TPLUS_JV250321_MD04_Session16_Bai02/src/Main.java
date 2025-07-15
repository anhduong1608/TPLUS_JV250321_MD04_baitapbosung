

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student student = new Student(1, "Nguyễn Văn A", 21);
        manager.updateStudent(student);
    }
}

