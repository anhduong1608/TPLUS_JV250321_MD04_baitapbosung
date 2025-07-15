import java.util.*;


public class Main{
    public static void main(String[]args){
        List<User> users=Arrays.asList(
                new User("alice", "alice@example.com"),
                new User("bob", "bob@example.com"),
                new User("charlie", "charlie@example.com")
        );
        Optional<User>userOptional=UserUtils.findUserByUsername(users,"bob");
        if(userOptional.isPresent()){
            System.out.println("Người dùng tìm thấy: " + userOptional.get());
        }else {
            System.out.println("không tìm thấy người dùng ");
        }
        User defaultUser=userOptional.orElse(new User("default","default@example.com"));
        System.out.println("Người dùng mặc định nếu không tìm thấy " + defaultUser);
        userOptional.ifPresent(user -> System.out.println("Email người dùng " + user.getEmail()));
    }
}
