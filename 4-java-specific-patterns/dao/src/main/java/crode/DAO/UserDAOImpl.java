package crode.DAO;

import crode.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImpl implements UserDAO {

    // Database Simulation
    private Map<Integer, User> database;
    private int nextId;

    public UserDAOImpl() {
        this.database = new HashMap<>();
        this.nextId = 1;
        // Add test date
        initializeTestData();
    }

    private void initializeTestData() {
        save(new User(0, "admin", "admin@test.com"));
        save(new User(0, "user1", "user1@test.com"));
        save(new User(0, "guest", "guest@test.com"));
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(nextId++);
        }
        database.put(user.getId(), user);
        System.out.println("User saved: " + user);
    }

    @Override
    public User findById(int id) {
        User user = database.get(id);
        if (user != null) {
            System.out.println("Found user: " + user);
        } else {
            System.out.println("User with ID " + id + " not found");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>(database.values());
        System.out.println("Retrieved " + users.size() + " users");
        return users;
    }

    @Override
    public void update(User user) {
        if (database.containsKey(user.getId())) {
            database.put(user.getId(), user);
            System.out.println("User updated: " + user);
        } else {
            System.out.println("Cannot update - User with ID " + user.getId() + " not found");
        }
    }

    @Override
    public void delete(int id) {
        User removedUser = database.remove(id);
        if (removedUser != null) {
            System.out.println("User deleted: " + removedUser);
        } else {
            System.out.println("Cannot delete - User with ID " + id + " not found");
        }
    }

    @Override
    public User findByUsername(String username) {
        for (User user : database.values()) {
            if (user.getUsername().equals(username)) {
                System.out.println("Found user by username: " + user);
                return user;
            }
        }
        System.out.println("User with username '" + username + "' not found");
        return null;
    }
}
