import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> studentScores = new HashMap<>();

        studentScores.put("Nguyen Van A", 8.5);
        studentScores.put("Nguyen Van B", 7.0);
        studentScores.put("Nguyen Van C", 9.2);
        studentScores.put("Nguyen Van D", 6.8);
        studentScores.put("Nguyen Van E", 7.5);

        System.out.println("Danh sách học sinh và điểm số:");
        for (Map.Entry<String, Double> entry : studentScores.entrySet()) {
            System.out.println("Tên: " + entry.getKey() + " | Điểm: " + entry.getValue());
        }

        String searchName = "Nguyen Van A";
        if (studentScores.containsKey(searchName)) {
            System.out.println("\nĐiểm của " + searchName + " là: " + studentScores.get(searchName));
        } else {
            System.out.println("\nKhông tìm thấy học sinh tên " + searchName);
        }
    }
}

