

import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public void deleteStudentsByAge(int age) {
        String sql = "{CALL delete_students_by_age(?, ?)}";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy JDBC Driver.");
            return;
        }
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, age);
                stmt.registerOutParameter(2, Types.INTEGER);
                stmt.execute();
                int deleted = stmt.getInt(2);
                if (deleted > 0) {
                    conn.commit();
                    System.out.println("Xóa thành công " + deleted + " học sinh có tuổi nhỏ hơn : " + age);
                } else {
                    conn.rollback();
                    System.out.println("Không tìm thấy học sinh nào có tuổi nhỏ hơn : " + age);
                }
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi khi xóa sinh viên: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Không thể kết nối CSDL: " + e.getMessage());
        }
    }
}

