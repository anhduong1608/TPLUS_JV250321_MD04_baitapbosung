import java.util.List;
import java.util.Optional;

public class UserUtils {
    public static Optional<User> findUserByUsername(List<User> users, String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst(); // Trả về Optional<User>
    }
}

