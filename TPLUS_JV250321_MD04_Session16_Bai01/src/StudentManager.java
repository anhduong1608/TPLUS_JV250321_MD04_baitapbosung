import java.sql.*;
import java.util.List;

public class StudentManager {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    public void addStudents(List<Student> students) {
        String sql = "{CALL add_students(?, ?)}";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy Driver JDBC: " + e.getMessage());
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            try (CallableStatement stmt = conn.prepareCall(sql)) {
                for (Student s : students) {
                    stmt.setString(1, s.getName());
                    stmt.setInt(2, s.getAge());
                    stmt.executeUpdate();
                }

                conn.commit();
                System.out.println("thêm sinh viên thành công.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Không thể kết nối CSDL: " + e.getMessage());
        }
    }
}
