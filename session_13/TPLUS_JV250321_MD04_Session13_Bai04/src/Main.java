import java.util.*;

public class Main {
    private static HashMap<String, Product> products = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            showMenu();
            System.out.print("lựa chọn của bạn: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    editProduct();
                    break;
                case "3":
                    deleteProduct();
                    break;
                case "4":
                    displayProducts();
                    break;
                case "5":
                    filterProducts();
                    break;
                case "6":
                    totalValue();
                    break;
                case "0":
                    System.out.println("tạm biệt!");
                    return;
                default:
                    System.out.println("lựa chọn không hợp lệ");
            }
        }
    }
    private static void showMenu() {
        System.out.println("\n******Hệ THỐNG QUẢN LÝ SẢN PHẨM******");
        System.out.println("1.thêm sản phẩm");
        System.out.println("2.chỉnh sửa sản phẩm");
        System.out.println("3.xóa sản pẩm");
        System.out.println("4.sản phẩm trưng bày");
        System.out.println("5.lọc sản phẩm giá > 100");
        System.out.println("6.tổng giá trị sản phẩm");
        System.out.println("0.thoát");
    }
    private static void addProduct() {
        System.out.print("nhập id sản phẩm ");
        String id = sc.nextLine();
        System.out.print("nhập tên sản phẩm ");
        String name = sc.nextLine();
        System.out.print("nhập giá sản phẩm ");
        double price = Double.parseDouble(sc.nextLine());

        products.put(id, new Product(id, name, price));
        System.out.println("thêm sản phẩm thành công");
    }
    private static void editProduct() {
        System.out.print("nhaạp id sản phẩm cần chỉnh sửa ");
        String id = sc.nextLine();

        Product p = products.get(id);
        if (p != null) {
            System.out.print("nhaập tên sản phẩm mới ");
            String newName = sc.nextLine();
            System.out.print("nhập giá sản phẩm mới ");
            double newPrice = Double.parseDouble(sc.nextLine());

            p.setName(newName);
            p.setPrice(newPrice);

            System.out.println("cập nhật thành công");
        } else {
            System.out.println("không tìm thấy sản phẩm");
        }
    }
    private static void deleteProduct() {
        System.out.print("nhập id sản phẩm muốn xóa");
        String id = sc.nextLine();
        if (products.remove(id) != null) {
            System.out.println("xóa thành công sản phẩm");
        } else {
            System.out.println("không tìm thấy sản phẩm");
        }
    }
    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("không có sản phẩm nào để hiển thị");
        } else {
            products.values().forEach(System.out::println);
        }
    }
    private static void filterProducts() {
        System.out.println("sản phẩm có giá > 100");
        products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }
    private static void totalValue() {
        double total = products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("tổng giá trị sản phẩm " + total);
    }
}

