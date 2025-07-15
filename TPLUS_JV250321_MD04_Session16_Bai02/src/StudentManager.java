

import java.sql.*;

public class StudentManager {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public void updateStudent(Student student) {
        String sql = "{CALL update_student(?, ?, ?)}";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy JDBC Driver.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, student.getId());
                stmt.setString(2, student.getName());
                stmt.setInt(3, student.getAge());

                int rowsAffected = stmt.executeUpdate();
                conn.commit();

                if (rowsAffected > 0) {
                    System.out.println("cập nhật thông tin sinh viên thành công.");
                } else {
                    System.out.println("Không tìm thấy sinh viên với ID tương ứng.");
                }
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi khi cập nhật sinh viên: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Không thể kết nối tới cơ sở dữ liệu: " + e.getMessage());
        }
    }
}

