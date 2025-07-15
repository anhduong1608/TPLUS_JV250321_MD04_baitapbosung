

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập tuổi để xóa những học sinh có độ tuổi nhỏ hơn : ");
        int age = sc.nextInt();
        manager.deleteStudentsByAge(age);
    }
}
