import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Laptop", 2000);
        products.put("Smartphone", 1200);
        products.put("Headphones", 700);
        products.put("Keyboard", 400);
        products.put("Monitor", 1500);
        products.put("Mouse", 300);


        System.out.println("Các sản phẩm có giá từ 500 đến 1500:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            int price = entry.getValue();
            if (price >= 500 && price <= 1500) {
                System.out.println("Tên sản phẩm: " + entry.getKey() + " | Giá: " + price);
            }
        }
    }
}

