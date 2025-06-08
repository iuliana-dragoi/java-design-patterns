package crode.Service;

import crode.DAO.UserDAO;
import crode.Model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(String username, String email) {
        // Business logic - validations
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty!");
            return;
        }

        if (userDAO.findByUsername(username) != null) {
            System.out.println("Username already exists!");
            return;
        }

        User newUser = new User(0, username, email);
        userDAO.save(newUser);
    }

    public void displayAllUsers() {
        List<User> users = userDAO.findAll();
        System.out.println("\n=== All Users ===");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("==================");
    }

    public void updateUserEmail(int userId, String newEmail) {
        User user = userDAO.findById(userId);
        if (user != null) {
            user.setEmail(newEmail);
            userDAO.update(user);
        }
    }
}
