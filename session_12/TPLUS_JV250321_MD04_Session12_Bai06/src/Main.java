import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("A101", "Hà Nội");
        map1.put("A102", "Hồ Chí Minh");

        Map<String, String> map2 = new HashMap<>();
        map2.put("A101", "Hà Nội");
        map2.put("A102", "Hồ Chí Minh");


        if (map1.equals(map2)) {
            System.out.println("Hai Map giống nhau.");
        } else {
            System.out.println("Hai Map KHÔNG giống nhau.");
        }
    }
}

