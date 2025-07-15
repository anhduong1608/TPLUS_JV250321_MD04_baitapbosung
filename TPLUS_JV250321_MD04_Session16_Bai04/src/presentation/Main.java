package presentation;

import business.AccountBusiness;
import business.AccountBusinessImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountBusiness service = new AccountBusinessImpl();

        while (true) {
            System.out.println("1. Chuyển tiền\n2. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Người gửi ID: ");
                int from = Integer.parseInt(sc.nextLine());
                System.out.print("Người nhận ID: ");
                int to = Integer.parseInt(sc.nextLine());
                System.out.print("Số tiền: ");
                double amount = Double.parseDouble(sc.nextLine());
                service.transfer(from, to, amount);
            } else {
                break;
            }
        }
    }
}
