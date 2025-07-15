import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Event{name='" + name + "', startDate=" + startDate.format(formatter) +
                ", endDate=" + endDate.format(formatter) + "}";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Event> eventList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        while (true) {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            if (name.isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }
            LocalDateTime startDate = null;
            while (startDate == null) {
                System.out.print("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");
                String input = scanner.nextLine().trim();
                try {
                    startDate = LocalDateTime.parse(input, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }
            LocalDateTime endDate = null;
            while (endDate == null) {
                System.out.print("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm): ");
                String input = scanner.nextLine().trim();
                try {
                    endDate = LocalDateTime.parse(input, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            } eventList.add(new Event(name, startDate, endDate));
        }
        System.out.println("\nDanh sách sự kiện:");
        for (Event event : eventList) {
            System.out.println(event);
        }
    }
}

