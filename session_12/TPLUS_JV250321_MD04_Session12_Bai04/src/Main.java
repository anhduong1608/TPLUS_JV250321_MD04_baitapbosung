import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("Nguyen Van A", 7);
        map1.put("Nguyen Van B", 8);
        map1.put("Nguyen Van C", 6);

        map2.put("Nguyen Van A", 5);
        map2.put("Nguyen Van D", 9);
        map2.put("Nguyen Van C", 4);

        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();

            if (mergedMap.containsKey(name)) {
                mergedMap.put(name, mergedMap.get(name) + score);
            } else {
                mergedMap.put(name, score);
            }
        }

        System.out.println("Danh sách sinh viên sau khi gộp:");
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println("Tên: " + entry.getKey() + " | Tổng điểm: " + entry.getValue());
        }
    }
}

