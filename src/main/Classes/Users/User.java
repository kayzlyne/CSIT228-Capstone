package Users;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private static final Map<String, User> USERS = new HashMap<>();
    private static User currentUser;

    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = requireValue(name, "Name");
        this.email = normalizeEmail(email);
        this.password = requireValue(password, "Password");
    }

    public static User register(String name, String email, String password) {
        String normalizedEmail = normalizeEmail(email);

        if (USERS.containsKey(normalizedEmail)) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        User user = new User(name, normalizedEmail, password);
        USERS.put(normalizedEmail, user);
        return user;
    }

    public static boolean login(String email, String password) {
        User user = USERS.get(normalizeEmail(email));

        if (user == null || !Objects.equals(user.password, password)) {
            return false;
        }

        currentUser = user;
        return true;
    }

    public void updateProfile(String name, String email, String password) {
        String oldEmail = this.email;
        String newEmail = normalizeEmail(email);

        if (!oldEmail.equals(newEmail) && USERS.containsKey(newEmail)) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        this.name = requireValue(name, "Name");
        this.email = newEmail;

        if (password != null && !password.trim().isEmpty()) {
            this.password = password.trim();
        }

        USERS.remove(oldEmail);
        USERS.put(newEmail, this);
    }

    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private static String normalizeEmail(String email) {
        return requireValue(email, "Email").toLowerCase();
    }

    private static String requireValue(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }

        return value.trim();
    }
}
