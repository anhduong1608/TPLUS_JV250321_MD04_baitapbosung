import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args){
        List<Integer>numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("các số chẵn trong danh sách là ");
        numbers.stream().filter(n-> n % 2 == 0).forEach(System.out::println);
        int sum = numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println("tổng các số trong danh sách " + sum);
    }
}

