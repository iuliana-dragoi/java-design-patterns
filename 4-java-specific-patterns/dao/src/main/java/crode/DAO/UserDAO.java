package crode.DAO;

import crode.Model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User findById(int id);
    List<User> findAll();
    void update(User user);
    void delete(int id);
    User findByUsername(String username);
}
