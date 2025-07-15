import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> productMap = new HashMap<>();

        productMap.put("Laptop", 1500);
        productMap.put("Phone", 1000);
        productMap.put("Tablet", 800);
        productMap.put("Monitor", 1200);
        productMap.put("Keyboard", 300);

        String maxProduct = null;
        int maxPrice = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            String product = entry.getKey();
            int price = entry.getValue();

            if (price > maxPrice) {
                maxPrice = price;
                maxProduct = product;
            }
        }

        if (maxProduct != null) {
            System.out.println("Sản phẩm có giá cao nhất là: " + maxProduct + " với giá: " + maxPrice);
        } else {
            System.out.println("Không có sản phẩm nào trong danh sách.");
        }
    }
}

