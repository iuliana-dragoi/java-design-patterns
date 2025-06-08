package crode;

import crode.DAO.UserDAO;
import crode.DAO.UserDAOImpl;
import crode.Service.UserService;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== DAO Pattern Demo ===");

        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);

        System.out.println("\n1. Display all users:");
        userService.displayAllUsers();

        System.out.println("\n2. Create new user:");
        userService.createUser("newuser", "newuser@test.com");

        System.out.println("\n3. Try to create duplicate user:");
        userService.createUser("admin", "admin2@test.com");

        System.out.println("\n4. Find user by ID:");
        userDAO.findById(2);

        System.out.println("\n5. Find user by username:");
        userDAO.findByUsername("guest");

        System.out.println("\n6. Update user email:");
        userService.updateUserEmail(1, "admin.updated@test.com");

        System.out.println("\n7. Delete user:");
        userDAO.delete(3);

        System.out.println("\n8. Final user list:");
        userService.displayAllUsers();
    }
}
