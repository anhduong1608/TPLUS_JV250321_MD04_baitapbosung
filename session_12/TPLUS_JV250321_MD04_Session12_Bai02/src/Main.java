import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> productMap = new HashMap<>();
        productMap.put("Laptop", 1200);
        productMap.put("Phone", 800);
        productMap.put("Tablet", 1000);
        productMap.put("Monitor", 300);

        if (productMap.containsKey("Laptop")) {
            System.out.println("Sản phẩm 'Laptop' có trong danh sách.");
        } else {
            System.out.println("Sản phẩm 'Laptop' KHÔNG có trong danh sách.");
        }

        if (productMap.containsValue(1000)) {
            System.out.println("Có sản phẩm có giá là 1000.");
        } else {
            System.out.println("Không có sản phẩm nào có giá là 1000.");
        }

        System.out.println("\nDanh sách sản phẩm:");
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            System.out.println("- " + entry.getKey() + ": $" + entry.getValue());
        }
    }
}

